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
 * A Earth service for test.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.21.0)",
    comments = "Source: earthService.proto")
public final class EarthServiceGrpc {

  private EarthServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc.testing.EarthService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.sample.grpc.protodefine.EarthServiceProto.EarthRequest,
      com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> getUnaryRpcMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnaryRpc",
      requestType = com.sample.grpc.protodefine.EarthServiceProto.EarthRequest.class,
      responseType = com.sample.grpc.protodefine.EarthServiceProto.EarthResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sample.grpc.protodefine.EarthServiceProto.EarthRequest,
      com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> getUnaryRpcMethod() {
    io.grpc.MethodDescriptor<com.sample.grpc.protodefine.EarthServiceProto.EarthRequest, com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> getUnaryRpcMethod;
    if ((getUnaryRpcMethod = EarthServiceGrpc.getUnaryRpcMethod) == null) {
      synchronized (EarthServiceGrpc.class) {
        if ((getUnaryRpcMethod = EarthServiceGrpc.getUnaryRpcMethod) == null) {
          EarthServiceGrpc.getUnaryRpcMethod = getUnaryRpcMethod = 
              io.grpc.MethodDescriptor.<com.sample.grpc.protodefine.EarthServiceProto.EarthRequest, com.sample.grpc.protodefine.EarthServiceProto.EarthResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grpc.testing.EarthService", "UnaryRpc"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.EarthServiceProto.EarthRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.EarthServiceProto.EarthResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EarthServiceMethodDescriptorSupplier("UnaryRpc"))
                  .build();
          }
        }
     }
     return getUnaryRpcMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sample.grpc.protodefine.EarthServiceProto.EarthRequest,
      com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> getClientStreamingRpcMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ClientStreamingRpc",
      requestType = com.sample.grpc.protodefine.EarthServiceProto.EarthRequest.class,
      responseType = com.sample.grpc.protodefine.EarthServiceProto.EarthResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.sample.grpc.protodefine.EarthServiceProto.EarthRequest,
      com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> getClientStreamingRpcMethod() {
    io.grpc.MethodDescriptor<com.sample.grpc.protodefine.EarthServiceProto.EarthRequest, com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> getClientStreamingRpcMethod;
    if ((getClientStreamingRpcMethod = EarthServiceGrpc.getClientStreamingRpcMethod) == null) {
      synchronized (EarthServiceGrpc.class) {
        if ((getClientStreamingRpcMethod = EarthServiceGrpc.getClientStreamingRpcMethod) == null) {
          EarthServiceGrpc.getClientStreamingRpcMethod = getClientStreamingRpcMethod = 
              io.grpc.MethodDescriptor.<com.sample.grpc.protodefine.EarthServiceProto.EarthRequest, com.sample.grpc.protodefine.EarthServiceProto.EarthResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "grpc.testing.EarthService", "ClientStreamingRpc"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.EarthServiceProto.EarthRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.EarthServiceProto.EarthResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EarthServiceMethodDescriptorSupplier("ClientStreamingRpc"))
                  .build();
          }
        }
     }
     return getClientStreamingRpcMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sample.grpc.protodefine.EarthServiceProto.EarthRequest,
      com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> getServerStreamingRpcMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ServerStreamingRpc",
      requestType = com.sample.grpc.protodefine.EarthServiceProto.EarthRequest.class,
      responseType = com.sample.grpc.protodefine.EarthServiceProto.EarthResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.sample.grpc.protodefine.EarthServiceProto.EarthRequest,
      com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> getServerStreamingRpcMethod() {
    io.grpc.MethodDescriptor<com.sample.grpc.protodefine.EarthServiceProto.EarthRequest, com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> getServerStreamingRpcMethod;
    if ((getServerStreamingRpcMethod = EarthServiceGrpc.getServerStreamingRpcMethod) == null) {
      synchronized (EarthServiceGrpc.class) {
        if ((getServerStreamingRpcMethod = EarthServiceGrpc.getServerStreamingRpcMethod) == null) {
          EarthServiceGrpc.getServerStreamingRpcMethod = getServerStreamingRpcMethod = 
              io.grpc.MethodDescriptor.<com.sample.grpc.protodefine.EarthServiceProto.EarthRequest, com.sample.grpc.protodefine.EarthServiceProto.EarthResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "grpc.testing.EarthService", "ServerStreamingRpc"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.EarthServiceProto.EarthRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.EarthServiceProto.EarthResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EarthServiceMethodDescriptorSupplier("ServerStreamingRpc"))
                  .build();
          }
        }
     }
     return getServerStreamingRpcMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sample.grpc.protodefine.EarthServiceProto.EarthRequest,
      com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> getBidiStreamingRpcMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BidiStreamingRpc",
      requestType = com.sample.grpc.protodefine.EarthServiceProto.EarthRequest.class,
      responseType = com.sample.grpc.protodefine.EarthServiceProto.EarthResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.sample.grpc.protodefine.EarthServiceProto.EarthRequest,
      com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> getBidiStreamingRpcMethod() {
    io.grpc.MethodDescriptor<com.sample.grpc.protodefine.EarthServiceProto.EarthRequest, com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> getBidiStreamingRpcMethod;
    if ((getBidiStreamingRpcMethod = EarthServiceGrpc.getBidiStreamingRpcMethod) == null) {
      synchronized (EarthServiceGrpc.class) {
        if ((getBidiStreamingRpcMethod = EarthServiceGrpc.getBidiStreamingRpcMethod) == null) {
          EarthServiceGrpc.getBidiStreamingRpcMethod = getBidiStreamingRpcMethod = 
              io.grpc.MethodDescriptor.<com.sample.grpc.protodefine.EarthServiceProto.EarthRequest, com.sample.grpc.protodefine.EarthServiceProto.EarthResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "grpc.testing.EarthService", "BidiStreamingRpc"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.EarthServiceProto.EarthRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sample.grpc.protodefine.EarthServiceProto.EarthResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new EarthServiceMethodDescriptorSupplier("BidiStreamingRpc"))
                  .build();
          }
        }
     }
     return getBidiStreamingRpcMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EarthServiceStub newStub(io.grpc.Channel channel) {
    return new EarthServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EarthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EarthServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EarthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EarthServiceFutureStub(channel);
  }

  /**
   * <pre>
   * A Earth service for test.
   * </pre>
   */
  public static abstract class EarthServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Earth unary RPC.
     * </pre>
     */
    public void unaryRpc(com.sample.grpc.protodefine.EarthServiceProto.EarthRequest request,
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUnaryRpcMethod(), responseObserver);
    }

    /**
     * <pre>
     * Earth client-to-server streaming RPC.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.EarthServiceProto.EarthRequest> clientStreamingRpc(
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getClientStreamingRpcMethod(), responseObserver);
    }

    /**
     * <pre>
     * Earth server-to-client streaming RPC.
     * </pre>
     */
    public void serverStreamingRpc(com.sample.grpc.protodefine.EarthServiceProto.EarthRequest request,
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getServerStreamingRpcMethod(), responseObserver);
    }

    /**
     * <pre>
     * Earth bidirectional streaming RPC.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.EarthServiceProto.EarthRequest> bidiStreamingRpc(
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBidiStreamingRpcMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUnaryRpcMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.sample.grpc.protodefine.EarthServiceProto.EarthRequest,
                com.sample.grpc.protodefine.EarthServiceProto.EarthResponse>(
                  this, METHODID_UNARY_RPC)))
          .addMethod(
            getClientStreamingRpcMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.sample.grpc.protodefine.EarthServiceProto.EarthRequest,
                com.sample.grpc.protodefine.EarthServiceProto.EarthResponse>(
                  this, METHODID_CLIENT_STREAMING_RPC)))
          .addMethod(
            getServerStreamingRpcMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.sample.grpc.protodefine.EarthServiceProto.EarthRequest,
                com.sample.grpc.protodefine.EarthServiceProto.EarthResponse>(
                  this, METHODID_SERVER_STREAMING_RPC)))
          .addMethod(
            getBidiStreamingRpcMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.sample.grpc.protodefine.EarthServiceProto.EarthRequest,
                com.sample.grpc.protodefine.EarthServiceProto.EarthResponse>(
                  this, METHODID_BIDI_STREAMING_RPC)))
          .build();
    }
  }

  /**
   * <pre>
   * A Earth service for test.
   * </pre>
   */
  public static final class EarthServiceStub extends io.grpc.stub.AbstractStub<EarthServiceStub> {
    private EarthServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EarthServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EarthServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EarthServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Earth unary RPC.
     * </pre>
     */
    public void unaryRpc(com.sample.grpc.protodefine.EarthServiceProto.EarthRequest request,
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUnaryRpcMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Earth client-to-server streaming RPC.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.EarthServiceProto.EarthRequest> clientStreamingRpc(
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getClientStreamingRpcMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Earth server-to-client streaming RPC.
     * </pre>
     */
    public void serverStreamingRpc(com.sample.grpc.protodefine.EarthServiceProto.EarthRequest request,
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getServerStreamingRpcMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Earth bidirectional streaming RPC.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.EarthServiceProto.EarthRequest> bidiStreamingRpc(
        io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBidiStreamingRpcMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * A Earth service for test.
   * </pre>
   */
  public static final class EarthServiceBlockingStub extends io.grpc.stub.AbstractStub<EarthServiceBlockingStub> {
    private EarthServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EarthServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EarthServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EarthServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Earth unary RPC.
     * </pre>
     */
    public com.sample.grpc.protodefine.EarthServiceProto.EarthResponse unaryRpc(com.sample.grpc.protodefine.EarthServiceProto.EarthRequest request) {
      return blockingUnaryCall(
          getChannel(), getUnaryRpcMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Earth server-to-client streaming RPC.
     * </pre>
     */
    public java.util.Iterator<com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> serverStreamingRpc(
        com.sample.grpc.protodefine.EarthServiceProto.EarthRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getServerStreamingRpcMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * A Earth service for test.
   * </pre>
   */
  public static final class EarthServiceFutureStub extends io.grpc.stub.AbstractStub<EarthServiceFutureStub> {
    private EarthServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EarthServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EarthServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EarthServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Earth unary RPC.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sample.grpc.protodefine.EarthServiceProto.EarthResponse> unaryRpc(
        com.sample.grpc.protodefine.EarthServiceProto.EarthRequest request) {
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
    private final EarthServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EarthServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UNARY_RPC:
          serviceImpl.unaryRpc((com.sample.grpc.protodefine.EarthServiceProto.EarthRequest) request,
              (io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.EarthServiceProto.EarthResponse>) responseObserver);
          break;
        case METHODID_SERVER_STREAMING_RPC:
          serviceImpl.serverStreamingRpc((com.sample.grpc.protodefine.EarthServiceProto.EarthRequest) request,
              (io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.EarthServiceProto.EarthResponse>) responseObserver);
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
              (io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.EarthServiceProto.EarthResponse>) responseObserver);
        case METHODID_BIDI_STREAMING_RPC:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bidiStreamingRpc(
              (io.grpc.stub.StreamObserver<com.sample.grpc.protodefine.EarthServiceProto.EarthResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class EarthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EarthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.sample.grpc.protodefine.EarthServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EarthService");
    }
  }

  private static final class EarthServiceFileDescriptorSupplier
      extends EarthServiceBaseDescriptorSupplier {
    EarthServiceFileDescriptorSupplier() {}
  }

  private static final class EarthServiceMethodDescriptorSupplier
      extends EarthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EarthServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (EarthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EarthServiceFileDescriptorSupplier())
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
