package cinnamein.spring.springsocketio.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SocketIOService {

    @OnConnect
    public void onConnect(SocketIOClient client) {
        System.out.println("Client connected: " + client.getSessionId());
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        System.out.println("Client disconnected: " + client.getSessionId());
    }

    @OnEvent("chatMessage")
    public void onChatMessage(SocketIOClient client, String message) {
        System.out.println("Received message: " + message);
    }
}

