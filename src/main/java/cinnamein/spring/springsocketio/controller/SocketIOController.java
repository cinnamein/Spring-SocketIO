package cinnamein.spring.springsocketio.controller;

import cinnamein.spring.springsocketio.socket.SocketIOModule;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SocketIOController {

    private final SocketIOModule socketIOModule;

    @GetMapping("/start")
    public String startSocketServer() {
        socketIOModule.startServer();
        return "Socket.IO server started!";
    }

    @GetMapping("/stop")
    public String stopSocketServer() {
        socketIOModule.stopServer();
        return "Socket.IO server stopped!";
    }

}
