package me.powerarc.eternalgg.game;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findByNickname(String name, Pageable pageable);
    boolean existsByNickname(String name);

    @Async
    @Override
    <S extends Game> List<S> saveAll(Iterable<S> iterable);

}
