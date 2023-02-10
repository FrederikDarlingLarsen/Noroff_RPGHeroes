package org.example;

public class HeroWarrior extends Hero {
    public HeroWarrior(String _name){
        super(_name, new HeroAttributes(5,2,1), "Warrior");

        addValidWeaponType(WeaponType.AXE);
        addValidWeaponType(WeaponType.HAMMER);
        addValidWeaponType(WeaponType.SWORD);

        addValidArmorType(ArmorType.MAIL);
        addValidArmorType(ArmorType.PLATE);
    }
    @Override
    public void levelUp() {
        super.levelUp();
        this.addAttributes(3,2,1);
    }
    @Override
    public int damage() {
        if(getWeapon() != null){
            return getWeapon().getWeaponDamage() * (1 + getAttributes().getStrength() / 100);
        }else{
            return (1 + getAttributes().getIntelligence() / 100);
        }
    }
}