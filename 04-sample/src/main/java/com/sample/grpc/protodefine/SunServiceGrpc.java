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
 * A Sun service for test.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.21.0)",
    comments = "Source: SunService.proto")
public final class SunServiceGrpc {

  private SunServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc.testing.SunService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.sample.grpc.protodefine.SunServiceProto.SunRequest,
      com.sample.grpc.protodefine.SunServiceProto.SunResponse> getUnaryRpcMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnaryRpc",
      requestType = com.sample.grpc.protodefine.SunServiceProto.SunRequest.class,
      responseType = com.sample.grpc.protodefine.SunServiceProto.SunResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sample.grpc.protodefine.SunServiceProto.SunRequest,
      com.sample.grpc.protodefine.SunServiceProto.SunResponse> getUnaryRpcMethod() {
    io.grpc.MethodDescriptor<com.sample.grpc.protodefine.SunServiceProto.SunRequest, com.sample.grpc.protodefine.SunServiceProto.SunResponse> getUnaryRpcMethod;
    if ((getUnaryRpcMethod = SunServiceGrpc.getUnaryRpcMethod) == null) {
      synchronized (SunServiceGrpc.class) {
        if ((getUnaryRpcMethod = SunServiceGrpc.getUnaryRpcMethod) == null) {
          SunServiceGrpc.getUnaryRpcMethod = getUnaryRpcMethod = 
              io.grpc.MethodDescriptor.<com.sample.grpc.protodefine.SunServiceProto.SunRequest, com.sample.grpc.protodefine.SunServiceProto.SunResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grpc.testing.SunService", "UnaryRpc"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.SunServiceProto.SunRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.SunServiceProto.SunResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SunServiceMethodDescriptorSupplier("UnaryRpc"))
                  .build();
          }
        }
     }
     return getUnaryRpcMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sample.grpc.protodefine.SunServiceProto.SunRequest,
      com.sample.grpc.protodefine.SunServiceProto.SunResponse> getClientStreamingRpcMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ClientStreamingRpc",
      requestType = com.sample.grpc.protodefine.SunServiceProto.SunRequest.class,
      responseType = com.sample.grpc.protodefine.SunServiceProto.SunResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.sample.grpc.protodefine.SunServiceProto.SunRequest,
      com.sample.grpc.protodefine.SunServiceProto.SunResponse> getClientStreamingRpcMethod() {
    io.grpc.MethodDescriptor<com.sample.grpc.protodefine.SunServiceProto.SunRequest, com.sample.grpc.protodefine.SunServiceProto.SunResponse> getClientStreamingRpcMethod;
    if ((getClientStreamingRpcMethod = SunServiceGrpc.getClientStreamingRpcMethod) == null) {
      synchronized (SunServiceGrpc.class) {
        if ((getClientStreamingRpcMethod = SunServiceGrpc.getClientStreamingRpcMethod) == null) {
          SunServiceGrpc.getClientStreamingRpcMethod = getClientStreamingRpcMethod = 
              io.grpc.MethodDescriptor.<com.sample.grpc.protodefine.SunServiceProto.SunRequest, com.sample.grpc.protodefine.SunServiceProto.SunResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "grpc.testing.SunService", "ClientStreamingRpc"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.SunServiceProto.SunRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.SunServiceProto.SunResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SunServiceMethodDescriptorSupplier("ClientStreamingRpc"))
                  .build();
          }
        }
     }
     return getClientStreamingRpcMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sample.grpc.protodefine.SunServiceProto.SunRequest,
      com.sample.grpc.protodefine.SunServiceProto.SunResponse> getServerStreamingRpcMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ServerStreamingRpc",
      requestType = com.sample.grpc.protodefine.SunServiceProto.SunRequest.class,
      responseType = com.sample.grpc.protodefine.SunServiceProto.SunResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.sample.grpc.protodefine.SunServiceProto.SunRequest,
      com.sample.grpc.protodefine.SunServiceProto.SunResponse> getServerStreamingRpcMethod() {
    io.grpc.MethodDescriptor<com.sample.grpc.protodefine.SunServiceProto.SunRequest, com.sample.grpc.protodefine.SunServiceProto.SunResponse> getServerStreamingRpcMethod;
    if ((getServerStreamingRpcMethod = SunServiceGrpc.getServerStreamingRpcMethod) == null) {
      synchronized (SunServiceGrpc.class) {
        if ((getServerStreamingRpcMethod = SunServiceGrpc.getServerStreamingRpcMethod) == null) {
          SunServiceGrpc.getServerStreamingRpcMethod = getServerStreamingRpcMethod = 
              io.grpc.MethodDescriptor.<com.sample.grpc.protodefine.SunServiceProto.SunRequest, com.sample.grpc.protodefine.SunServiceProto.SunResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "grpc.testing.SunService", "ServerStreamingRpc"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.SunServiceProto.SunRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.SunServiceProto.SunResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SunServiceMethodDescriptorSupplier("ServerStreamingRpc"))
                  .build();
          }
        }
     }
     return getServerStreamingRpcMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sample.grpc.protodefine.SunServiceProto.SunRequest,
      com.sample.grpc.protodefine.SunServiceProto.SunResponse> getBidiStreamingRpcMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BidiStreamingRpc",
      requestType = com.sample.grpc.protodefine.SunServiceProto.SunRequest.class,
      responseType = com.sample.grpc.protodefine.SunServiceProto.SunResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.sample.grpc.protodefine.SunServiceProto.SunRequest,
      com.sample.grpc.protodefine.SunServiceProto.SunResponse> getBidiStreamingRpcMethod() {
    io.grpc.MethodDescriptor<com.sample.grpc.protodefine.SunServiceProto.SunRequest, com.sample.grpc.protodefine.SunServiceProto.SunResponse> getBidiStreamingRpcMethod;
    if ((getBidiStreamingRpcMethod = SunServiceGrpc.getBidiStreamingRpcMethod) == null) {
      synchronized (SunServiceGrpc.class) {
        if ((getBidiStreamingRpcMethod = SunServiceGrpc.getBidiStreamingRpcMethod) == null) {
          SunServiceGrpc.getBidiStreamingRpcMethod = getBidiStreamingRpcMethod = 
              io.grpc.MethodDescriptor.<com.sample.grpc.protodefine.SunServiceProto.SunRequest, com.sample.grpc.protodefine.SunServiceProto.SunResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "grpc.testing.SunService", "BidiStreamingRpc"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.SunServiceProto.SunRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.SunServiceProto.SunResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SunServiceMethodDescriptorSupplier("BidiStreamingRpc"))
                  .build();
          }
        }
     }
     return getBidiStreamingRpcMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SunServiceStub newStub(io.grpc.Channel channel) {
    return new SunServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SunServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SunServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SunServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SunServiceFutureStub(channel);
  }

  /**
   * <pre>
   * A Sun service for test.
   * </pre>
   */
  public static abstract class SunServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sun unary RPC.
     * </pre>
     */
    public void unaryRpc(com.sample.grpc.protodefine.SunServiceProto.SunRequest request,
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.SunServiceProto.SunResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUnaryRpcMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sun client-to-server streaming RPC.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.SunServiceProto.SunRequest> clientStreamingRpc(
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.SunServiceProto.SunResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getClientStreamingRpcMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sun server-to-client streaming RPC.
     * </pre>
     */
    public void serverStreamingRpc(com.sample.grpc.protodefine.SunServiceProto.SunRequest request,
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.SunServiceProto.SunResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getServerStreamingRpcMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sun bidirectional streaming RPC.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.SunServiceProto.SunRequest> bidiStreamingRpc(
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.SunServiceProto.SunResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBidiStreamingRpcMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUnaryRpcMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.sample.grpc.protodefine.SunServiceProto.SunRequest,
                com.sample.grpc.protodefine.SunServiceProto.SunResponse>(
                  this, METHODID_UNARY_RPC)))
          .addMethod(
            getClientStreamingRpcMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.sample.grpc.protodefine.SunServiceProto.SunRequest,
                com.sample.grpc.protodefine.SunServiceProto.SunResponse>(
                  this, METHODID_CLIENT_STREAMING_RPC)))
          .addMethod(
            getServerStreamingRpcMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.sample.grpc.protodefine.SunServiceProto.SunRequest,
                com.sample.grpc.protodefine.SunServiceProto.SunResponse>(
                  this, METHODID_SERVER_STREAMING_RPC)))
          .addMethod(
            getBidiStreamingRpcMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.sample.grpc.protodefine.SunServiceProto.SunRequest,
                com.sample.grpc.protodefine.SunServiceProto.SunResponse>(
                  this, METHODID_BIDI_STREAMING_RPC)))
          .build();
    }
  }

  /**
   * <pre>
   * A Sun service for test.
   * </pre>
   */
  public static final class SunServiceStub extends io.grpc.stub.AbstractStub<SunServiceStub> {
    private SunServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SunServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SunServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SunServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sun unary RPC.
     * </pre>
     */
    public void unaryRpc(com.sample.grpc.protodefine.SunServiceProto.SunRequest request,
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.SunServiceProto.SunResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUnaryRpcMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sun client-to-server streaming RPC.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.SunServiceProto.SunRequest> clientStreamingRpc(
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.SunServiceProto.SunResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getClientStreamingRpcMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Sun server-to-client streaming RPC.
     * </pre>
     */
    public void serverStreamingRpc(com.sample.grpc.protodefine.SunServiceProto.SunRequest request,
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.SunServiceProto.SunResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getServerStreamingRpcMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sun bidirectional streaming RPC.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.SunServiceProto.SunRequest> bidiStreamingRpc(
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.SunServiceProto.SunResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBidiStreamingRpcMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * A Sun service for test.
   * </pre>
   */
  public static final class SunServiceBlockingStub extends io.grpc.stub.AbstractStub<SunServiceBlockingStub> {
    private SunServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SunServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SunServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SunServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sun unary RPC.
     * </pre>
     */
    public com.sample.grpc.protodefine.SunServiceProto.SunResponse unaryRpc(com.sample.grpc.protodefine.SunServiceProto.SunRequest request) {
      return blockingUnaryCall(
          getChannel(), getUnaryRpcMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sun server-to-client streaming RPC.
     * </pre>
     */
    public java.util.Iterator<com.sample.grpc.protodefine.SunServiceProto.SunResponse> serverStreamingRpc(
        com.sample.grpc.protodefine.SunServiceProto.SunRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getServerStreamingRpcMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * A Sun service for test.
   * </pre>
   */
  public static final class SunServiceFutureStub extends io.grpc.stub.AbstractStub<SunServiceFutureStub> {
    private SunServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SunServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SunServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SunServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sun unary RPC.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sample.grpc.protodefine.SunServiceProto.SunResponse> unaryRpc(
        com.sample.grpc.protodefine.SunServiceProto.SunRequest request) {
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
    private final SunServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SunServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UNARY_RPC:
          serviceImpl.unaryRpc((com.sample.grpc.protodefine.SunServiceProto.SunRequest) request,
              (io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.SunServiceProto.SunResponse>) responseObserver);
          break;
        case METHODID_SERVER_STREAMING_RPC:
          serviceImpl.serverStreamingRpc((com.sample.grpc.protodefine.SunServiceProto.SunRequest) request,
              (io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.SunServiceProto.SunResponse>) responseObserver);
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
              (io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.SunServiceProto.SunResponse>) responseObserver);
        case METHODID_BIDI_STREAMING_RPC:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bidiStreamingRpc(
              (io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.SunServiceProto.SunResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SunServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SunServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.sample.grpc.protodefine.SunServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SunService");
    }
  }

  private static final class SunServiceFileDescriptorSupplier
      extends SunServiceBaseDescriptorSupplier {
    SunServiceFileDescriptorSupplier() {}
  }

  private static final class SunServiceMethodDescriptorSupplier
      extends SunServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SunServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SunServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SunServiceFileDescriptorSupplier())
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
