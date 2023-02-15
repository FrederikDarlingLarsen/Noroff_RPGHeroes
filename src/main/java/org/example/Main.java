package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String res = convertToPascalCase("The Quick .,- brown foX jUmped '[]/Over the lAZy dog");

        System.out.println(res);

        //Testing functionality

     /* Hero hero = new HeroWarrior("Darling");

        ItemWeapon axe = new ItemWeapon("Awesome Axe", 1,WeaponType.AXE,10);

        ItemWeapon wand = new ItemWeapon("Magic wand", 1,WeaponType.WAND,5);
        
        hero.equipWeapon(axe);

        hero.equipWeapon(wand);

        hero.addAttributes(2,1,100);

        hero.display();

        System.out.println("Currently equipped weapon: " + hero.getWeapon().getName());*/


      /*   while(true){

             Scanner input = new Scanner(System.in);

             System.out.println("Please pick a class. Press 0 for Mage, 1 for Ranger, 2 for Rogue and 3 for Warrior");

             Hero hero;

             switch (input.nextInt()){
                 case 0:
                     System.out.println("Please enter a name");
                     hero = new HeroMage(input.next());
                     System.out.println("Pick your weapon");
                     System.out.println("Press 1 for wand");
                     System.out.println("Press 2 for staff");
                     break;
                 case 1:
                     System.out.println("Please enter a name");
                     hero = new HeroRanger(input.next());
                     System.out.println("Pick your weapon");
                     break;
                 case 2:
                     System.out.println("Please enter a name");
                     hero = new HeroRogue(input.next());
                     System.out.println("Pick your weapon");
                     break;
                 case 3:
                     System.out.println("Please enter a name");
                     hero = new HeroWarrior(input.next());
                     System.out.println("Pick your weapon");
                     break;
                 default:
                    // System.out.println("Please enter a name");
                     hero = new HeroWarrior("BOB");
                     break;
             }
             hero.display();
         }*/
    }

    public static String readableTime(float time){
        float hours = time/3600;
        float minutes = (hours % 1) * 60;
        float seconds = (minutes % 1) * 60;
        return (int)hours + ":" + (int)minutes + ":" + (int)seconds;
    }


    public static String convertToPascalCase(String input){
        StringBuilder result = new StringBuilder();
        String[] words = input.toLowerCase().replaceAll("[^a-z0-9 ]","").split(" ");
        for (String word : words) {
            if(word.length() != 0) {
                result.append(word.substring(0, 1).toUpperCase()).append(word.substring(1));
            }
        }
        return result.toString();
    }
}




