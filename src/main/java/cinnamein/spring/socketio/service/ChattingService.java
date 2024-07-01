package cinnamein.spring.socketio.service;

import cinnamein.spring.socketio.model.Chat;
import cinnamein.spring.socketio.repository.ChattingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChattingService {

    private final ChattingRepository chattingRepository;

    public List<Chat> getChats(String roomId) {
        return chattingRepository.findByRoomId(roomId);
    }

    public Chat saveChats(Chat chat) {
        return chattingRepository.save(chat);
    }
}
