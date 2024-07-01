package cinnamein.spring.socketio.controller;

import cinnamein.spring.socketio.model.Chat;
import cinnamein.spring.socketio.service.ChattingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChattingController {

    private final ChattingService chattingService;

    @GetMapping("/api/v1/{roomId}")
    public ResponseEntity<List<Chat>> getChats(@PathVariable String roomId) {
        return ResponseEntity.ok(chattingService.getChats(roomId));
    }

}
