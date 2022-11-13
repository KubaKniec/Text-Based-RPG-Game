package game.abstractClasses;

public abstract class Enemy extends Character{
    public Enemy(String name, int health, int attack, int defense, int gold, int exp) {
        super(name, health, attack, defense, gold, exp);
    }

    public Enemy() {
        super();
    }


    @Override
    public boolean walka(Character enemy) {
        return false;
    }

}
