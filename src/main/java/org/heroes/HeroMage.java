package org.heroes;

import org.enums.ArmorType;
import org.enums.HeroClass;
import org.enums.WeaponType;

// Class for creating a mage by inheriting from the hero class.
public class HeroMage extends Hero {
    // Constants are set for initial attributes and for levelup attributes.
    public static final int INITIAL_STRENGTH = 1;
    public static final int INITIAL_DEXTERITY = 1;
    public static final int INITIAL_INTELLIGENCE = 8;
    public static final int LEVEL_UP_STRENGTH = 1;
    public static final int LEVEL_UP_DEXTERITY = 1;
    public static final int LEVEL_UP_INTELLIGENCE = 5;

    public HeroMage(String _name){
        super(_name, new HeroAttributes(INITIAL_STRENGTH,INITIAL_DEXTERITY,INITIAL_INTELLIGENCE), HeroClass.MAGE);

        // Valid weapon and armor types are added.
        addValidWeaponType(WeaponType.STAFF);
        addValidWeaponType(WeaponType.WAND);
        addValidArmorType(ArmorType.CLOTH);
    }

    // Overridden method for leveling up the mage.
    @Override
    public void levelUp() {
        super.levelUp();
        this.addAttributes(LEVEL_UP_STRENGTH,LEVEL_UP_DEXTERITY,LEVEL_UP_INTELLIGENCE);
    }
}