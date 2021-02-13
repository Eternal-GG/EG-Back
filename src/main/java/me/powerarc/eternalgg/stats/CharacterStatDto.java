package me.powerarc.eternalgg.stats;

import lombok.*;

import javax.persistence.*;

@Getter @Setter
@Builder @NoArgsConstructor @AllArgsConstructor
public class CharacterStatDto {

    private short characterCode;

    private long totalGames;

    private long usages;

    private short maxKillings;

    private long top3;

    private long wins;

    private short top3Rate;

    private short averageRank;

}
