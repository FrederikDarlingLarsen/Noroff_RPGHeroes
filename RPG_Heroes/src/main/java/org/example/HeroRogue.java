package org.example;

public class HeroRogue extends Hero {
    public HeroRogue(String _name){
        super(_name, new HeroAttributes(2,6,1), "Rogue");

        addValidWeaponType(WeaponType.DAGGER);
        addValidWeaponType(WeaponType.SWORD);

        addValidArmorType(ArmorType.LEATHER);
        addValidArmorType(ArmorType.MAIL);
    }
    @Override
    public void levelUp() {
        super.levelUp();
        this.addAttributes(1,4,1);
    }

    public int damage() {
        if(getWeapon() != null){
            return getWeapon().getWeaponDamage() * (1 + getAttributes().getDexterity() / 100);
        }else{
            return (1 + getAttributes().getIntelligence() / 100);
        }
    }
}