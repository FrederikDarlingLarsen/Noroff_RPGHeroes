import org.heroes.HeroAttributes;
import org.heroes.HeroMage;
import org.enums.ArmorType;
import org.enums.Slot;
import org.enums.WeaponType;
import org.items.*;
import org.items.ItemWeapon;
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
       Assertions.assertEquals(new HeroAttributes(1,1,8), mage.getAttributes());
   }

   @Test
    public void increaseLevel_attributesAreCorrectlyIncreased_shouldPass(){
        mage.levelUp();
       assertEquals(new HeroAttributes(2,2,13),mage.getAttributes());
   }

    @Test
    public void increaseAttributes_attributesAreCorrectlyIncreased_shouldPass(){  //is this correct or should it be add fron HeroAttribures?????
        mage.addAttributes(1,1,1);
        assertEquals(new HeroAttributes(2,2,9), mage.getAttributes());
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
    public void doNotEquipArmor_noArmorIsEquippedDueToWrongType_shouldPass(){
        ItemArmor leather = new ItemArmor("leather-suit", 1, Slot.BODY, ArmorType.LEATHER, new HeroAttributes(1,1,3));
        mage.equipArmor(leather);
        assertNull(mage.getArmor(Slot.BODY));
    }

    @Test
    public void doNotEquipArmor_noArmorIsEquippedDueToWrongLevel_shouldPass(){
        ItemArmor cloth = new ItemArmor("just cloth", 10, Slot.BODY, ArmorType.CLOTH, new HeroAttributes(1,1,3));
        mage.equipArmor(cloth);
        assertNull(mage.getArmor(Slot.BODY));
    }

   @Test
   public void totalAttributes_noEquipment_shouldPass(){
       assertEquals(new HeroAttributes(1,1,8), mage.getAttributes());
   }

    @Test
    public void totalAttributes_oneArmorPiece_shouldPass(){
       ItemArmor cloth = new ItemArmor("just cloth",1,Slot.BODY, ArmorType.CLOTH,new HeroAttributes(1,1,1));
       mage.equipArmor(cloth);
       assertEquals(new HeroAttributes(2,2,9), mage.getAttributes());
    }

    @Test
    public void totalAttributes_replacedArmorPiece_shouldPass(){
        ItemArmor cloth = new ItemArmor("just cloth",1,Slot.BODY,ArmorType.CLOTH,new HeroAttributes(1,1,1));
        ItemArmor anotherCloth = new ItemArmor("just another cloth",1,Slot.BODY,ArmorType.CLOTH,new HeroAttributes(1,3,1));
        mage.equipArmor(cloth);
        mage.equipArmor(anotherCloth);
        assertEquals(new HeroAttributes(2,4,9), mage.getAttributes());
    }

    @Test
    public void heroDamage_noWeapon_shouldPass(){
        double expected = (1 + mage.getAttributes().getIntelligence() / 100.0);
        assertEquals(expected, mage.damage());
    }

    @Test
    public void heroDamage_withWeapon_shouldPass(){
        ItemWeapon wand = new ItemWeapon("just a basic wand",1, WeaponType.WAND,3);
        mage.equipWeapon(wand);

        double expected = 3 * (1 + mage.getAttributes().getIntelligence() / 100.0);

        assertEquals(expected,mage.damage());
    }

    @Test
    public void heroDamage_replacedWeapon_shouldPass(){
        ItemWeapon wand = new ItemWeapon("just a basic wand",1,WeaponType.WAND,3);
        mage.equipWeapon(wand);
        ItemWeapon staff = new ItemWeapon("a staff",1,WeaponType.STAFF,5);
        mage.equipWeapon(staff);
        double expected = 5 * (1 + mage.getAttributes().getIntelligence() / 100.0);
        assertEquals(expected, mage.damage());
    }

    @Test
    public void heroDamage_withWeaponAndArmor_shouldPass(){
        ItemWeapon wand = new ItemWeapon("just a basic wand",1,WeaponType.WAND,3);
        mage.equipWeapon(wand);
        ItemArmor cloth = new ItemArmor("just cloth",1,Slot.BODY,ArmorType.CLOTH,new HeroAttributes(1,1,1));
        mage.equipArmor(cloth);
        double expected = 3 * (1 + mage.getAttributes().getIntelligence() / 100.0);
        assertEquals(expected, mage.damage());
    }

    @Test
    public void displayState_correctlyDisplay_shouldPass(){

        StringBuilder expected = new StringBuilder("Details of hero:" + "\n");
        String name = "Name: Darling" + "\n";
        expected.append(name);
        String className = "Class: MAGE" + "\n";
        expected.append(className);
        String level = "Level: 1" + "\n";
        expected.append(level);
        String attributes = "Strength: 1, Dexterity: 1, Intelligence: 8" + "\n";
        expected.append(attributes);
        String damage = "Damage: " + mage.damage();
        expected.append(damage);
        assertEquals(expected.toString(), mage.display().toString());
    }
}
