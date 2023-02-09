package org.example;
import java.util.ArrayList;

public class HeroMage extends Hero {

    public HeroMage(String _name){
        super(_name, new HeroAttributes(1,1,8), "Mage");

        AddValidWeaponType(WeaponType.STAFF);
        AddValidWeaponType(WeaponType.WAND);

        AddValidArmorType(ArmorType.CLOTH);
    }
    @Override
    public void LevelUp() {
        super.LevelUp();
        this.addAttributes(1,1,5);
    }
    @Override
    public int Damage() {
        //Remember to add weaponDamage first!! or multiply??
       return (1 + GetAttributes().GetIntelligence() / 100);
    }
}