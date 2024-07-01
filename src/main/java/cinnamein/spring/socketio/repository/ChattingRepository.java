package cinnamein.spring.socketio.repository;

import cinnamein.spring.socketio.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChattingRepository extends JpaRepository<Chat, Long> {

    List<Chat> findByRoomId(String roomId);

}
