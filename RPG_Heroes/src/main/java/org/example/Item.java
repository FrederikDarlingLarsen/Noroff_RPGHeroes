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

    public Item(String _name, int _reqLevel, Slot _slot){
        this.name = _name;
        this.requiredLevel = _reqLevel;
        this.slot = _slot;
    }
}
