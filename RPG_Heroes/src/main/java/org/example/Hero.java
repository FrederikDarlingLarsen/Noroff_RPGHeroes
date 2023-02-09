package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Hero {

    private String name;

    private String heroClass;

    private int level = 1;

    private HeroAttributes levelAttributes;
    private Map<Slot, Item> equipment;

    private List<WeaponType> validWeaponTypes;

    private List<ArmorType> validArmorTypes;

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

    public void addAttributes(int strength, int dexterity, int intelligence){
        levelAttributes.AddAttributes(new HeroAttributes(strength, dexterity, intelligence));
    }

    public HeroAttributes GetAttributes(){
        return levelAttributes;
    }





    public List<WeaponType> GetValidWeaponTypes(){
        return this.validWeaponTypes;
    }

    public List<ArmorType> GetValidArmorTypes(){
        return validArmorTypes;
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


    public void EquipWeapon(ItemWeapon weapon) /*throws InvalidWeaponException*/ {

       // try {
            if (GetValidWeaponTypes().contains(weapon.GetWeaponType())) { //do we still need the getters???
                equipment.put(Slot.WEAPON, weapon);
                System.out.println("You just equipped: " + weapon.GetName());
            } else {
                System.out.println("Could not equip: " + weapon.GetName());
                //throw new InvalidWeaponException("You are not allowed to equip the following weapon: " + weapon.GetWeaponType().name());
            }
      /*  }
        catch(InvalidWeaponException e){
            System.out.println(e.getMessage());
        }*/
    }

    public void EquipArmor(ItemArmor armor) /*throws InvalidArmorException*/ {

      //  try {
            if (GetValidArmorTypes().contains(armor.GetArmorType())) {
                equipment.put(armor.GetSlot(), armor);
                System.out.println("You just equipped: " + armor.GetName());
            } else {
                System.out.println("Could not equip: " + armor.GetName());
                //throw new InvalidArmorException("You can not equip this armor: " + armor.GetArmorType().name());
            }
      /*  }
        catch(InvalidArmorException e){
            System.out.println(e.getMessage());
        }*/
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
