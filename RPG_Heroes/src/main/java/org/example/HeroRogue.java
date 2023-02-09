package org.example;

public class HeroRogue extends Hero {
    public HeroRogue(String _name){
        super(_name, new HeroAttributes(2,6,1), "Rogue");

        AddValidWeaponType(WeaponType.DAGGER);
        AddValidWeaponType(WeaponType.SWORD);

        AddValidArmorType(ArmorType.LEATHER);
        AddValidArmorType(ArmorType.MAIL);
    }
    @Override
    public void LevelUp() {
        super.LevelUp();
        this.addAttributes(1,4,1);
    }
    @Override
    public int Damage() {
        if(GetWeapon() != null){
            return GetWeapon().GetWeaponDamage() * (1 + GetAttributes().GetDexterity() / 100);
        }else{
            return (1 + GetAttributes().GetIntelligence() / 100);
        }
    }
}