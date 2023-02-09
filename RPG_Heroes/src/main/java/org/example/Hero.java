package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Hero {
    private final String name;
    private final String heroClass;
    private int level = 1;
    private final HeroAttributes levelAttributes;
    private final HashMap<Slot, Item> equipment;
    private final ArrayList<WeaponType> validWeaponTypes;
    private final ArrayList<ArmorType> validArmorTypes;

    public Hero (String _name, HeroAttributes _attributes, String _heroClass){
        this.name = _name;
        this.levelAttributes = _attributes;
        this.heroClass = _heroClass;

        equipment = new HashMap<>();
        equipment.put(Slot.WEAPON, null);
        equipment.put(Slot.HEAD, null);
        equipment.put(Slot.BODY, null);
        equipment.put(Slot.LEGS, null);

        validWeaponTypes = new ArrayList<WeaponType>();
        validArmorTypes = new ArrayList<ArmorType>();
    }

    public void LevelUp(){
        level++;
    }

    public void AddAttributes(int strength, int dexterity, int intelligence){
        levelAttributes.AddAttributes(new HeroAttributes(strength, dexterity, intelligence));
    }

    public HeroAttributes GetAttributes(){
        return levelAttributes;
    }

    public void AddValidWeaponType(WeaponType weaponType){
        this.validWeaponTypes.add(weaponType);
    }

    public void AddValidArmorType(ArmorType armorType){
        this.validArmorTypes.add(armorType);
    }

    public ItemWeapon GetWeapon(){
        return (ItemWeapon) equipment.get(Slot.WEAPON);
    }

    public void EquipWeapon(ItemWeapon weapon)  {

        try {
            if (this.validWeaponTypes.contains(weapon.GetWeaponType())) {
                equipment.put(Slot.WEAPON, weapon);
                System.out.println("You just equipped: " + weapon.GetName());
            } else {
                throw new InvalidWeaponException("You are not allowed to equip: " + weapon.GetName() +
                        "   of type: " + weapon.GetWeaponType().name());
            }
        }
        catch(InvalidWeaponException e){
            System.out.println(e.toString());
        }
    }

    public void EquipArmor(ItemArmor armor) {

        try {
            if (this.validArmorTypes.contains(armor.GetArmorType())) {
                equipment.put(armor.GetSlot(), armor);
                System.out.println("You just equipped: " + armor.GetName());
            } else {
                throw new InvalidArmorException("You can not equip this armor: " + armor.GetName()  + "   of type: " +
                        armor.GetArmorType().name());
            }
        }
        catch(InvalidArmorException e){
            System.out.println(e.toString());
        }
    }

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