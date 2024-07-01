package cinnamein.spring.socketio.socket;

import cinnamein.spring.socketio.model.Chat;
import cinnamein.spring.socketio.model.ChatType;
import cinnamein.spring.socketio.service.ChattingService;
import com.corundumstudio.socketio.SocketIOClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SocketIOService {

    private final ChattingService chattingService;

    public void saveChat(SocketIOClient client, Chat chat) {
        Chat storedChat = chattingService.saveChats(Chat.builder()
                .chatType(ChatType.CLIENT)
                .roomId(chat.getRoomId())
                .username(chat.getUsername())
                .content(chat.getContent())
                .messageTime(Date.valueOf(String.valueOf(LocalDateTime.now())))
                .build());
        sendSocketChat(client, storedChat, chat.getRoomId());
    }

    public void saveInfoChat(SocketIOClient client, String roomId, String username, String content) {
        Chat storedChat = chattingService.saveChats(Chat.builder()
                .chatType(ChatType.SERVER)
                .roomId(roomId)
                .username(username)
                .content(content)
                .messageTime(Date.valueOf(String.valueOf(LocalDateTime.now())))
                .build());
        sendSocketChat(client, storedChat, roomId);
    }

    private void sendSocketChat(SocketIOClient client, Chat storedChat, String roomId) {
        for (SocketIOClient ioClient : client.getNamespace().getRoomOperations(roomId).getClients()) {
            if (!ioClient.getSessionId().equals(client.getSessionId())) {
                ioClient.sendEvent("read_message", storedChat);
            }
        }
    }

}
