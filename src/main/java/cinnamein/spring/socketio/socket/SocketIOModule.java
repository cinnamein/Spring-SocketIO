package cinnamein.spring.socketio.socket;

import cinnamein.spring.socketio.model.Chat;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class SocketIOModule {

    private final SocketIOServer socketIOServer;
    private final SocketIOService socketIOService;

    public SocketIOModule(SocketIOServer socketIOServer, SocketIOService socketIOService) {
        this.socketIOServer = socketIOServer;
        this.socketIOService = socketIOService;
        socketIOServer.addConnectListener(onConnected());
        socketIOServer.addDisconnectListener(onDisconnected());
        socketIOServer.addEventListener("send_message", Chat.class, onChatReceived());

        try {
            socketIOServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ConnectListener onConnected() {
        return client -> {
            var params = client.getHandshakeData().getUrlParams();
            String roomId = params.get("roomId").stream().collect(Collectors.joining());
            String username = params.get("username").stream().collect(Collectors.joining());
            String content = params.get("content").stream().collect(Collectors.joining());
            client.joinRoom(roomId);
            socketIOService.saveInfoChat(client, roomId, username, content);
        };
    }

    private DisconnectListener onDisconnected() {
        return client -> {
            var params = client.getHandshakeData().getUrlParams();
            String roomId = params.get("roomId").stream().collect(Collectors.joining());
            String username = params.get("username").stream().collect(Collectors.joining());
            String content = params.get("content").stream().collect(Collectors.joining());
            socketIOService.saveInfoChat(client, roomId, username, content);
        };
    }

    private DataListener<Chat> onChatReceived() {
        return (client, data, ackSender) -> socketIOService.saveChat(client, data);
    }

}
