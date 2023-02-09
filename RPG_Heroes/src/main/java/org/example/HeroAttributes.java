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

    public void AddAttributes (HeroAttributes newAttributes){
        SetStrength(this.strength + newAttributes.GetStrength());
        SetDexterity(this.dexterity + newAttributes.GetDexterity());
        SetIntelligence(this.intelligence + newAttributes.GetIntelligence());
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

    public void SetStrength(int strength){
        this.strength = strength;
    }

    public void SetDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void SetIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
