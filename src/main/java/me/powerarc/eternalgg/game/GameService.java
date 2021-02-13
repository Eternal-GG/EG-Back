package me.powerarc.eternalgg.game;

import me.powerarc.eternalgg.common.RestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    RestApi restApi;

    public List<Game> getGames(String nickname, int page) {
        boolean exist = gameRepository.existsByNickname(nickname);
        List<Game> games = new ArrayList<>();
        if (!exist) {
            try {
                String userNum = restApi.getUserNum(nickname);
                games = restApi.getGames(userNum, "");
                System.out.println(games.get(0).getGameId());
                gameRepository.saveAll(games);
                games = games.subList(0, 20);
                return games;
            } catch (Exception e) {
                e.printStackTrace();
                return games;
            }
        }

        games = gameRepository.findByNickname(nickname, PageRequest.of(page, 20, Sort.by(Sort.Direction.DESC, "gameId")));
        return games;
    }
}
