package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemWeaponTest {

    ItemWeapon axe;

    @BeforeEach
    public void setup(){
        axe = new ItemWeapon("Killer axe", 1, WeaponType.AXE, 5);
    }


    @Test
    public void hasCorrectName(){
        assertEquals(axe.getName(),"Killer axe");
    }

    @Test
    public void hasCorrectLevelReq(){
        assertEquals(axe.getRequiredLevel(),1);
    }

    @Test
    public void hasCorrectType(){
        assertEquals(axe.getWeaponType(),WeaponType.AXE);
    }

    @Test
    public void hasCorrectSlot(){
        assertEquals(axe.getSlot(),Slot.WEAPON);
    }

    @Test
    public void hasCorrectDamage(){
        assertEquals(axe.getWeaponDamage(),5);
    }

}