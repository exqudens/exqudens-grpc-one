package exqudens.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class HelloServer {

    public static void main(String... args) {
        try {
            Server server = ServerBuilder
                    .forPort(8080)
                    .addService(new HelloServiceImpl())
                    .build();

            server.start();
            server.awaitTermination();
        } catch (RuntimeException e) {
            throw e;
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

}
