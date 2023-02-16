import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String res = convertToPascalCase("The Quick .,- brown foX jUmped '[]/Over the lAZy dog");

        System.out.println(res);



        System.out.println(translateWord("allo"));

        System.out.println(translateWord("have"));
        System.out.println(translateWord("cram"));

        System.out.println(translateSentence("cram have alloi"));


        //have ➞ avehay
        //cram ➞ amcray

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


   /* KATA: English to Pig Latin Translator
    Pig Latin has two very simple rules:
    If a word starts with a consonant move the first letter(s) of the word, till you reach a vowel, to the end of the word and add "ay" to the end.
            have ➞ avehay
    cram ➞ amcray
    take ➞ aketay
    cat ➞ atcay
    shrimp ➞ impshray
    trebuchet ➞ ebuchettray
    If a word starts with a vowel add "yay" to the end of the word.
    ate ➞ ateyay
    apple ➞ appleyay
    oaken ➞ oakenyay
    eagle ➞ eagleyay

    Write two functions to make an English to pig Latin translator. The first function translateWord(word) takes a single word and returns that word translated into pig latin. The second function translateSentence(sentence) takes an English sentence and returns that sentence translated into pig Latin.
    Examples
    translateWord("flag") ➞ "agflay"
    translateWord("Apple") ➞ "Appleyay"
    translateWord("button") ➞ "uttonbay"
    translateWord("") ➞ ""
    translateSentence("I like to eat honey waffles.") ➞ "Iyay ikelay otay eatyay oneyhay afflesway."
    translateSentence("Do you think it is going to rain today?") ➞ "Oday ouyay inkthay ityay isyay oinggay otay ainray odaytay?"
    Notes
    Regular expressions will help you not mess up the punctuation in the sentence.
    Vowels are the English vowels: a e i o u
    If the original word or sentence starts with a capital letter, the translation should preserve its case (see examples #2, #5 and #6).*/

    public static String translateWord(String word){
        //String result = "";
        char[] letters = word.toCharArray();
        List<Character> list = new ArrayList<>(
                Arrays.asList('a', 'e', 'i', 'o','u','A', 'E', 'I', 'O','U'));

            if(list.contains(word.charAt(0))){
                return word + "yay";
            }else{
                String firstLetters = "";
                int index = 0;
                for (char letter : letters){
                    if(list.contains(letter)){
                        return word.substring(index)+firstLetters+"ay";
                    }
                    firstLetters += letter;
                    index++;
                }
            }
          return "";
    }

    static String translateSentence(String sentence){
        String[] words = sentence.split(" ");
        String result ="";

        for(String word : words){
            result += translateWord(word) + " ";
        }
        return result;
    }
}




