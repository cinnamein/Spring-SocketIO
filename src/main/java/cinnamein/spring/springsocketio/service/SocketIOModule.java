package cinnamein.spring.springsocketio.service;

import com.corundumstudio.socketio.SocketIOServer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SocketIOModule {

    private final SocketIOServer socketIOServer;

    public void startServer() {
        socketIOServer.start();
    }

    public void stopServer() {
        socketIOServer.stop();
    }

}
