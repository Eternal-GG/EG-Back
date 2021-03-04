package me.powerarc.eternalgg.stats;

import me.powerarc.eternalgg.common.RestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatService {

    @Autowired
    StatRepository statRepository;

    @Autowired
    RestApi restApi;

    public List<Stat> getStats(String nickname, short season) {
        List<Stat> byNickname = statRepository.findByNicknameAndSeasonId(nickname ,season);
        if (byNickname.isEmpty()) {
            try {
                String userNum = restApi.getUserNum(nickname);
                List<Stat> stats = restApi.getStats(userNum, season);
                statRepository.saveAll(stats);
                return stats;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return byNickname;
    }

}

