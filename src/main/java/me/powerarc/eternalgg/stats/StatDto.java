package me.powerarc.eternalgg.stats;

import lombok.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatDto {

    private short seasonId;

    private long userNum;

    private int matchingMode;

    private int matchingTeamMode;

    private int mmr;

    private String nickname;

    private long rank;

    private long user_rank;

    private long rankSize;

    private long totalGames;

    private long totalWins;

    private float rankPercent;

    private float averageRank;

    private float averageKills;

    private float averageAssistants;

    private float averageHunts;

    private float top1;

    private float top2;

    private float top3;

    private float top5;

    private float top7;

    private List<CharacterStatDto> characterStats = new ArrayList<>();

    private List<CharacterStat> characterStat = new ArrayList<>();

    public void map(ModelMapper modelMapper) {
        this.characterStat = modelMapper.map(characterStats, new TypeToken<List<CharacterStat>>() {
        }.getType());
        for (int i = 0; i < characterStat.size(); i++) {
            characterStat.get(i).setTopThree(characterStats.get(i).getTop3());
            characterStat.get(i).setTopThreeRank(characterStats.get(i).getTop3Rate());
        }
        this.user_rank = rank;
    }


}
