import org.heroes.HeroAttributes;
import org.heroes.HeroWarrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class HeroWarriorTest {

    HeroWarrior warrior;

    @BeforeEach
    public void setup (){
        warrior = new HeroWarrior("Darling");
    }

    @Test
    public void checkName_nameIsSameAsGiven_shouldPass(){
        assertEquals(warrior.getName(),"Darling");
    }

    @Test
    public void checkLevel_levelIsSameAsGiven_shouldPass(){
        assertEquals(warrior.getLevel(),1);
    }

    @Test
    public void checkAttributes_attributesAreSameAsGiven_shouldPass(){
        assertEquals(new HeroAttributes(5,2,1), warrior.getAttributes());
    }

    @Test
    public void increaseLevel_attributesAreCorrectlyIncreased_shouldPass(){
        warrior.levelUp();
        assertEquals(new HeroAttributes(8,4,2),warrior.getAttributes());
    }
}