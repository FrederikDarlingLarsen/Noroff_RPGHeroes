package org.example;

enum Slot{
    WEAPON,
    HEAD,
    BODY,
    LEGS
}

public class Item {
    private String name;
    private int requiredLevel;
    private Slot slot;

}
