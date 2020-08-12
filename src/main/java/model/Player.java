package model;

public interface Player {
    void dodge();
    void attack(MonsterImpl monster);
    void specialAttack(MonsterImpl monster);
    void eat();
    void drink();
}
