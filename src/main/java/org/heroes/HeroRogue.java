package org.heroes;

import org.enums.ArmorType;
import org.enums.HeroClass;
import org.enums.WeaponType;

public class HeroRogue extends Hero {
    public static final int INITIAL_STRENGTH = 2;
    public static final int INITIAL_DEXTERITY = 6;
    public static final int INITIAL_INTELLIGENCE = 1;
    public static final int LEVEL_UP_STRENGTH = 1;
    public static final int LEVEL_UP_DEXTERITY = 4;
    public static final int LEVEL_UP_INTELLIGENCE = 1;
    public HeroRogue(String _name){
        super(_name, new HeroAttributes(INITIAL_STRENGTH,INITIAL_DEXTERITY,INITIAL_INTELLIGENCE), HeroClass.ROGUE);

        addValidWeaponType(WeaponType.DAGGER);
        addValidWeaponType(WeaponType.SWORD);

        addValidArmorType(ArmorType.LEATHER);
        addValidArmorType(ArmorType.MAIL);
    }
    @Override
    public void levelUp() {
        super.levelUp();
        this.addAttributes(LEVEL_UP_STRENGTH,LEVEL_UP_DEXTERITY,LEVEL_UP_INTELLIGENCE);
    }

}