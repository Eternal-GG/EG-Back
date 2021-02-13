package me.powerarc.eternalgg.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.powerarc.eternalgg.game.Equipment;
import me.powerarc.eternalgg.game.Game;
import me.powerarc.eternalgg.game.GameDto;
import me.powerarc.eternalgg.stats.Stat;
import me.powerarc.eternalgg.stats.StatDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class RestApi {

    private final String PREFIX = "https://open-api.bser.io/v1";
    private final String TOP = "/rank/top/";
    private final String RANK = "/rank/";
    private final String GAMES = "/user/games/";
    private final String NICKNAME = "/user/nickname?query=";
    private final String STATS = "/user/stats/";
    private final String DATA = "/data/";
    private final String USERSTATS = "userStats";
    private final String USERGAMES = "userGames";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    HttpEntity<?> entity;

    @Autowired
    SimpleDateFormat sdf;

    private ResponseEntity<Map> resultMap;

    public String getUserNum(String nickname) {
        String url = PREFIX + NICKNAME + nickname;
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();

        String result = "";
        try {
            resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);
            result = objectMapper.writeValueAsString(resultMap.getBody().get("user"));
            JSONObject jsonObject = new JSONObject(result);
            String userNum = String.valueOf(jsonObject.getInt("userNum"));
            return userNum;
        } catch (Exception e) {
            return result;
        }
    }

    public List<Stat> getStats(String userNum, int seasonId) {
        String url = PREFIX + STATS + userNum + "/" + seasonId;
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();

        List<Stat> stats = new ArrayList<>();

        String result = "";
        try {
            resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);
            result = objectMapper.writeValueAsString(resultMap.getBody().get(USERSTATS));
            StatDto[] statDto = objectMapper.readValue(result, StatDto[].class);
            Arrays.stream(statDto).forEach(dto -> {
                dto.map(modelMapper);
            });
            stats = modelMapper.map(statDto, new TypeToken<List<Stat>>() {
            }.getType());

        } catch (Exception e) {
            return stats;
        }
        return stats;
    }

    public List<Game> getGames(String userNum, String next) {
        String url = PREFIX + GAMES + userNum + next;
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();

        List<Game> games = new ArrayList<>();

        String result = "";
        try {
            resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);
            result = objectMapper.writeValueAsString(resultMap.getBody().get(USERGAMES));

            JSONObject jsonObject = new JSONObject(resultMap.getBody());
            JSONArray jsonArray = jsonObject.getJSONArray(USERGAMES);

            GameDto[] game = objectMapper.readValue(result, GameDto[].class);
            games = modelMapper.map(game, new TypeToken<List<Game>>() {
            }.getType());


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonGame = (JSONObject) jsonArray.get(i);
                JSONObject skillOrderInfo = jsonGame.getJSONObject("skillOrderInfo");
                JSONObject jsonEquipment = jsonGame.getJSONObject("equipment");
                String Date = jsonGame.getString("startDtm");

                Date date = sdf.parse(Date);
                games.get(i).setDate(date);

                Set<String> strings = jsonEquipment.keySet();
                Equipment equipments = new Equipment();
                strings.forEach(k -> {
                    Long equipment = Long.valueOf(jsonEquipment.get(k).toString());
                    switch (k) {
                    case "0":
                        equipments.setZero(equipment);
                        break;
                    case "1":
                        equipments.setOne(equipment);
                        break;
                    case "2":
                        equipments.setTwo(equipment);
                        break;
                    case "3":
                        equipments.setThree(equipment);
                        break;
                    case "4":
                        equipments.setFour(equipment);
                        break;
                    case "5":
                        equipments.setFive(equipment);
                        break;
                    default:
                        break;
                    }
                });

                games.get(i).setEquipment(equipments);

                String skillOrder = "";
                for (int j = 1; j < skillOrderInfo.length(); j++) {
                    int skillNum = (int) skillOrderInfo.get(String.valueOf(j));
                    skillNum %= 1000;
                    switch (skillNum / 100) {
                    case 1:
                        skillOrder += "P";
                        break;
                    case 2:
                        skillOrder += "Q";
                        break;
                    case 3:
                        skillOrder += "W";
                        break;
                    case 4:
                        skillOrder += "E";
                        break;
                    case 5:
                        skillOrder += "R";
                        break;
                    default:
                        break;
                    }
                }
                games.get(i).setSkillOrder(skillOrder);

            }

            next = objectMapper.writeValueAsString(resultMap.getBody().get("next"));
            if (!next.equals("null")) {
                next = "?next=" + next;
                List<Game> gameList = getGames(userNum, next);
                games.addAll(gameList);
            }

            return games;

        } catch (Exception e) {
            e.printStackTrace();
            return games;
        }
    }


}
