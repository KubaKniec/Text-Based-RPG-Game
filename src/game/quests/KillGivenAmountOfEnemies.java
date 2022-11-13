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

    public List<Enemy> createEnemies(Enemy enemieType, int ammountOfEnemies) {
        List<Enemy> listOfEnemies = new ArrayList<>();
        for (int i = 0; i < ammountOfEnemies; i++) {
            listOfEnemies.add(enemieType);
        }
        return listOfEnemies;
    }


    @Override
    public int getReward() {
        return super.getReward();
    }

    @Override
    public void setReward(int reward) {
        super.setReward(reward);
    }
}
