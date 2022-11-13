package game.abstractClasses;

import game.player.Player;

public abstract class Quest {
    private int reward;
    private String name;

    public Quest(int reward, String name) {
        this.reward = reward;
        this.name = name;
    }

    public Quest() {
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
