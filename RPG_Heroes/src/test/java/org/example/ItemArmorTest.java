package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemArmorTest {

    ItemArmor cloth;

    @BeforeEach
    public void setup() {
        cloth = new ItemArmor("just cloth", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttributes(1, 1, 1));
    }

    @Test
    public void hasCorrectName(){
        assertEquals(cloth.getName(), "just cloth");
    }

    @Test
    public void hasCorrectLevelReq(){
        assertEquals(cloth.getRequiredLevel(),1);
    }

    @Test
    public void hasCorrectSlot(){
        assertEquals(cloth.getSlot(), Slot.BODY);
    }

    @Test
    public void hasCorrectType(){
        assertEquals(cloth.getArmorType(), ArmorType.CLOTH);
    }

    @Test
    public void hasCorrectAttributes(){
        assertEquals(cloth.getArmorAttributes().getStrength(),1);
        assertEquals(cloth.getArmorAttributes().getDexterity(),1);
        assertEquals(cloth.getArmorAttributes().getIntelligence(),1);
    }



}