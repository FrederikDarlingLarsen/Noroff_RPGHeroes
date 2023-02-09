package org.example;

public class HeroRanger extends Hero {
    public HeroRanger(String _name){
        super(_name, new HeroAttributes(1,7,1), "Ranger");

        AddValidWeaponType(WeaponType.BOW);

        AddValidArmorType(ArmorType.LEATHER);
        AddValidArmorType(ArmorType.MAIL);
    }
    @Override
    public void LevelUp() {
        super.LevelUp();
        this.addAttributes(1,5,1);
    }
    @Override
    public int Damage() {
        //Remember to add weaponDamage first!!
        return (1 + GetAttributes().GetDexterity() / 100);
    }
}