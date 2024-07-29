package cinnamein.spring.springsocketio.handler;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SocketIOHandler {

    SocketIOServer server;

    @OnConnect
    public void onConnect(SocketIOClient client) {
        System.out.println("join room");
        String roomId = client.getHandshakeData().getSingleUrlParam("roomId");
        client.joinRoom(roomId);
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        System.out.println("leave room");
        String roomId = client.getHandshakeData().getSingleUrlParam("roomId");
        client.leaveRoom(roomId);
    }

    @OnEvent("chatting")
    public void onEvent(SocketIOClient client) {
        System.out.println("onEvent");
        String roomId = client.getHandshakeData().getSingleUrlParam("roomId");
        server.getRoomOperations(roomId).sendEvent("chatting", "message");
    }

}
