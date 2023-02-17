package org.heroes;

import org.enums.ArmorType;
import org.enums.HeroClass;
import org.enums.Slot;
import org.enums.WeaponType;
import org.exceptions.InvalidArmorException;
import org.exceptions.InvalidWeaponException;
import org.items.*;
import java.util.ArrayList;
import java.util.HashMap;

// The abstract hero class which defines shared attributes and methods for all heroes.
public abstract class Hero {
    private final String name;
    private final HeroClass heroClass;
    private int level = 1;
    private final HeroAttributes levelAttributes;
    private final HashMap<Slot, Item> equipment;
    private final ArrayList<WeaponType> validWeaponTypes;
    private final ArrayList<ArmorType> validArmorTypes;

    //The constructor for the hero which assigns name, attributes and class to the hero.
    public Hero (String _name, HeroAttributes _attributes, HeroClass _heroClass){
        this.name = _name;
        this.levelAttributes = _attributes;
        this.heroClass = _heroClass;

        //Equipment is initialized and given four empty slots.
        equipment = new HashMap<>();
        equipment.put(Slot.WEAPON, null);
        equipment.put(Slot.HEAD, null);
        equipment.put(Slot.BODY, null);
        equipment.put(Slot.LEGS, null);

        //The arraylists for the valid weapon and armor types are initialized.
        validWeaponTypes = new ArrayList<WeaponType>();
        validArmorTypes = new ArrayList<ArmorType>();
    }

    public void levelUp(){
        level++;
    }

    public String getName(){
        return this.name;
    }

    public int getLevel(){
        return this.level;
    }

    public void addAttributes(int strength, int dexterity, int intelligence){
        levelAttributes.addAttributes(new HeroAttributes(strength, dexterity, intelligence));
    }

    // Calculates and returns the total attributes by adding the level attributes with attributes
    // from all of the armor.
    public HeroAttributes getAttributes(){
        // Gets the level attributes.
            HeroAttributes attribute = new HeroAttributes(levelAttributes.getStrength(),
                    levelAttributes.getDexterity(),levelAttributes.getIntelligence());
            // Loops through all items.
      for (Slot slot : Slot.values()) {
          // If check to avoid checking the weapon slot.
          if(!slot.equals(Slot.WEAPON)){
              // If armor is equipped in the slot then get its attributes.
            if(getArmor(slot) != null) {
                attribute.addAttributes(new HeroAttributes(
                        getArmor(slot).getArmorAttributes().getStrength(),
                        getArmor(slot).getArmorAttributes().getDexterity(),
                        getArmor(slot).getArmorAttributes().getIntelligence()));
            }
        }}
        return attribute;
    }

    public void addValidWeaponType(WeaponType weaponType){
        this.validWeaponTypes.add(weaponType);
    }

    public void addValidArmorType(ArmorType armorType){
        this.validArmorTypes.add(armorType);
    }

    public ItemWeapon getWeapon(){
        return (ItemWeapon) equipment.get(Slot.WEAPON);
    }

    public ItemArmor getArmor(Slot slot){
        return (ItemArmor) equipment.get(slot);
    }

    // Method for equipping weapons that use custom exceptions and exception handling for
    // checking and handling when a user is trying to equip an invalid weapon.
    public void equipWeapon(ItemWeapon weapon)  {

        try {
            // Checks if the weapon is of a valid type and then checks if the
            // required level of the weapon is less than or equal to that of the hero.
            if (this.validWeaponTypes.contains(weapon.getWeaponType())) {
                if(weapon.getRequiredLevel() <= this.level){
                    // If both is true then equip the weapon.
                    equipment.put(Slot.WEAPON, weapon);
                    System.out.println("You just equipped: " + weapon.getName());
                } else {
                    // If level requirement is not met throw an exception with an appropriate message.
                    throw new InvalidWeaponException("You are not at a high enough level to equip this weapon: " + weapon.getName() +
                            "   of type: " + weapon.getWeaponType().name());
                }
            } else {
                // If type requirement is not met throw an exception with an appropriate message.
                throw new InvalidWeaponException("The following weapon can not be equipped by your class: " + weapon.getName() +
                        "   of type: " + weapon.getWeaponType().name());
            }
        }
        catch(InvalidWeaponException e){
            System.out.println(e.toString());
        }
    }

    // Method for equipping armor that use custom exceptions and exception handling for
    // checking and handling when a user is trying to equip invalid armor.
    public void equipArmor(ItemArmor armor) {

        try {
            // Checks if the piece of armor is of a valid type and then checks if the
            // required level of piece of armor is less than or equal to that of the hero.
            if (this.validArmorTypes.contains(armor.getArmorType())) {
                // If both is true then equip armor.
                if(armor.getRequiredLevel() <= this.level) {
                    equipment.put(armor.getSlot(), armor);
                    System.out.println("You just equipped: " + armor.getName());
                }else{
                    // If level requirement is not met throw an exception with an appropriate message.
                    throw new InvalidArmorException("You can not equip this armor: " + armor.getName()  + "   of type: " +
                            armor.getArmorType().name());
                }
            } else {
                // If type requirement is not met throw an exception with an appropriate message.
                throw new InvalidArmorException("You can not equip this armor: " + armor.getName()  + "   of type: " +
                        armor.getArmorType().name());
            }
        }
        catch(InvalidArmorException e){
            System.out.println(e.toString());
        }
    }

    // Method for calculating damage for the hero depending on their class
    public double damage() {
        // Checks if the hero has a weapon equipped.
        if(getWeapon() != null){
            // If true run a switch statement to check for the hero class and then calculate damage WITH weapon.
            return switch (this.heroClass) {
                case MAGE -> getWeapon().getWeaponDamage() * (1 + getAttributes().getIntelligence() / 100.0);
                case RANGER, ROGUE -> getWeapon().getWeaponDamage() * (1 + getAttributes().getDexterity() / 100.0);
                case WARRIOR -> getWeapon().getWeaponDamage() * (1 + getAttributes().getStrength() / 100.0);
            };
        }else{
            // If false run a switch statement to check for the hero class and then calculate damage WITHOUT weapon.
            return switch (this.heroClass) {
                case MAGE -> (1 + getAttributes().getIntelligence() / 100.0);
                case RANGER, ROGUE -> (1 + getAttributes().getDexterity() / 100.0);
                case WARRIOR -> (1 + getAttributes().getStrength() / 100.0);
            };
        }
    }


    // Method for displaying a hero using a StringBuilder. When using a StringBuilder
    // each element can be added using the append() method.
    public StringBuilder display(){
        StringBuilder details = new StringBuilder("Details of hero:" + "\n");
        details.append("Name: ").append(this.name).append("\n");
        details.append("Class: ").append(this.heroClass).append("\n");
        details.append("Level: ").append(this.level).append("\n");
        details.append(this.levelAttributes).append("\n");
        details.append("Damage: ").append(this.damage());
        return details;
    }
}