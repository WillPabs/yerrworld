package com.williampabitero.yerrworld;

import model.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class YerrworldApplication {

    private static Scanner kb = new Scanner(System.in);
    private static WeaponImpl blicky = new WeaponImpl("blicky", 50);
    private static NewYorkPlayer player = new BronxPlayer("Tyrese", blicky, 1000.0, 10, 20);
    private static MonsterImpl monster = new MonsterImpl("NoBrimGuy", 100, 10, 15);

    public static void main(String[] args) {

        boolean playerAlive = true;
        boolean monsterAlive = true;

        player = choosePlayer();

        System.out.println("Enter your Hero's name :");
        String name = kb.nextLine();
        player.setName(name);

        System.out.println("Welcome " + player.getName() + "\nGet Ready for battle!");

        while(playerAlive && monsterAlive) {
            //displayBattleInfo();
            playerMove(player, monster);
            playerAlive = checkAlive(player, monster);
            if(!playerAlive) {
                break;
            }
            System.out.println("--------------"); //Player move end
            //Monster move start
            monsterMove(player, monster);
            //displayBattleInfo();
            monsterAlive = checkAlive(player, monster);
            System.out.println("--------------"); // Monster move end
        }
        System.out.println("Game Over");

    }

    public static NewYorkPlayer choosePlayer() {
        System.out.println("Choose a number between 1-5 for desired player type: ");
        System.out.println("1. Bronx Player\n2. Queens Player\n3. Brooklyn Player\n4. Manhattan Player\n5. Staten Island Player");
        int choice = kb.nextInt();

        if(choice > 5 || choice < 1) {
            choosePlayer();
        }

        switch (choice) {
            case 1:
                System.out.println("You chose Bronx Player");
                player = new BronxPlayer();
                break;
            case 2:
                System.out.println("You chose Queens Player");
                player = new QueensPlayer();
                break;
            case 3:
                System.out.println("You chose Brooklyn Player");
                player = new BrooklynPlayer();
                break;
            case 4:
                System.out.println("You chose Manhattan Player");
                player = new ManhattanPlayer();
                break;
            case 5:
                System.out.println("You chose Staten Island Player");
                player = new StatenIslandPlayer();
                break;
            default:
                System.out.println(choice + " is an invalid selection");
                break;
        }

        return player;
    }

    public static int playerMove(NewYorkPlayer player, MonsterImpl monster) {
        System.out.println("Moves:\n1: Attack\n2: Special Attack\n3: Eat" +
                "\n4: Drink \n5: Dodge");
        int move = kb.nextInt();
        System.out.println(player.getName() + " used action " + move);

        switch(move) {
            case 1:
                player.attack(monster);
                break;
            case 2:
                player.specialAttack(monster);
                break;
            case 3:
                player.eat();
                break;
            case 4:
                player.drink();
                break;
            case 5:
                player.dodge();
                break;
        }
        return move;
    }

    public static int monsterMove(NewYorkPlayer player, MonsterImpl monster) {
        int move = 1 + ((int) Math.random() * 3);
        System.out.println(monster.getName() + " used action " + move);

        switch(move) {
            case 1:
                monster.attack(player);
                break;
            case 2:
                monster.regenerateHealth();
                break;
            case 3:
                monster.dodge();
                break;
        }
        return move;
    }

    public static boolean checkAlive(NewYorkPlayer player, MonsterImpl monster) {
        if(player.getHealthPoints() <= 0) {
            System.out.println(player.getName() + " died!");
            return false;
        }
        if(monster.getHealthPoints() <= 0) {
            System.out.println(monster.getName() + " died!");
            return false;
        }
        return true;
    }

    public static void displayBattleInfo() {
        System.out.println(player.getName() + " HP: " + player.getHealthPoints() + "\t" + monster.getName() +  " HP: " + monster.getHealthPoints());
    }

}
