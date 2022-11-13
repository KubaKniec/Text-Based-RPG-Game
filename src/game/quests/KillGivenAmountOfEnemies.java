package game.quests;

import game.abstractClasses.Enemy;
import game.abstractClasses.Quest;

import java.util.ArrayList;
import java.util.List;

public class KillGivenAmountOfEnemies extends Quest {

    public KillGivenAmountOfEnemies(int reward, String name) {
        super(reward, name);
    }

    public KillGivenAmountOfEnemies() {
    }

    public List<Enemy> createEnemies (Enemy enemieType  , int ammountOfEnemies){
        List<Enemy> listOfEnemies = new ArrayList<>();
        for (int i = 0; i < ammountOfEnemies; i++) {
            var enemy = enemieType;
            listOfEnemies.add(enemy);
            }
        return listOfEnemies;
        }

    }

