package game.abstractClasses;

public abstract class Character {
    private String name;
    private int health;
    private int attack;
    private int defense;
    private int gold;
    private int exp;


    public Character(String name, int health, int attack, int defense) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public Character(String name, int health, int attack, int defense, int gold, int exp) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.gold = gold;
        this.exp = exp;
    }

    public Character() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String showStats(){
        return "|"+name+"|atak:"+attack+"|obrona:"+defense+"|"+health+"hp";
    }

    @Override
    public String toString() {
        return "|"+name+"|atak:"+attack+"|obrona:"+defense+"|";
    }

    public abstract boolean walka(Character enemy);
}
