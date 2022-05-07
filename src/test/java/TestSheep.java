import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class TestSheep {

    Sheep sheep;

    @Before
    public void setup(){
        this.sheep = new Sheep();
    }

    @Test
    public void testNewSheepStats(){
        assertEquals(6, this.sheep.timesAteToReproduce);
        assertEquals(2, this.sheep.endurance);
        assertEquals(2, this.sheep.health);
        assertEquals("\uD83D\uDC11", this.sheep.getEmoji());
    }

    @Test
    public void testReproduceNewSheepStats(){
        Animal newAnimal = this.sheep.reproduce();
        if (!(newAnimal instanceof Sheep)){
            fail();
        } else {
            Sheep newSheep = (Sheep) newAnimal;
            assertEquals(6, newSheep.timesAteToReproduce);
            assertEquals(2, newSheep.endurance);
            assertEquals(3, newSheep.health);
            assertEquals("\uD83D\uDC11", newSheep.getEmoji());
        }
    }
}
