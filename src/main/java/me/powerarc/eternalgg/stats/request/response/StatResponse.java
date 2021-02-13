package me.powerarc.eternalgg.stats.request.response;

import lombok.*;
import me.powerarc.eternalgg.stats.CharacterStat;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class StatResponse {

    private short seasonId;

    private long userNum;

    private short matchingMode;

    private short matchingTeamMode;

    private short mmr;

    private String nickname;

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

    private List<CharacterStat> characterStat = new ArrayList<>();
}
