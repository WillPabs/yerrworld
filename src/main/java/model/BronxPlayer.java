package model;

public class BronxPlayer extends NewYorkPlayer{

    public BronxPlayer(String name, int healthPoints, WeaponImpl weapon, double cash, int strength, int agility) {
        super(name, healthPoints, weapon, cash, strength, agility);
    }

    @Override
    public void dodge() {

    }

    @Override
    public void eat() {
        super.eat();
        System.out.println(this.getName() + " ate a baconeggandcheese!");
    }

    @Override
    public void drink() {
        super.drink();
        System.out.println(this.getName() + " drank an Arizona!");
    }
}
