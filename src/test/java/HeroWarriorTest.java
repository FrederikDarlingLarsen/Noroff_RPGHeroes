import org.heroes.HeroAttributes;
import org.heroes.HeroWarrior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HeroWarriorTest {

    HeroWarrior warrior;

    @BeforeEach
    public void setup (){
        warrior = new HeroWarrior("Darling");
    }

    @Test
    public void checkName_nameIsSameAsGiven_shouldPass(){
        Assertions.assertEquals(warrior.getName(),"Darling");
    }

    @Test
    public void checkLevel_levelIsSameAsGiven_shouldPass(){
        Assertions.assertEquals(warrior.getLevel(),1);
    }

    @Test
    public void checkAttributes_attributesAreSameAsGiven_shouldPass(){
        Assertions.assertEquals(new HeroAttributes(5,2,1), warrior.getAttributes());
    }

    @Test
    public void increaseLevel_attributesAreCorrectlyIncreased_shouldPass(){
        warrior.levelUp();
        Assertions.assertEquals(new HeroAttributes(8,4,2),warrior.getAttributes());
    }
}