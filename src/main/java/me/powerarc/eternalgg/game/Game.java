package me.powerarc.eternalgg.game;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {

    @Id
    private long gameId;

    @Column(nullable = false)
    private long userNum;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private int seasonId;

    @Column(nullable = false)
    private int matchingMode;

    @Column(nullable = false)
    private int matchingTeamMode;

    @Column(nullable = false)
    private int characterNum;

    @Column(nullable = false)
    private int skinCode;

    @Column(nullable = false)
    private int characterLevel;

    @Column(nullable = false)
    private int gameRank;

    @Column(nullable = false)
    private int playerKill;

    @Column(nullable = false)
    private int playerAssistant;

    @Column(nullable = false)
    private int monsterKill;

    @Column(nullable = false)
    private int bestWeapon;

    @Column(nullable = false)
    private int bestWeaponLevel;

//    private MasteryLevel masteryLevel;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Equipment equipment;

    @Column(nullable = false)
    private int versionMajor;

    @Column(nullable = false)
    private int versionMinor;

    @Column(nullable = false)
    private String serverName;

    @Column(nullable = false)
    private int maxHp;

    @Column(nullable = false)
    private int maxSp;

    @Column(nullable = false)
    private int attackPower;

    @Column(nullable = false)
    private int defense;

    @Column(nullable = false)
    private double hpRegen;

    @Column(nullable = false)
    private double spRegen;

    @Column(nullable = false)
    private double attackSpeed;

    @Column(nullable = false)
    private double moveSpeed;

    @Column(nullable = false)
    private double outOfCombatMoveSpeed;

    @Column(nullable = false)
    private double sightRange;

    @Column(nullable = false)
    private double attackRange;

    @Column(nullable = false)
    private double criticalStrikeChance;

    @Column(nullable = false)
    private double criticalStrikeDamage;

    @Column(nullable = false)
    private double coolDownReduction;

    @Column(nullable = false)
    private double lifeSteal;

    @Column(nullable = false)
    private double amplifierToMonster;

    @Column(nullable = false)
    private double trapDamage;

    @Column(nullable = false)
    private int gainExp;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private int damageToPlayer;

    @Column(nullable = false)
    private int damageToMonster;

    @Column(nullable = false)
    private long killerUserNum;

    @Column(nullable = false)
    private int playTime;

    @Column(nullable = false)
    private int watchTime;

    @Column(nullable = false)
    private int totalTime;

    @Column(nullable = false)
    private int botAdded;

    @Column(nullable = false)
    private int Remain;

    @Column(nullable = false)
    private int restrictedAreaAccelerated;

    @Column(nullable = false)
    private int safeAreas;

    @Column(nullable = false)
    private String killer;

    @Column(nullable = false)
    private String killDetail;

    @Column(nullable = false)
    private String causeOfDeath;

    @Column(nullable = false)
    private int teamNumber;

    @Column(nullable = false)
    private int preMade;

    @Column(nullable = false)
    private double gainedNormalMmrKFactor;

    @Column(nullable = false)
    private int victory;

    @Column(nullable = false)
    private int craftUncommon;

    @Column(nullable = false)
    private int craftRare;

    @Column(nullable = false)
    private int craftEpic;

    @Column(nullable = false)
    private int craftLegend;

    @Column(nullable = false)
    private int trapDamageToPlayer;

    @Column(nullable = false)
    private int basicAttackDamageToPlayer;

    @Column(nullable = false)
    private int skillDamageToPlayer;

    @Column(nullable = false)
    private String skillOrder;
}
