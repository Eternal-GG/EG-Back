package me.powerarc.eternalgg.common;

import me.powerarc.eternalgg.game.Game;
import me.powerarc.eternalgg.game.GameRepository;
import me.powerarc.eternalgg.game.GameService;
import me.powerarc.eternalgg.stats.Stat;
import me.powerarc.eternalgg.stats.StatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


public class SimpleRunner implements ApplicationRunner {

    @Autowired
    RestApi restApi;

    @Autowired
    StatRepository statRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    GameService gameService;

    @Override
    public void run(ApplicationArguments args) {
//        List<Game> games = restApi.getGames(restApi.getUserNum("배달부박춘배"), "");
//
//        games.forEach(game -> {
//            gameRepository.save(game);
//        });
//
//        List<Stat> stats = restApi.getStats(restApi.getUserNum("배달부박춘배"), 0);
//        stats.forEach(stat -> {
//            statRepository.save(stat);
//        });

        List<Game> games = gameService.getGames("배달부박춘배", 0);
        System.out.println(games.get(0).getUserNum());
    }

}
