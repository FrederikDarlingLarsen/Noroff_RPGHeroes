package org.example;

public class Main {
    public static void main(String[] args) {

        HeroMage mage = new HeroMage("Darling");

        mage.Display();
        mage.addAttributes(2,1,3);
        mage.Display();
    }
}