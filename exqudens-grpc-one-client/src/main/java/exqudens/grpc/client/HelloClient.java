package exqudens.grpc.client;

import exqudens.grpc.generated.HelloRequest;
import exqudens.grpc.generated.HelloResponse;
import exqudens.grpc.generated.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloClient {

    public static void main(String... args) {
        try {
            ManagedChannel channel = ManagedChannelBuilder
                    .forAddress("localhost", 8080)
                    .usePlaintext()
                    .build();

            HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
            HelloResponse response = stub.hello(HelloRequest.newBuilder().setFirstName("AAA").build());
            System.out.println(response);
        } catch (RuntimeException e) {
            throw e;
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

}
