package org.heroes;

import org.enums.ArmorType;
import org.enums.HeroClass;
import org.enums.WeaponType;

// Class for creating a ranger by inheriting from the hero class.
public class HeroRanger extends Hero {
    // Constants are set for initial attributes and for levelup attributes.
    public static final int INITIAL_STRENGTH = 1;
    public static final int INITIAL_DEXTERITY = 7;
    public static final int INITIAL_INTELLIGENCE = 1;
    public static final int LEVEL_UP_STRENGTH = 1;
    public static final int LEVEL_UP_DEXTERITY = 5;
    public static final int LEVEL_UP_INTELLIGENCE = 1;
    public HeroRanger(String _name){
        super(_name, new HeroAttributes(INITIAL_STRENGTH,INITIAL_DEXTERITY,INITIAL_INTELLIGENCE), HeroClass.RANGER);

        // Valid weapon and armor types are added.
        addValidWeaponType(WeaponType.BOW);
        addValidArmorType(ArmorType.LEATHER);
        addValidArmorType(ArmorType.MAIL);
    }
    // Overridden method for leveling up the ranger.
    @Override
    public void levelUp() {
        super.levelUp();
        this.addAttributes(LEVEL_UP_STRENGTH,LEVEL_UP_DEXTERITY,LEVEL_UP_INTELLIGENCE);
    }

}