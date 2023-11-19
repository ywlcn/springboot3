package com.sample.grpc.protodefine;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * A Moon service for test.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.21.0)",
    comments = "Source: MoonService.proto")
public final class MoonServiceGrpc {

  private MoonServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc.testing.MoonService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.sample.grpc.protodefine.MoonServiceProto.MoonRequest,
      com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> getUnaryRpcMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnaryRpc",
      requestType = com.sample.grpc.protodefine.MoonServiceProto.MoonRequest.class,
      responseType = com.sample.grpc.protodefine.MoonServiceProto.MoonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sample.grpc.protodefine.MoonServiceProto.MoonRequest,
      com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> getUnaryRpcMethod() {
    io.grpc.MethodDescriptor<com.sample.grpc.protodefine.MoonServiceProto.MoonRequest, com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> getUnaryRpcMethod;
    if ((getUnaryRpcMethod = MoonServiceGrpc.getUnaryRpcMethod) == null) {
      synchronized (MoonServiceGrpc.class) {
        if ((getUnaryRpcMethod = MoonServiceGrpc.getUnaryRpcMethod) == null) {
          MoonServiceGrpc.getUnaryRpcMethod = getUnaryRpcMethod = 
              io.grpc.MethodDescriptor.<com.sample.grpc.protodefine.MoonServiceProto.MoonRequest, com.sample.grpc.protodefine.MoonServiceProto.MoonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grpc.testing.MoonService", "UnaryRpc"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.MoonServiceProto.MoonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.MoonServiceProto.MoonResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MoonServiceMethodDescriptorSupplier("UnaryRpc"))
                  .build();
          }
        }
     }
     return getUnaryRpcMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sample.grpc.protodefine.MoonServiceProto.MoonRequest,
      com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> getClientStreamingRpcMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ClientStreamingRpc",
      requestType = com.sample.grpc.protodefine.MoonServiceProto.MoonRequest.class,
      responseType = com.sample.grpc.protodefine.MoonServiceProto.MoonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.sample.grpc.protodefine.MoonServiceProto.MoonRequest,
      com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> getClientStreamingRpcMethod() {
    io.grpc.MethodDescriptor<com.sample.grpc.protodefine.MoonServiceProto.MoonRequest, com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> getClientStreamingRpcMethod;
    if ((getClientStreamingRpcMethod = MoonServiceGrpc.getClientStreamingRpcMethod) == null) {
      synchronized (MoonServiceGrpc.class) {
        if ((getClientStreamingRpcMethod = MoonServiceGrpc.getClientStreamingRpcMethod) == null) {
          MoonServiceGrpc.getClientStreamingRpcMethod = getClientStreamingRpcMethod = 
              io.grpc.MethodDescriptor.<com.sample.grpc.protodefine.MoonServiceProto.MoonRequest, com.sample.grpc.protodefine.MoonServiceProto.MoonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "grpc.testing.MoonService", "ClientStreamingRpc"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.MoonServiceProto.MoonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.MoonServiceProto.MoonResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MoonServiceMethodDescriptorSupplier("ClientStreamingRpc"))
                  .build();
          }
        }
     }
     return getClientStreamingRpcMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sample.grpc.protodefine.MoonServiceProto.MoonRequest,
      com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> getServerStreamingRpcMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ServerStreamingRpc",
      requestType = com.sample.grpc.protodefine.MoonServiceProto.MoonRequest.class,
      responseType = com.sample.grpc.protodefine.MoonServiceProto.MoonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.sample.grpc.protodefine.MoonServiceProto.MoonRequest,
      com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> getServerStreamingRpcMethod() {
    io.grpc.MethodDescriptor<com.sample.grpc.protodefine.MoonServiceProto.MoonRequest, com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> getServerStreamingRpcMethod;
    if ((getServerStreamingRpcMethod = MoonServiceGrpc.getServerStreamingRpcMethod) == null) {
      synchronized (MoonServiceGrpc.class) {
        if ((getServerStreamingRpcMethod = MoonServiceGrpc.getServerStreamingRpcMethod) == null) {
          MoonServiceGrpc.getServerStreamingRpcMethod = getServerStreamingRpcMethod = 
              io.grpc.MethodDescriptor.<com.sample.grpc.protodefine.MoonServiceProto.MoonRequest, com.sample.grpc.protodefine.MoonServiceProto.MoonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "grpc.testing.MoonService", "ServerStreamingRpc"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.MoonServiceProto.MoonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.MoonServiceProto.MoonResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MoonServiceMethodDescriptorSupplier("ServerStreamingRpc"))
                  .build();
          }
        }
     }
     return getServerStreamingRpcMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sample.grpc.protodefine.MoonServiceProto.MoonRequest,
      com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> getBidiStreamingRpcMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BidiStreamingRpc",
      requestType = com.sample.grpc.protodefine.MoonServiceProto.MoonRequest.class,
      responseType = com.sample.grpc.protodefine.MoonServiceProto.MoonResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.sample.grpc.protodefine.MoonServiceProto.MoonRequest,
      com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> getBidiStreamingRpcMethod() {
    io.grpc.MethodDescriptor<com.sample.grpc.protodefine.MoonServiceProto.MoonRequest, com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> getBidiStreamingRpcMethod;
    if ((getBidiStreamingRpcMethod = MoonServiceGrpc.getBidiStreamingRpcMethod) == null) {
      synchronized (MoonServiceGrpc.class) {
        if ((getBidiStreamingRpcMethod = MoonServiceGrpc.getBidiStreamingRpcMethod) == null) {
          MoonServiceGrpc.getBidiStreamingRpcMethod = getBidiStreamingRpcMethod = 
              io.grpc.MethodDescriptor.<com.sample.grpc.protodefine.MoonServiceProto.MoonRequest, com.sample.grpc.protodefine.MoonServiceProto.MoonResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "grpc.testing.MoonService", "BidiStreamingRpc"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.MoonServiceProto.MoonRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.MoonServiceProto.MoonResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MoonServiceMethodDescriptorSupplier("BidiStreamingRpc"))
                  .build();
          }
        }
     }
     return getBidiStreamingRpcMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MoonServiceStub newStub(io.grpc.Channel channel) {
    return new MoonServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MoonServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MoonServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MoonServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MoonServiceFutureStub(channel);
  }

  /**
   * <pre>
   * A Moon service for test.
   * </pre>
   */
  public static abstract class MoonServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Moon unary RPC.
     * </pre>
     */
    public void unaryRpc(com.sample.grpc.protodefine.MoonServiceProto.MoonRequest request,
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUnaryRpcMethod(), responseObserver);
    }

    /**
     * <pre>
     * Moon client-to-server streaming RPC.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.MoonServiceProto.MoonRequest> clientStreamingRpc(
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getClientStreamingRpcMethod(), responseObserver);
    }

    /**
     * <pre>
     * Moon server-to-client streaming RPC.
     * </pre>
     */
    public void serverStreamingRpc(com.sample.grpc.protodefine.MoonServiceProto.MoonRequest request,
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getServerStreamingRpcMethod(), responseObserver);
    }

    /**
     * <pre>
     * Moon bidirectional streaming RPC.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.MoonServiceProto.MoonRequest> bidiStreamingRpc(
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBidiStreamingRpcMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUnaryRpcMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.sample.grpc.protodefine.MoonServiceProto.MoonRequest,
                com.sample.grpc.protodefine.MoonServiceProto.MoonResponse>(
                  this, METHODID_UNARY_RPC)))
          .addMethod(
            getClientStreamingRpcMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.sample.grpc.protodefine.MoonServiceProto.MoonRequest,
                com.sample.grpc.protodefine.MoonServiceProto.MoonResponse>(
                  this, METHODID_CLIENT_STREAMING_RPC)))
          .addMethod(
            getServerStreamingRpcMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.sample.grpc.protodefine.MoonServiceProto.MoonRequest,
                com.sample.grpc.protodefine.MoonServiceProto.MoonResponse>(
                  this, METHODID_SERVER_STREAMING_RPC)))
          .addMethod(
            getBidiStreamingRpcMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.sample.grpc.protodefine.MoonServiceProto.MoonRequest,
                com.sample.grpc.protodefine.MoonServiceProto.MoonResponse>(
                  this, METHODID_BIDI_STREAMING_RPC)))
          .build();
    }
  }

  /**
   * <pre>
   * A Moon service for test.
   * </pre>
   */
  public static final class MoonServiceStub extends io.grpc.stub.AbstractStub<MoonServiceStub> {
    private MoonServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MoonServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MoonServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MoonServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Moon unary RPC.
     * </pre>
     */
    public void unaryRpc(com.sample.grpc.protodefine.MoonServiceProto.MoonRequest request,
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUnaryRpcMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Moon client-to-server streaming RPC.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.MoonServiceProto.MoonRequest> clientStreamingRpc(
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getClientStreamingRpcMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Moon server-to-client streaming RPC.
     * </pre>
     */
    public void serverStreamingRpc(com.sample.grpc.protodefine.MoonServiceProto.MoonRequest request,
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getServerStreamingRpcMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Moon bidirectional streaming RPC.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.MoonServiceProto.MoonRequest> bidiStreamingRpc(
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBidiStreamingRpcMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * A Moon service for test.
   * </pre>
   */
  public static final class MoonServiceBlockingStub extends io.grpc.stub.AbstractStub<MoonServiceBlockingStub> {
    private MoonServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MoonServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MoonServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MoonServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Moon unary RPC.
     * </pre>
     */
    public com.sample.grpc.protodefine.MoonServiceProto.MoonResponse unaryRpc(com.sample.grpc.protodefine.MoonServiceProto.MoonRequest request) {
      return blockingUnaryCall(
          getChannel(), getUnaryRpcMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Moon server-to-client streaming RPC.
     * </pre>
     */
    public java.util.Iterator<com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> serverStreamingRpc(
        com.sample.grpc.protodefine.MoonServiceProto.MoonRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getServerStreamingRpcMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * A Moon service for test.
   * </pre>
   */
  public static final class MoonServiceFutureStub extends io.grpc.stub.AbstractStub<MoonServiceFutureStub> {
    private MoonServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MoonServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MoonServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MoonServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Moon unary RPC.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sample.grpc.protodefine.MoonServiceProto.MoonResponse> unaryRpc(
        com.sample.grpc.protodefine.MoonServiceProto.MoonRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUnaryRpcMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UNARY_RPC = 0;
  private static final int METHODID_SERVER_STREAMING_RPC = 1;
  private static final int METHODID_CLIENT_STREAMING_RPC = 2;
  private static final int METHODID_BIDI_STREAMING_RPC = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MoonServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MoonServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UNARY_RPC:
          serviceImpl.unaryRpc((com.sample.grpc.protodefine.MoonServiceProto.MoonRequest) request,
              (io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.MoonServiceProto.MoonResponse>) responseObserver);
          break;
        case METHODID_SERVER_STREAMING_RPC:
          serviceImpl.serverStreamingRpc((com.sample.grpc.protodefine.MoonServiceProto.MoonRequest) request,
              (io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.MoonServiceProto.MoonResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CLIENT_STREAMING_RPC:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.clientStreamingRpc(
              (io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.MoonServiceProto.MoonResponse>) responseObserver);
        case METHODID_BIDI_STREAMING_RPC:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bidiStreamingRpc(
              (io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.MoonServiceProto.MoonResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MoonServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MoonServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.sample.grpc.protodefine.MoonServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MoonService");
    }
  }

  private static final class MoonServiceFileDescriptorSupplier
      extends MoonServiceBaseDescriptorSupplier {
    MoonServiceFileDescriptorSupplier() {}
  }

  private static final class MoonServiceMethodDescriptorSupplier
      extends MoonServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MoonServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MoonServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MoonServiceFileDescriptorSupplier())
              .addMethod(getUnaryRpcMethod())
              .addMethod(getClientStreamingRpcMethod())
              .addMethod(getServerStreamingRpcMethod())
              .addMethod(getBidiStreamingRpcMethod())
              .build();
        }
      }
    }
    return result;
  }
}
