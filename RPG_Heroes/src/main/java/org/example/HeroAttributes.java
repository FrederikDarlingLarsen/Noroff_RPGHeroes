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

    public void addAttributes (HeroAttributes newAttributes){
        setStrength(this.strength + newAttributes.getStrength());
        setDexterity(this.dexterity + newAttributes.getDexterity());
        setIntelligence(this.intelligence + newAttributes.getIntelligence());
    }

    public int getStrength(){
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setStrength(int strength){
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
