package me.powerarc.eternalgg.game;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity @Getter @Setter
@Builder @AllArgsConstructor @NoArgsConstructor @JsonIgnoreProperties(ignoreUnknown = true)
public class Game {

    @Id
    private long gameId;

    @Column(nullable = false)
    private long userNum;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private short seasonId;

    @Column(nullable = false)
    private short matchingMode;

    @Column(nullable = false)
    private short matchingTeamMode;

    @Column(nullable = false)
    private short characterNum;

    @Column(nullable = false)
    private short skinCode;

    @Column(nullable = false)
    private short characterLevel;

    @Column(nullable = false)
    private short gameRank;

    @Column(nullable = false)
    private short playerKill;

    @Column(nullable = false)
    private short playerAssistant;

    @Column(nullable = false)
    private short monsterKill;

    @Column(nullable = false)
    private short bestWeapon;

    @Column(nullable = false)
    private short bestWeaponLevel;

//    private MasteryLevel masteryLevel;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Equipment equipment;

    @Column(nullable = false)
    private short versionMajor;

    @Column(nullable = false)
    private short versionMinor;

    @Column(nullable = false)
    private String serverName;

    @Column(nullable = false)
    private short maxHp;

    @Column(nullable = false)
    private short maxSp;

    @Column(nullable = false)
    private short attackPower;

    @Column(nullable = false)
    private short defense;

    @Column(nullable = false)
    private float hpRegen;

    @Column(nullable = false)
    private float spRegen;

    @Column(nullable = false)
    private float attackSpeed;

    @Column(nullable = false)
    private float moveSpeed;

    @Column(nullable = false)
    private float outOfCombatMoveSpeed;

    @Column(nullable = false)
    private float sightRange;

    @Column(nullable = false)
    private float attackRange;

    @Column(nullable = false)
    private float criticalStrikeChance;

    @Column(nullable = false)
    private float criticalStrikeDamage;

    @Column(nullable = false)
    private float coolDownReduction;

    @Column(nullable = false)
    private float lifeSteal;

    @Column(nullable = false)
    private float amplifierToMonster;

    @Column(nullable = false)
    private float trapDamage;

    @Column(nullable = false)
    private short gainExp;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(nullable = false)
    private short duration;

    @Column(nullable = false)
    private int damageToPlayer;

    @Column(nullable = false)
    private int damageToMonster;

    @Column(nullable = false)
    private long killerUserNum;

    @Column(nullable = false)
    private short playTime;

    @Column(nullable = false)
    private short watchTime;

    @Column(nullable = false)
    private short totalTime;

    @Column(nullable = false)
    private short botAdded;

    @Column(nullable = false)
    private short Remain;

    @Column(nullable = false)
    private short restrictedAreaAccelerated;

    @Column(nullable = false)
    private short safeAreas;

    @Column(nullable = false)
    private String killer;

    @Column(nullable = false)
    private String killDetail;

    @Column(nullable = false)
    private String causeOfDeath;

    @Column(nullable = false)
    private short teamNumber;

    @Column(nullable = false)
    private short preMade;

    @Column(nullable = false)
    private double gainedNormalMmrKFactor;

    @Column(nullable = false)
    private short victory;

    @Column(nullable = false)
    private short craftUncommon;

    @Column(nullable = false)
    private short craftRare;

    @Column(nullable = false)
    private short craftEpic;

    @Column(nullable = false)
    private short craftLegend;

    @Column(nullable = false)
    private int trapDamageToPlayer;

    @Column(nullable = false)
    private int basicAttackDamageToPlayer;

    @Column(nullable = false)
    private int skillDamageToPlayer;

    @Column(nullable = false)
    private String skillOrder;

}
