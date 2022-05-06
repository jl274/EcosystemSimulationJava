import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class TestGrass {

    Grass grass;

    @Before
    public void setup(){
        this.grass = new Grass();
    }

    @Test
    public void testCreatingGrassProperties(){
        assertEquals(0, this.grass.rounds);
        assertEquals(4, this.grass.roundToReproduce);
        assertEquals(0.2, this.grass.reproduceChance, 0.01);
        assertEquals("\uD83C\uDF3F", this.grass.getEmoji());
    }
}
