package me.powerarc.eternalgg.stats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface StatRepository extends JpaRepository<Stat, Long> {

    List<Stat> findByNickname(String nickname);
    List<Stat> findByNicknameAndSeasonId(String nickname, short season);

    @Async
    @Override
    <S extends Stat> List<S> saveAll(Iterable<S> iterable);
}
