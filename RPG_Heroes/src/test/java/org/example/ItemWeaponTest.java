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
    public void checkName_nameIsSameAsGiven_shouldPass(){
        assertEquals(axe.getName(),"Killer axe");
    }

    @Test
    public void checkLevelReq_levelIsSameAsGiven_shouldPass(){
        assertEquals(axe.getRequiredLevel(),1);
    }

    @Test
    public void checkType_typeIsSameAsGiven_shouldPass(){
        assertEquals(axe.getWeaponType(),WeaponType.AXE);
    }

    @Test
    public void checkSlot_slotIsSameAsGiven(){
        assertEquals(axe.getSlot(),Slot.WEAPON);
    }

    @Test
    public void checkDamage_damageIsSameAsGiven_shouldPass(){
        assertEquals(axe.getWeaponDamage(),5);
    }
}