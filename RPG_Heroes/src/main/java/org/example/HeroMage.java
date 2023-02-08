package org.example;

public class HeroMage extends Hero {

    private enum ValidWeaponTypes{
        STAFF,
        WAND
    }

    private enum ValidArmorTypes{
        CLOTH
    }

    public HeroMage(String _name){
        super(_name, new HeroAttributes(1,1,8), "Mage");
    }


    @Override
    public void LevelUp() {
        super.LevelUp();
        this.addAttributes(1,1,5);
    }

    @Override
    public void EquipWeapon(ItemWeapon weapon) throws InvalidWeaponException {

        try {
            if (weapon.getWeaponType() == WeaponType.WAND || weapon.getWeaponType() == WeaponType.STAFF) {
                super.EquipWeapon(weapon);
            } else {
                throw new InvalidWeaponException("You are not allowed to equip the following weapon: " + weapon.getWeaponType().name());
            }
        }
        catch(InvalidWeaponException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void EquipArmor(ItemArmor armor) throws InvalidArmorException {

        try {
            if (armor.getArmorType() == ArmorType.CLOTH) {
                super.EquipArmor(armor);
            } else {
                throw new InvalidArmorException("You can not equip this armor: " + armor.getArmorType().name());
            }
        }
        catch(InvalidArmorException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int Damage() {
       // return GetWeapon(). * (1 + GetAttributes().getIntelligence() / 100);
   return 0;
    }
}
