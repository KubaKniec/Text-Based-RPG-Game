package game.enemies;

import game.Character;
import game.Enemy;

public class Elf extends Enemy {

    public Elf() {
        super.setName("Elf");
        super.setHealth(70);
        super.setAttack(6);
        super.setDefense(4);
        super.setGold(15);
        super.setExp(10);
    }
}
