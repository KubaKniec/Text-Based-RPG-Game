package game;

import game.abstractClasses.Character;
import game.abstractClasses.Enemy;
import game.enemies.Elf;
import game.enemies.Goblin;
import game.player.Player;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Stworz swojego bohatera");
        System.out.println("Na poczatku nadaj imie");
        System.out.print("imie: ");
        String name = scanner.next();
        int strength=0,defense=0;
        while (strength+defense!=10){
            System.out.println("_________");
            System.out.println("Masz do rozdania 10pkt umiejetnosci");
            System.out.print("sila: ");
            strength = scanner.nextInt();
            System.out.print("obrona: ");
            defense = scanner.nextInt();
        }
        Character player = new Player(name,100,strength,defense,0,0);

        System.out.println("....WPROWADZENIE....");
        System.out.println("Twoja ksiezniczka zostal porwana, musisz zaplacic okup, aby ja uwolnic");
        pause(2);
        System.out.println("Okup wynosi 1000 zlota");
        pause(2);
        pressEnter();

        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Dotarles do wioski.");
        pause(2);
        System.out.println("Wchodzisz do tawerny.");
        pause(2);
        System.out.println("Masz do wyboru 2 misje");
        System.out.println("1(zabij 5 goblinow)");
        System.out.println("2(zabij 3 elfy)");
        System.out.println("[Wpisz 1 lub 2]");
        if ((wybor("1","2")=="1")){
            Enemy[] goblins = {new Goblin(),new Goblin(), new Goblin(), new Goblin(), new Goblin()};
            System.out.println("Wyruszasz na misje");
            for (int i = 0; i < goblins.length; i++) {
                player.walka(goblins[i]);
            }
        }else {
            Enemy[] elfs = {new Elf(),new Elf(),new Elf()};
            System.out.println("Wyruszasz na misje");
            for (int i = 0; i < elfs.length; i++) {
                player.walka(elfs[i]);
            }
        }





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
}
