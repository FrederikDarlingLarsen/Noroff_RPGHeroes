package org.example;

public class HeroRanger extends Hero {
    public HeroRanger(String _name){
        super(_name, new HeroAttributes(1,7,1), "Ranger");

        addValidWeaponType(WeaponType.BOW);

        addValidArmorType(ArmorType.LEATHER);
        addValidArmorType(ArmorType.MAIL);
    }
    @Override
    public void levelUp() {
        super.levelUp();
        this.addAttributes(1,5,1);
    }

    public int damage() {
        if(getWeapon() != null){
            return getWeapon().getWeaponDamage() * (1 + getAttributes().getDexterity() / 100);
        }else{
            return (1 + getAttributes().getIntelligence() / 100);
        }
    }
}