package cinnamein.spring.springsocketio.socket;

import com.corundumstudio.socketio.SocketIOServer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SocketIOModule {

    private final SocketIOServer socketIOServer;
    private final SocketIOService socketIOService;

    public void startServer() {
        socketIOServer.addListeners(socketIOService);
        socketIOServer.start();
    }

    public void stopServer() {
        socketIOServer.stop();
    }

}
