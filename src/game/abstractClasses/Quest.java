package game.abstractClasses;

public abstract class Quest {
    private int reward;
    private String name;

    public Quest(int reward, String name) {
        this.reward = reward;
        this.name = name;
    }

    public Quest() {
    }
}
