package game.enemies;


import game.Enemy;

public class Goblin extends Enemy {


    public Goblin() {
        super.setName("Goblin");
        super.setHealth(50);
        super.setAttack(4);
        super.setDefense(3);
        super.setGold(10);
        super.setExp(5);
    }
}
