package me.powerarc.eternalgg.stats;

import com.fasterxml.jackson.core.JsonProcessingException;
import me.powerarc.eternalgg.common.RestApi;
import me.powerarc.eternalgg.stats.request.response.StatResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatService {

    @Autowired
    StatRepository statRepository;

    @Autowired
    RestApi restApi;

    public List<Stat> getStats(String nickname) {
        List<Stat> byNickname = statRepository.findByNickname(nickname);

        if (byNickname.isEmpty()) {
            try {
                String userNum = restApi.getUserNum(nickname);
                List<Stat> stats = restApi.getStats(userNum, 0);
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

