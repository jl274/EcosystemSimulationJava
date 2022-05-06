import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class TestMeadowBord {

    MeadowBoard board;

    @Before
    public void setup(){
        this.board = new MeadowBoard(10, 12);
    }

    @Test
    public void testMeadowDimension(){
        int xSize = this.board.getMeadow().length;
        int ySize = this.board.getMeadow()[0].length;
        assertArrayEquals(new int[]{10, 12}, new int[]{xSize, ySize});
    }

    @Test
    public void testIsEmptyWhenEmpty(){
        assertTrue(this.board.isFieldEmpty(0, 0));
    }

}
