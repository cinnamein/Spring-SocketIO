package cinnamein.spring.springsocketio.controller;

import cinnamein.spring.springsocketio.service.SocketIOModule;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SocketIOController {

    private final SocketIOModule module;

    @GetMapping("/{roomId}")
    public void onConnect(@PathVariable String roomId) {
        System.out.println("controller onConnection with roomId: " + roomId);
    }

    @GetMapping("/stop")
    public void onDisconnect() {
        System.out.println("controller onDisconnect");
        module.stopServer();
    }

}
