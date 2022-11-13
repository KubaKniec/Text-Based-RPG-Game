package game.player;

import game.abstractClasses.Character;
import game.Main;
import game.abstractClasses.Quest;

import java.util.Objects;


import static game.Main.wybor;

public class Player extends Character {
    private int lvl;

    public Player(String name, int attack, int defense){
        super.setName(name);
        super.setHealth(100);
        super.setAttack(attack);
        super.setDefense(defense);
        super.setGold(0);
        super.setExp(0);
        this.lvl = 0;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void lvlUp(){
        Main.clearScrean();
        System.out.println("! LVL UP !");
        System.out.println("Odnowiono hp i zwiekszono je o 10");
        setHealth(100+10*lvl);
        System.out.println(showStats());
        System.out.println("Dostajesz 2pkt umiejetnosci. Gdzie chcesz je dodac?");
        System.out.println("Wpisz atak lub obrona");
        if (Objects.equals(wybor("atak", "obrona"), "atak")){
            setAttack(getAttack()+2);
        }
        else if (Objects.equals(wybor("atak", "obrona"), "obrona")){
            setDefense(getDefense()+2);
        }
        else {
            System.out.println("COS POSZLO NIE TAK");
        }
        Main.clearScrean();
    }


    @Override
    public boolean walka(Character enemy) {
        Main.clearScrean();
        int playerAttackValue = getAttack()*2 - enemy.getDefense()/2;
        int playerDefenseValue = getDefense()/2 - enemy.getAttack()*2;
        int enemyAttackValue = enemy.getAttack()*2 - getDefense()/2;
        int enemyDfenseValue = enemy.getDefense()/2 - getAttack()*2;

        int playerHealth = getHealth();
        int enemyHealth = enemy.getHealth();
        System.out.println("....WALKA....");
        System.out.println(getName()+" vs "+enemy.getName());
        System.out.println(showStats()+"    "+enemy.showStats());
        Main.pressEnter();
        while (playerHealth>0 || enemyHealth>0){
            System.out.println("___________");
            System.out.println("Atak Gracza");
            System.out.println(getName()+" hp:"+playerHealth+"    "+enemy.getName()+" hp"+enemyHealth);
            Main.pressEnter();
            enemyHealth -= playerAttackValue-enemyDfenseValue;
            if (enemyHealth<=0){
                System.out.println("Wrog pokonany");
                setHealth(playerHealth);
                setExp(enemy.getExp());
                if(getExp()==10*lvl){
                    setExp(0);
                    lvl++;
                    lvlUp();
                    setGold(getGold()+enemy.getGold());
                }
                else if (getExp()>=10*lvl){
                    int roznica = 10*lvl - getExp();
                    setExp(roznica);
                    lvl++;
                    lvlUp();
                    setGold(getGold()+enemy.getGold());
                }
                return true;
            }
            System.out.println("___________");
            System.out.println("Atak Wroga");
            System.out.println(getName()+" hp:"+playerHealth+"    "+enemy.getName()+" hp"+enemyHealth);

            Main.pressEnter();
            playerHealth -= enemyAttackValue-playerDefenseValue;
            if (playerHealth<=0){
                System.out.println("Zostales pokonany");
                setHealth(playerHealth);
                return false;
            }
        }
        return false;
    }
}

