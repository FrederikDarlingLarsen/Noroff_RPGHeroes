import org.heroes.HeroAttributes;
import org.heroes.HeroRanger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class HeroRangerTest {

    HeroRanger ranger;

    @BeforeEach
    public void setup (){
        ranger = new HeroRanger("Kristian");
    }

    @Test
    public void checkName_nameIsSameAsGiven_shouldPass(){
        Assertions.assertEquals(ranger.getName(),"Kristian");
    }

    @Test
    public void checkLevel_levelIsSameAsGiven_shouldPass(){
        Assertions.assertEquals(ranger.getLevel(),1);
    }

    @Test
    public void checkAttributes_attributesAreSameAsGiven_shouldPass(){
        Assertions.assertEquals(new HeroAttributes(1,7,1), ranger.getAttributes());
    }

    @Test
    public void increaseLevel_attributesAreCorrectlyIncreased_shouldPass(){
        ranger.levelUp();
        assertEquals(new HeroAttributes(2,12,2),ranger.getAttributes());
    }

}