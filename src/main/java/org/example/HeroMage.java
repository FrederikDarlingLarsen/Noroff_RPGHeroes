package org.example;
import java.util.ArrayList;

public class HeroMage extends Hero {

    public HeroMage(String _name){
        super(_name, new HeroAttributes(1,1,8), "Mage");

        addValidWeaponType(WeaponType.STAFF);
        addValidWeaponType(WeaponType.WAND);

        addValidArmorType(ArmorType.CLOTH);
    }
    @Override
    public void levelUp() {
        super.levelUp();
        this.addAttributes(1,1,5);
    }

    public int damage() {
        if(getWeapon() != null){
       return getWeapon().getWeaponDamage() * (1 + getAttributes().getIntelligence() / 100);
    }else{
            return (1 + getAttributes().getIntelligence() / 100);
        }
    }

}