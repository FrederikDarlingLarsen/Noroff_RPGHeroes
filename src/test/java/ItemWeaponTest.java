
import org.enums.Slot;
import org.enums.WeaponType;
import org.items.ItemWeapon;
import org.junit.jupiter.api.Assertions;
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
        Assertions.assertEquals(axe.getName(),"Killer axe");
    }

    @Test
    public void checkLevelReq_levelIsSameAsGiven_shouldPass(){
        Assertions.assertEquals(axe.getRequiredLevel(),1);
    }

    @Test
    public void checkType_typeIsSameAsGiven_shouldPass(){
        Assertions.assertEquals(axe.getWeaponType(),WeaponType.AXE);
    }

    @Test
    public void checkSlot_slotIsSameAsGiven(){
        Assertions.assertEquals(axe.getSlot(), Slot.WEAPON);
    }

    @Test
    public void checkDamage_damageIsSameAsGiven_shouldPass(){
        Assertions.assertEquals(axe.getWeaponDamage(),5);
    }
}