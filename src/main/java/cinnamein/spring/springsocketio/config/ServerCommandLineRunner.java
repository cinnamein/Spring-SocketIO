package cinnamein.spring.springsocketio.config;

import cinnamein.spring.springsocketio.socket.SocketIOModule;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;

@RequiredArgsConstructor
public class ServerCommandLineRunner implements CommandLineRunner {

    private final SocketIOModule socketIOModule;

    @Override
    public void run(String... args) throws Exception {
        socketIOModule.startServer();
    }

}
