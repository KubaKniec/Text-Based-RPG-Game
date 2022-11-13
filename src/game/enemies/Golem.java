package game.enemies;

import game.abstractClasses.Enemy;

public class Golem extends Enemy {

    public Golem() {
        super.setName("Golem");
        super.setHealth(100);
        super.setAttack(3);
        super.setDefense(8);
        super.setGold(20);
        super.setExp(15);
    }
}
