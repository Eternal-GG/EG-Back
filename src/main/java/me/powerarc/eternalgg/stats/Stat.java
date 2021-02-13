package me.powerarc.eternalgg.stats;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter
@Builder @AllArgsConstructor @NoArgsConstructor
public class Stat {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private short seasonId;

    @Column(nullable = false)
    private long userNum;

    @Column(nullable = false)
    private short matchingMode;

    @Column(nullable = false)
    private short matchingTeamMode;

    @Column(nullable = false)
    private short mmr;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private long user_rank;

    @Column(nullable = false)
    private long rankSize;

    @Column(nullable = false)
    private long totalGames;

    @Column(nullable = false)
    private long totalWins;

    @Column(nullable = false)
    private float rankPercent;

    @Column(nullable = false)
    private float averageRank;

    @Column(nullable = false)
    private float averageKills;

    @Column(nullable = false)
    private float averageAssistants;

    @Column(nullable = false)
    private float averageHunts;

    @Column(nullable = false)
    private float top1;

    @Column(nullable = false)
    private float top2;

    @Column(nullable = false)
    private float top3;

    @Column(nullable = false)
    private float top5;

    @Column(nullable = false)
    private float top7;

    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CharacterStat> characterStat = new ArrayList<>();
}
