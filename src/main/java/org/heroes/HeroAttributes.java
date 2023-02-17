package org.heroes;

// The HeroAttributes class which is used to store attributes for the heroes and the armor.
public class HeroAttributes {
    private int strength ;
    private int dexterity;
    private int intelligence;

    public HeroAttributes(int _strength, int _dexterity, int _intelligence){
        this.strength = _strength;
        this.dexterity = _dexterity;
        this.intelligence = _intelligence;
    }

    // Used to add attributes to the object by giving the method an object.
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

    // Overridden toString() method used to simplify the display() method of the hero.
    @Override public String toString() {
        return String.format("Strength: %d, Dexterity: %d, Intelligence: %d", strength, dexterity, intelligence);
    }
    // Overridden equals() method used for unit testing to compare two different objects and check for equal values.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeroAttributes that = (HeroAttributes) o;
        return strength == that.strength && dexterity == that.dexterity && intelligence == that.intelligence;
    }
}
