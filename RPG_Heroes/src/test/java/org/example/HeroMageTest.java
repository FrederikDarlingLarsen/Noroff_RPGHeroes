package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeroMageTest {

    HeroMage mage;

    @BeforeEach
    public void setup (){
        mage = new HeroMage("Darling");
    }

   /* @Test
    public void shouldCreateMage(){
        Assertions.assertNotNull(mage);
    }*/

    @Test
    public void checkName_nameIsSameAsGiven_shouldPass(){
        Assertions.assertEquals(mage.getName(),"Darling");
    }

    @Test
    public void checkLevel_levelIsSameAsGiven_shouldPass(){
        Assertions.assertEquals(mage.getLevel(),1);
    }

    @Test
   public void checkAttributes_attributesAreSameAsGiven_shouldPass(){
       Assertions.assertEquals(mage.getAttributes().getStrength(),1);
       Assertions.assertEquals(mage.getAttributes().getDexterity(),1);
       Assertions.assertEquals(mage.getAttributes().getIntelligence(),8);
   }

   @Test
    public void increaseLevel_attributesAreCorrectlyIncreased_shouldPass(){
        mage.levelUp();
        Assertions.assertEquals(mage.getLevel(), 2);
       Assertions.assertEquals(mage.getAttributes().getStrength(),2);
       Assertions.assertEquals(mage.getAttributes().getDexterity(),2);
       Assertions.assertEquals(mage.getAttributes().getIntelligence(),13);
   }

    @Test
    public void increaseAttributes_attributesAreCorrectlyIncreased_shouldPass(){
        mage.addAttributes(1,1,1);
        Assertions.assertEquals(mage.getAttributes().getStrength(),2);
        Assertions.assertEquals(mage.getAttributes().getDexterity(),2);
        Assertions.assertEquals(mage.getAttributes().getIntelligence(),9);

    }

    @Test
    public void equipWeapon_correctWeaponIsEquipped_shouldPass(){
        ItemWeapon wand = new ItemWeapon("magical wand", 1, WeaponType.WAND, 5);
        mage.equipWeapon(wand);
        assertEquals(mage.getWeapon().getWeaponType(), WeaponType.WAND);
    }

    @Test
    public void doNotEquipWeapon_NoWeaponIsEquippedDueToWrongType_shouldPass(){
        ItemWeapon axe = new ItemWeapon("killer axe", 1, WeaponType.AXE, 5);
        mage.equipWeapon(axe);
        assertNull(mage.getWeapon());
    }

    @Test
    public void doNotEquipWeapon_NoWeaponIsEquippedDueToWrongLevel_shouldPass(){
        ItemWeapon wand = new ItemWeapon("magical wand", 10, WeaponType.WAND, 5);
        mage.equipWeapon(wand);
        assertNull(mage.getWeapon());

    }

    @Test
    public void equipArmor_correctArmorIsEquipped_shouldPass(){
        ItemArmor cloth = new ItemArmor("just cloth", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttributes(1,1,3));
        mage.equipArmor(cloth);
        assertEquals(mage.getArmor(Slot.BODY).getArmorType(), ArmorType.CLOTH);
    }

    @Test
    public void doNotEquipArmor_NoArmorIsEquippedDueToWrongType_shouldPass(){
        ItemArmor leather = new ItemArmor("leather-suit", 1, Slot.BODY, ArmorType.LEATHER, new HeroAttributes(1,1,3));
        mage.equipArmor(leather);
        assertNull(mage.getArmor(Slot.BODY));
    }

    @Test
    public void doNotEquipArmor_NoArmorIsEquippedDueToWrongLevel_shouldPass(){
        ItemArmor cloth = new ItemArmor("just cloth", 10, Slot.BODY, ArmorType.CLOTH, new HeroAttributes(1,1,3));
        mage.equipArmor(cloth);
        assertNull(mage.getArmor(Slot.BODY));
    }



    /*Total attributes should be calculated correctly
    o With no equipment
    o With one piece of armor
    o With two pieces of armor
    o With a replaced piece of armor (equip armor, then equip new armor in the same slot)*/


    /* Hero damage should be calculated properly
o No weapon equipped
o Weapon equipped
o Replaced weapon equipped (equip a weapon then equip a new weapon)
o Weapon and armor equipped
*/


    //  Heroes should display their state correctly
}
