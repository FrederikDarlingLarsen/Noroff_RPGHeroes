import org.heroes.HeroAttributes;
import org.heroes.HeroRogue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class HeroRogueTest {

    HeroRogue rogue;

    @BeforeEach
    public void setup (){
        rogue = new HeroRogue("Darling");
    }

    @Test
    public void checkName_nameIsSameAsGiven_shouldPass(){
        Assertions.assertEquals(rogue.getName(),"Darling");
    }

    @Test
    public void checkLevel_levelIsSameAsGiven_shouldPass(){
        Assertions.assertEquals(rogue.getLevel(),1);
    }

    @Test
    public void checkAttributes_attributesAreSameAsGiven_shouldPass(){
        Assertions.assertEquals(new HeroAttributes(2,6,1), rogue.getAttributes());
    }

    @Test
    public void increaseLevel_attributesAreCorrectlyIncreased_shouldPass(){
        rogue.levelUp();
        assertEquals(new HeroAttributes(3,10,2),rogue.getAttributes());
    }
}