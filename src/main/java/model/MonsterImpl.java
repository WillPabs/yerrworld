package model;

public class MonsterImpl implements Monster{
    private String name;
    int healthPoints;
    private int strength;
    private int agility;
    private int attackMin = 10;
    private int attackMax = 60;


    public MonsterImpl(String name, int healthPoints, int strength, int agility) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.strength = strength;
        this.agility = agility;
    }

    @Override
    public void attack(NewYorkPlayer player) {
        System.out.println(this.name + " attacked " + player.getName());
        player.healthPoints -= (int) (Math.random() * (attackMax - attackMin + 1) + attackMin);
        System.out.println(player.getName() + " HP: " + player.getHealthPoints() + " | " + this.getName() + " HP: " + this.getHealthPoints());
    }

    @Override
    public void regenerateHealth() {
        System.out.println(this.name + " regenerated 50 health");
        if(this.healthPoints + 50 >= 100) {
            this.healthPoints = 100;
            System.out.println(this.name + " HP:"+ this.healthPoints);
        } else {
            this.healthPoints += 50;
            System.out.println(this.name + " HP: " + this.getHealthPoints());
        }
    }

    @Override
    public void dodge() {
        System.out.println(this.name + " dodged " + this.name + "'s attack");
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
        return "MonsterImpl{" +
                "name='" + name + '\'' +
                ", healthPoints=" + healthPoints +
                ", strength=" + strength +
                ", agility=" + agility +
                '}';
    }
}
