package me.powerarc.eternalgg.game;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter
@Builder @AllArgsConstructor @NoArgsConstructor @JsonIgnoreProperties(ignoreUnknown = true)
public class GameDto {

    private long gameId;

    private long userNum;

    private String nickname;

    private short seasonId;

    private short matchingMode;

    private short matchingTeamMode;

    private short characterNum;

    private short skinCode;

    private short characterLevel;

    private short gameRank;

    private short playerKill;

    private short playerAssistant;

    private short monsterKill;

    private short bestWeapon;

    private short bestWeaponLevel;

    private short versionMajor;

    private short versionMinor;

    private String serverName;

    private short maxHp;

    private short maxSp;

    private short attackPower;

    private short defense;

    private float hpRegen;

    private float spRegen;

    private float attackSpeed;

    private float moveSpeed;

    private float outOfCombatMoveSpeed;

    private float sightRange;

    private float attackRange;

    private float criticalStrikeChance;

    private float criticalStrikeDamage;

    private float coolDownReduction;

    private float lifeSteal;

    private float amplifierToMonster;

    private float trapDamage;

    private short gainExp;

    private short duration;

    private int damageToPlayer;

    private int damageToMonster;

    private long killerUserNum;

    private short playTime;

    private short watchTime;

    private short totalTime;

    private short botAdded;

    private short Remain;

    private short restrictedAreaAccelerated;

    private short safeAreas;

    private String killer;

    private String killDetail;

    private String causeOfDeath;

    private short teamNumber;

    private short preMade;

    private double gainedNormalMmrKFactor;

    private short victory;

    private short craftUncommon;

    private short craftRare;

    private short craftEpic;

    private short craftLegend;

    private int trapDamageToPlayer;

    private int basicAttackDamageToPlayer;

    private int skillDamageToPlayer;

}
