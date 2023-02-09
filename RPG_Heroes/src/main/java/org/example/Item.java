package org.example;

enum Slot{
    WEAPON,
    HEAD,
    BODY,
    LEGS
}
public abstract class Item {
    private final String name;
    private final int requiredLevel;
    private final Slot slot;

    public Item(String _name, int _reqLevel, Slot _slot){
        this.name = _name;
        this.requiredLevel = _reqLevel;
        this.slot = _slot;
    }

    public String GetName(){
        return this.name;
    }

    public int GetRequiredLevel(){
        return this.requiredLevel;
    }

    public Slot GetSlot(){
        return this.slot;
    }
}