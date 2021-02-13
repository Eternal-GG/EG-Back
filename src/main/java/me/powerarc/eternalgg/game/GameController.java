package me.powerarc.eternalgg.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("/games/{nickname}/{page}")
    public ResponseEntity games(@PathVariable String nickname, @PathVariable int page) {
        List<Game> games = gameService.getGames(nickname, page - 1);
        if (games.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "User Not Found"));
        }
        return ResponseEntity.ok(games);
    }
}
