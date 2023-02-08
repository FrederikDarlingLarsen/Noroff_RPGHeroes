package org.example;

public class Main {
    public static void main(String[] args) {

        HeroMage mage = new HeroMage("Darling");

        ItemWeapon axe = new ItemWeapon("Awesome Axe", 1,WeaponType.AXE);
        
        //mage.EquipWeapon(axe);

        mage.addAttributes(2,1,3);

        mage.Display();
    }
}