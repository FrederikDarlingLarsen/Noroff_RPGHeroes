package org.example;

public class HeroWarrior extends Hero {


    public HeroWarrior(String _name){
        super(_name, new HeroAttributes(5,2,1), "Warrior");
    }

    @Override
    public void LevelUp() {
        super.LevelUp();
        this.addAttributes(3,2,1);
    }

    @Override
    public int Damage() {

        //Remember to add weaponDamage first!!
        return (1 + GetAttributes().GetStrength() / 100);
    }
}
