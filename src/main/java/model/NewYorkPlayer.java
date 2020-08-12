package model;

import java.util.Random;

public class NewYorkPlayer implements Player {
    private String name;
    int healthPoints;
    private WeaponImpl weapon;
    private double cash;
    private int strength;
    private int agility;
    private int attackMin = 10;
    private int attackMax = 25;
    private int specialAttackMin = 40;
    private int specialAttackMax = 100;

    public NewYorkPlayer(String name, int healthPoints, WeaponImpl weapon, double cash, int strength, int agility) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.weapon = weapon;
        this.cash = cash;
        this.strength = strength;
        this.agility = agility;
    }

    @Override
    public void dodge() {
        System.out.println(this.name + " dodged the attack");
    }

    @Override
    public void attack(MonsterImpl monster) {
        System.out.println(this.name +  " attacked " + monster.getName());
        monster.healthPoints -= (int) (Math.random() * (attackMax - attackMin + 1) + attackMin);
        System.out.println(monster.getName() + " HP: " + monster.getHealthPoints() + " | " + this.getName() + " HP: " + this.healthPoints);
    }

    @Override
    public void specialAttack(MonsterImpl monster) {
        System.out.println(this.name + " used Timb Stomp on " + monster.getName());
        monster.healthPoints -= (int) (Math.random() * (specialAttackMax - specialAttackMin + 1) + specialAttackMin);
        System.out.println(monster.getName() + " HP: " + monster.getHealthPoints() + " | " + this.getName() + " HP: " + this.getHealthPoints());
    }

    @Override
    public void eat() {
        if(this.healthPoints + 50 >= 100) {
            this.healthPoints = 100;
            System.out.println(this.name + " is restored back to full health");
        } else {
            this.healthPoints += 50;
            System.out.println(this.name + " restored health to " + this.healthPoints);
        }
    }

    @Override
    public void drink() {
        if(this.healthPoints + 25 >= 100) {
            this.healthPoints = 100;
            System.out.println(this.name + " is restored back to full health");
        } else {
            this.healthPoints += 25;
            System.out.println(this.name +  " restored health to " + this.healthPoints);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public WeaponImpl getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponImpl weapon) {
        this.weapon = weapon;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    @Override
    public String toString() {
        return "NewYorkPlayer{" +
                "name='" + name + '\'' +
                ", healthPoints=" + healthPoints +
                ", weapon=" + weapon +
                ", cash=" + cash +
                ", strength=" + strength +
                ", agility=" + agility +
                '}';
    }
}
