package me.powerarc.eternalgg.stats;

import lombok.*;

import javax.persistence.*;

@Entity @Getter @Setter
@Builder @NoArgsConstructor @AllArgsConstructor
public class CharacterStat {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private short characterCode;

    @Column(nullable = false)
    private long totalGames;

    @Column(nullable = false)
    private long usages;

    @Column(nullable = false)
    private short maxKillings;

    @Column(nullable = false)
    private long topThree;

    @Column(nullable = false)
    private long wins;

    @Column(nullable = false)
    private short topThreeRank;

    @Column(nullable = false)
    private short averageRank;
}
