
import org.heroes.HeroAttributes;
import org.enums.ArmorType;
import org.enums.Slot;
import org.items.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemArmorTest {

    ItemArmor cloth;

    @BeforeEach
    public void setup() {
        cloth = new ItemArmor("just cloth", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttributes(1, 1, 1));
    }

    @Test
    public void checkName_nameIsSameAsGiven_shouldPass(){
        Assertions.assertEquals(cloth.getName(), "just cloth");
    }

    @Test
    public void checkLevelReq_levelIsSameAsGiven_shouldPass(){
        Assertions.assertEquals(cloth.getRequiredLevel(), 1);
    }

    @Test
    public void checkSlot_slotIsSameAsAssigned_shouldPass(){
        Assertions.assertEquals(cloth.getSlot(), Slot.BODY);
    }

    @Test
    public void checkType_typeIsSameAsGiven_shouldPass(){
        Assertions.assertEquals(cloth.getArmorType(), ArmorType.CLOTH);
    }

    @Test
    public void checkAttributes_attributesAreSameAsGiven_shouldPass(){
        Assertions.assertEquals(cloth.getArmorAttributes().getStrength(), 1);
        Assertions.assertEquals(cloth.getArmorAttributes().getDexterity(), 1);
        Assertions.assertEquals(cloth.getArmorAttributes().getIntelligence(), 1);
    }



}