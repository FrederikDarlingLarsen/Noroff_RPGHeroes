package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeroMageTest {

    HeroMage mage;

    @BeforeEach
    public void setup (){
        mage = new HeroMage("Darling");
    }

    @Test
    public void shouldCreateMage(){
        Assertions.assertNotNull(mage);
    }

   @Test
   public void createWithCorrectAttributes(){
        Assertions.assertEquals(mage.getLevel(),1);
       Assertions.assertEquals(mage.getName(),"Darling");
       Assertions.assertEquals(mage.getAttributes().getStrength(),1);
       Assertions.assertEquals(mage.getAttributes().getDexterity(),1);
       Assertions.assertEquals(mage.getAttributes().getIntelligence(),8);
   }

   @Test
    public void shouldCorrectlyIncreaseLevel(){
        mage.levelUp();
        Assertions.assertEquals(mage.getLevel(), 2);
       Assertions.assertEquals(mage.getAttributes().getStrength(),2);
       Assertions.assertEquals(mage.getAttributes().getDexterity(),2);
       Assertions.assertEquals(mage.getAttributes().getIntelligence(),13);
   }

    @Test
    public void shouldEquipWeapon(){
        ItemWeapon wand = new ItemWeapon("magical wand", 1, WeaponType.WAND, 5);
        mage.equipWeapon(wand);
        assertEquals(mage.getWeapon().getWeaponType(), WeaponType.WAND);
    }

    @Test
    public void shouldNotEquipWeaponType(){
        ItemWeapon axe = new ItemWeapon("killer axe", 1, WeaponType.AXE, 5);
      //  mage.equipWeapon(axe);
       // assertThrowsExactly(mage.equipWeapon(axe),)
    }

    @Test
    public void shouldEquipArmor(){
        ItemArmor cloth = new ItemArmor("just cloth", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttributes(1,1,3));
        mage.equipArmor(cloth);
        //Assertions.assertEquals;
    }
}