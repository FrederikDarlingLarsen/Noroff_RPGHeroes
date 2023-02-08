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
        levelAttributes.AddAttributes(strength, dexterity, intelligence);
    }

    public HeroAttributes GetAttributes(){
        return levelAttributes;
    }


    public List<WeaponType> GetValidWeaponTypes(){
        return validWeaponTypes;

    }

    public List<ArmorType> GetValidArmorTypes(){
        return validArmorTypes;
    }

    public void EquipWeapon(ItemWeapon weapon) throws InvalidWeaponException {

        try {
            if (GetValidWeaponTypes().contains(weapon.GetWeaponType())) { //do we still need the getters???
                equipment.add(weapon);
            } else {
                throw new InvalidWeaponException("You are not allowed to equip the following weapon: " + weapon.GetWeaponType().name());
            }
        }
        catch(InvalidWeaponException e){
            System.out.println(e.getMessage());
        }
    }

    public void EquipArmor(ItemArmor armor) throws InvalidArmorException {

        try {
            if (GetValidArmorTypes().contains(armor.GetArmorType())) {
                equipment.add(armor);
            } else {
                throw new InvalidArmorException("You can not equip this armor: " + armor.GetArmorType().name());
            }
        }
        catch(InvalidArmorException e){
            System.out.println(e.getMessage());
        }
    }

    /*public Item GetWeapon(){

        if() {
            return equipment.contains(ItemWeapon);//needs to change
        }else{
            return null;
        }

    }*/

    public abstract int Damage();


    public int TotalAttributes(){
        //LevelAttributes + (Sum of ArmorAttribute for all Armor in Equipment)
        return levelAttributes.GetStrength() +
                levelAttributes.GetDexterity() +
                levelAttributes.GetIntelligence();
    }


    public void Display(){
        // Get Name,Class,Level,the 3 attributes, damage,
        //StringBuilder str = new StringBuilder();
        //str.append("GFG");
        String details =
        "Name: " + this.name + "\n" +
        "Class: " + this.heroClass + "\n" +
        "Level: " + this.level + "\n" +
        "Strength: " + this.levelAttributes.GetStrength() + "\n" +
        "Dexterity: " + this.levelAttributes.GetDexterity() + "\n" +
        "Intelligence: " + this.levelAttributes.GetIntelligence() + "\n" +
        "Damage: " + this.Damage();
        System.out.println(details);
    }

}
