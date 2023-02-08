package org.example;


import java.util.List;

public abstract class Hero {

    private String name;

    private String heroClass;

    private int level = 1;

    private HeroAttributes levelAttributes;

    private List<Item> equipment;

    private List<WeaponType> validWeaponTypes;

    private List<ArmorType> validArmorTypes;

    public Hero (String _name, HeroAttributes _attributes, String _heroClass){
        this.name = _name;
        this.levelAttributes = _attributes;
        this.heroClass = _heroClass;
    }

    public void LevelUp(){
        level++;
    }

    public void addAttributes(int strength, int dexterity, int intelligence){
        levelAttributes.addAttributes(strength, dexterity, intelligence);
    }

    public HeroAttributes GetAttributes(){
        return levelAttributes;
    }

    public void EquipWeapon(ItemWeapon weapon) throws InvalidWeaponException{
        equipment.add(weapon);
    }

    public void EquipArmor(ItemArmor armor) throws InvalidArmorException{
        equipment.add(armor);
    }

    public Item GetWeapon(){
        return equipment.get(0);//needs to change

    }

    public abstract int Damage();

    public int TotalAttributes(){
        return levelAttributes.getStrength() +
                levelAttributes.getDexterity() +
        levelAttributes.getIntelligence();
    }

    public void Display(){

        // Get Name,Class,Level,the 3 attributes, damage,
        //StringBuilder str = new StringBuilder();
        //str.append("GFG");

        String details =
        "Name: " + this.name + "\n" +
        "Class: " + this.heroClass + "\n" +
        "Level: " + this.level + "\n" +
        "Strength: " + this.levelAttributes.getStrength() + "\n" +
        "Dexterity: " + this.levelAttributes.getDexterity() + "\n" +
        "Intelligence: " + this.levelAttributes.getIntelligence() + "\n" +
        "Damage: " + this.Damage();

        System.out.println(details);
    }

}
