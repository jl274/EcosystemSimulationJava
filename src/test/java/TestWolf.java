import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class TestWolf {

    Wolf wolf;

    @Before
    public void setup(){
        this.wolf = new Wolf();
    }

    @Test
    public void testWolfStats(){
        assertEquals(2, this.wolf.timesAteToReproduce);
        assertEquals(5, this.wolf.endurance);
        assertEquals(6, this.wolf.health);
        assertEquals("\uD83D\uDC3A", this.wolf.getEmoji());
    }

    @Test
    public void testIsEnduranceSquareAfterReproduce(){
        this.wolf.reproduce();
        assertEquals(4, this.wolf.timesAteToReproduce);
    }
}
