package cinnamein.spring.springsocketio.config;

import cinnamein.spring.springsocketio.service.SocketIOModule;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServerCommandLineRunner implements CommandLineRunner {

    private final SocketIOModule socketIOModule;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("socket started");
        socketIOModule.startServer();
    }

}
