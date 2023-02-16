package org.items;

import org.enums.Slot;

public abstract class Item {
    private final String name;
    private final int requiredLevel;
    private final Slot slot;

    public Item(String _name, int _reqLevel, Slot _slot){
        this.name = _name;
        this.requiredLevel = _reqLevel;
        this.slot = _slot;
    }

    public String getName(){
        return this.name;
    }

    public int getRequiredLevel(){
        return this.requiredLevel;
    }

    public Slot getSlot(){
        return this.slot;
    }
}