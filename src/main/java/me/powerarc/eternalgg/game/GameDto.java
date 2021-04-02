package me.powerarc.eternalgg.game;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameDto {

    private long gameId;

    private long userNum;

    private String nickname;

    private int seasonId;

    private int matchingMode;

    private int matchingTeamMode;

    private int characterNum;

    private int skinCode;

    private int characterLevel;

    private int gameRank;

    private int playerKill;

    private int playerAssistant;

    private int monsterKill;

    private int bestWeapon;

    private int bestWeaponLevel;

    private int versionMajor;

    private int versionMinor;

    private String serverName;

    private int maxHp;

    private int maxSp;

    private int attackPower;

    private int defense;

    private double hpRegen;

    private double spRegen;

    private double attackSpeed;

    private double moveSpeed;

    private double outOfCombatMoveSpeed;

    private double sightRange;

    private double attackRange;

    private double criticalStrikeChance;

    private double criticalStrikeDamage;

    private double coolDownReduction;

    private double lifeSteal;

    private double amplifierToMonster;

    private double trapDamage;

    private int gainExp;

    private int duration;

    private int damageToPlayer;

    private int damageToMonster;

    private long killerUserNum;

    private int playTime;

    private int watchTime;

    private int totalTime;

    private int botAdded;

    private int Remain;

    private int restrictedAreaAccelerated;

    private int safeAreas;

    private String killer;

    private String killDetail;

    private String causeOfDeath;

    private int teamNumber;

    private int preMade;

    private double gainedNormalMmrKFactor;

    private int victory;

    private int craftUncommon;

    private int craftRare;

    private int craftEpic;

    private int craftLegend;

    private int trapDamageToPlayer;

    private int basicAttackDamageToPlayer;

    private int skillDamageToPlayer;

}
