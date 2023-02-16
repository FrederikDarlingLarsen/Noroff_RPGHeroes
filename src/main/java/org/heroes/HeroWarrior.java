package org.heroes;

import org.enums.ArmorType;
import org.enums.HeroClass;
import org.enums.WeaponType;

public class HeroWarrior extends Hero {
    public static final int INITIAL_STRENGTH = 5;
    public static final int INITIAL_DEXTERITY = 2;
    public static final int INITIAL_INTELLIGENCE = 1;
    public static final int LEVEL_UP_STRENGTH = 3;
    public static final int LEVEL_UP_DEXTERITY = 2;
    public static final int LEVEL_UP_INTELLIGENCE = 1;
    public HeroWarrior(String _name){
        super(_name, new HeroAttributes(INITIAL_STRENGTH,INITIAL_DEXTERITY,INITIAL_INTELLIGENCE), HeroClass.WARRIOR);

        addValidWeaponType(WeaponType.AXE);
        addValidWeaponType(WeaponType.HAMMER);
        addValidWeaponType(WeaponType.SWORD);

        addValidArmorType(ArmorType.MAIL);
        addValidArmorType(ArmorType.PLATE);
    }
    @Override
    public void levelUp() {
        super.levelUp();
        this.addAttributes(LEVEL_UP_STRENGTH,LEVEL_UP_DEXTERITY,LEVEL_UP_INTELLIGENCE);
    }


}