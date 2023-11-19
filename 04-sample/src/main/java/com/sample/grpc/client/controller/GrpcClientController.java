package com.sample.grpc.client.controller;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

//import org.dozer.Mapper;
import com.sample.grpc.protodefine.Helloworld;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.grpc.client.utl.GrpcConfig;
import com.sample.grpc.protodefine.HelloWorldGrpc;
import com.sample.grpc.protodefine.Helloworld.PerforData;
import com.sample.grpc.util.dto.UserInfo;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/grpc")
public class GrpcClientController {

	@Autowired
	GrpcConfig grpcConfig;

	private static WebClient client = WebClient.create("http://192.168.56.102:30081");

	@RequestMapping("/user")
	@ResponseBody
	public UserInfo grpc() {
		// Jmeterから受信して、gRPC通信を行う
		PerforData request = PerforData.newBuilder().setName("Tom").setAddress("Tokyo yokohama japan").setId("00000012")
				.setSex("male").setTel("090-3902-81444").build();

		PerforData res = HelloWorldGrpc.newBlockingStub(grpcConfig.getDefaultChannel()).sayPerformacne(request);

		UserInfo ret = new UserInfo();
		ret.setAddress(res.getAddress());
		ret.setId(res.getId());
		ret.setSex(res.getSex());
		ret.setName(res.getName());
		ret.setTel(res.getTel());
		return ret;
	}

	private String unary() {
		Helloworld.HelloRequest request = Helloworld.HelloRequest.newBuilder().setName("Tom").build();
		return blockingStub().sayHello(request).toString(); // message: "Hello Tom"
	}

	private String serverStreaming() {
		Helloworld.HelloRequest request = Helloworld.HelloRequest.newBuilder().setName("Tom").build();
		Iterator<Helloworld.HelloReply> replies = blockingStub().sayHelloServerStreaming(request);
		List<Helloworld.HelloReply> response = new ArrayList<>();
		while (replies.hasNext()) {
			response.add(replies.next());
		}
		return response.toString(); // [message: "Hello Tom", message: "Hello Tom", message: "Hello Tom"]
	}

	private String clientStreaming() throws Exception {
		Helloworld.HelloRequest request = Helloworld.HelloRequest.newBuilder().setName("Tom").build();
		CountDownLatch finishLatch = new CountDownLatch(1);
		List<Helloworld.HelloReply> response = new ArrayList<>();
		StreamObserver<Helloworld.HelloRequest> streamObserver = stub().sayHelloClientStreaming(new StreamObserver<Helloworld.HelloReply>() {
			@Override
			public void onNext(Helloworld.HelloReply reply) {
				response.add(reply);
			}

			@Override
			public void onError(Throwable t) {
				// ...
			}

			@Override
			public void onCompleted() {
				finishLatch.countDown();
			}
		});
		streamObserver.onNext(request);
		streamObserver.onNext(request);
		streamObserver.onNext(request);
		streamObserver.onCompleted();
		finishLatch.await(10, TimeUnit.SECONDS);
		return response.toString(); // message: "Hello [Tom, Tom, Tom]"
	}

	private String streaming() throws Exception {
		Helloworld.HelloRequest request = Helloworld.HelloRequest.newBuilder().setName("Tom").build();
		CountDownLatch finishLatch = new CountDownLatch(1);
		List<Helloworld.HelloReply> response = new ArrayList<>();
		StreamObserver<Helloworld.HelloRequest> streamObserver = stub()
				.sayHelloStreaming(new StreamObserver<Helloworld.HelloReply>() {
					@Override
					public void onNext(Helloworld.HelloReply reply) {
						response.add(reply);
					}

					@Override
					public void onError(Throwable t) {
						// ...
					}

					@Override
					public void onCompleted() {
						finishLatch.countDown();
					}
				});
		streamObserver.onNext(request);
		streamObserver.onNext(request);
		streamObserver.onNext(request);
		streamObserver.onCompleted();
		finishLatch.await(10, TimeUnit.SECONDS);
		return response.toString(); // [message: "Hello Tom" , message: "Hello Tom" , message: "Hello Tom" ,
		// message: "Hello Tom" , message: "Hello Tom" , message: "Hello Tom" , message:
		// "Hello Tom" , message: "Hello Tom" , message: "Hello Tom" ]
	}

	private HelloWorldGrpc.HelloWorldBlockingStub blockingStub() {
		return HelloWorldGrpc.newBlockingStub(grpcConfig.getDefaultChannel());
	}

	private HelloWorldGrpc.HelloWorldStub stub() {
		return HelloWorldGrpc.newStub(grpcConfig.getDefaultChannel());
	}


}
