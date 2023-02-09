package org.example;

public class HeroWarrior extends Hero {
    public HeroWarrior(String _name){
        super(_name, new HeroAttributes(5,2,1), "Warrior");

        AddValidWeaponType(WeaponType.AXE);
        AddValidWeaponType(WeaponType.HAMMER);
        AddValidWeaponType(WeaponType.SWORD);

        AddValidArmorType(ArmorType.MAIL);
        AddValidArmorType(ArmorType.PLATE);
    }
    @Override
    public void LevelUp() {
        super.LevelUp();
        this.addAttributes(3,2,1);
    }
    @Override
    public int Damage() {
        if(GetWeapon() != null){
            return GetWeapon().GetWeaponDamage() * (1 + GetAttributes().GetStrength() / 100);
        }else{
            return (1 + GetAttributes().GetIntelligence() / 100);
        }
    }
}