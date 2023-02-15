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
    public void checkName_nameIsSameAsGiven_shouldPass(){
        assertEquals(cloth.getName(), "just cloth");
    }

    @Test
    public void checkLevelReq_levelIsSameAsGiven_shouldPass(){
        assertEquals(cloth.getRequiredLevel(),1);
    }

    @Test
    public void checkSlot_slotIsSameAsAssigned_shouldPass(){
        assertEquals(cloth.getSlot(), Slot.BODY);
    }

    @Test
    public void checkType_typeIsSameAsGiven_shouldPass(){
        assertEquals(cloth.getArmorType(), ArmorType.CLOTH);
    }

    @Test
    public void checkAttributes_attributesAreSameAsGiven_shouldPass(){
        assertEquals(cloth.getArmorAttributes().getStrength(),1);
        assertEquals(cloth.getArmorAttributes().getDexterity(),1);
        assertEquals(cloth.getArmorAttributes().getIntelligence(),1);
    }



}