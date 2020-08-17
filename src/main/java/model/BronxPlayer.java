package model;

public class BronxPlayer extends NewYorkPlayer{

    public BronxPlayer(String name, WeaponImpl weapon, double cash, int strength, int agility) {
        super(name, weapon, cash, strength, agility);
    }

    public BronxPlayer() {
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
