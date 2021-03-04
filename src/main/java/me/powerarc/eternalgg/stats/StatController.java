package me.powerarc.eternalgg.stats;

import me.powerarc.eternalgg.stats.request.response.StatResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class StatController {

    @Autowired
    StatService statService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/stat/{nickname}/{season}")
    public ResponseEntity getStat(@PathVariable String nickname, @PathVariable short season) {
        List<Stat> stats = statService.getStats(nickname, season);
        List<StatResponse> response = modelMapper.map(stats, new TypeToken<List<StatResponse>>() {
        }.getType());

        if (stats.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "User Not Found"));
        }

        return ResponseEntity.ok(response);
    }

}
