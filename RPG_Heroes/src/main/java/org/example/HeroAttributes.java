package org.example;

public class HeroAttributes {

    private int strength ;
    private int dexterity;
    private int intelligence;

    public HeroAttributes(int _strength, int _dexterity, int _intelligence){
        this.strength = _strength;
        this.dexterity = _dexterity;
        this.intelligence = _intelligence;
    }

    public void AddAttributes (int strength, int dexterity, int intelligence){
        this.strength += strength;
        this.dexterity += dexterity;
        this.intelligence += intelligence;
    }

    public int GetStrength(){
        return strength;
    }

    public int GetDexterity() {
        return dexterity;
    }

    public int GetIntelligence() {
        return intelligence;
    }
}
