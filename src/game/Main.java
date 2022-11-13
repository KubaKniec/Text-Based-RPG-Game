package game;

import game.abstractClasses.Character;
import game.abstractClasses.Enemy;
import game.enemies.Elf;
import game.enemies.Goblin;
import game.player.Player;
import game.quests.KillGivenAmountOfEnemies;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = createPlayer();

        pressEnter();

//        System.out.println("....WPROWADZENIE....");
//        System.out.println("Twoja ksiezniczka zostal porwana, musisz zaplacic okup, aby ja uwolnic");
//        pause(2);
//        System.out.println("Okup wynosi 1000 zlota");
//        pause(2);
//        pressEnter();

        clearScrean();
        System.out.println("Dotarles do wioski.");
        pause(2);
        System.out.println("Wchodzisz do tawerny.");
        pause(2);
        System.out.println("Masz do wyboru 2 misje");
        System.out.println("1(zabij 5 goblinow - 100gold)");
        System.out.println("2(zabij 3 elfy - 150gold)");
        System.out.println("[Wpisz 1 lub 2]");

        if ((wybor("1","2")=="1")) {
            KillGivenAmountOfEnemies quest = new KillGivenAmountOfEnemies();

            List<Enemy> enemies = quest.createEnemies(new Goblin(),5);
            quest.setReward(100);
            System.out.println("Wyruszasz na misje");
            pressEnter();
            clearScrean();
            boolean shouldIGiveReward = false;
            for (Enemy enemy : enemies) {
                if (!(player.walka(enemy))) {
                    break;
                }else {
                    shouldIGiveReward = true;
                }
            }
            if (shouldIGiveReward) {
                player.setGold(player.getGold() + quest.getReward());
            }


        }else {
            KillGivenAmountOfEnemies quest = new KillGivenAmountOfEnemies();
            quest.setReward(150);
            List<Enemy> enemies = quest.createEnemies(new Elf(),3);
            System.out.println("Wyruszasz na misje");
            pressEnter();
            clearScrean();
            boolean shouldIGiveReward = false;
            for (Enemy enemy : enemies) {
                if (!(player.walka(enemy))) {
                    break;
                }else {
                    shouldIGiveReward = true;
                }
            }
            if (shouldIGiveReward) {
                player.setGold(player.getGold() + quest.getReward());
            }
        }

        System.out.println(player.getGold());
    }

    public static void pause(int time){
        try {
            Thread.sleep(time* 1000L);
        } catch (InterruptedException e) {
            System.out.println("cos poszlo nie tak");
            e.printStackTrace();
        }

    }

    public static void koniecGry(){
        System.out.println("Przegrales");
        System.exit(0);

        }


    public static void pressEnter(){
        System.out.println("ENTER, aby kontynuowac");
        Scanner scanner = new Scanner(System.in);
        String pause;
        pause = scanner.nextLine();
    }

    public static String wybor(String wybor1,String wybor2){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(Objects.equals(input, wybor1)){
            return wybor1;
        }
        else if (Objects.equals(input,wybor2)) {
            return wybor2;
        }
        else {
            while (!Objects.equals(input, wybor1) || !Objects.equals(input, wybor2)){
                System.out.println("Wpisz ponownie");
                input = scanner.nextLine();
                if(Objects.equals(input, wybor1)){
                    return wybor1;
                }
                else if (Objects.equals(input,wybor2)) {
                    return wybor2;
                }
            }
        }
        return null;
    }

    public static void clearScrean(){
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    public static Player createPlayer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Stworz swojego bohatera");
        System.out.println("Na poczatku nadaj imie");
        System.out.print("imie: ");
        String name = scanner.next();
        int attack=0,defense=0;
        try{
            System.out.println("Sila: ");
            attack = scanner.nextInt();
            System.out.println("Obrona: ");
            defense = scanner.nextInt();
        }catch (InputMismatchException e){
            clearScrean();
            System.out.println("[Cos poszlo nie tak]");
            createPlayer();
        }
        return new Player(name,attack,defense);
    }
}
