package org.heroes;

import org.enums.ArmorType;
import org.enums.HeroClass;
import org.enums.WeaponType;

// Class for creating a warrior by inheriting from the hero class.
public class HeroWarrior extends Hero {

    // Constants are set for initial attributes and for levelup attributes.
    public static final int INITIAL_STRENGTH = 5;
    public static final int INITIAL_DEXTERITY = 2;
    public static final int INITIAL_INTELLIGENCE = 1;
    public static final int LEVEL_UP_STRENGTH = 3;
    public static final int LEVEL_UP_DEXTERITY = 2;
    public static final int LEVEL_UP_INTELLIGENCE = 1;
    public HeroWarrior(String _name){
        super(_name, new HeroAttributes(INITIAL_STRENGTH,INITIAL_DEXTERITY,INITIAL_INTELLIGENCE), HeroClass.WARRIOR);

        // Valid weapon and armor types are added.
        addValidWeaponType(WeaponType.AXE);
        addValidWeaponType(WeaponType.HAMMER);
        addValidWeaponType(WeaponType.SWORD);
        addValidArmorType(ArmorType.MAIL);
        addValidArmorType(ArmorType.PLATE);
    }

    // Overridden method for leveling up the warrior.
    @Override
    public void levelUp() {
        super.levelUp();
        this.addAttributes(LEVEL_UP_STRENGTH,LEVEL_UP_DEXTERITY,LEVEL_UP_INTELLIGENCE);
    }


}