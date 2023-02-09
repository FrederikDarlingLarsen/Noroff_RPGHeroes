package org.example;

import java.awt.color.ICC_ColorSpace;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Testing functionality

        Hero hero = new HeroWarrior("Darling");

        ItemWeapon axe = new ItemWeapon("Awesome Axe", 1,WeaponType.AXE,10);

        ItemWeapon wand = new ItemWeapon("Magic wand", 1,WeaponType.WAND,5);
        
       hero.EquipWeapon(axe);
        hero.EquipWeapon(wand);

        hero.addAttributes(2,1,100);

        hero.Display();

        System.out.println("Currently equipped weapon: " + hero.GetWeapon().GetName());

        /* while(true){

             Scanner input = new Scanner(System.in);

             System.out.println("Please pick a class. Press 0 for Mage, 1 for Ranger, 2 for Rogue and 3 for Warrior");

             Hero hero;

             switch (input.nextInt()){
                 case 0:
                     System.out.println("Please enter a name");
                     hero = new HeroMage(input.next());
                     break;
                 case 1:
                     System.out.println("Please enter a name");
                     hero = new HeroRanger(input.next());
                     break;
                 case 2:
                     System.out.println("Please enter a name");
                     hero = new HeroRogue(input.next());
                     break;
                 case 3:
                     System.out.println("Please enter a name");
                     hero = new HeroWarrior(input.next());
                     break;
                 default:
                    // System.out.println("Please enter a name");
                     hero = new HeroWarrior("BOB");
                     break;
             }
             ItemWeapon wand = new ItemWeapon("Magic wand", 1,WeaponType.WAND,5);
             hero.EquipWeapon(wand);

             hero.Display();

         }*/
    }
}