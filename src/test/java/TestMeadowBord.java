import org.junit.After;
import org.junit.Test;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TestMeadowBord {

    MeadowBoard board;
    ByteArrayOutputStream outContent;
    PrintStream originalOut;

    @Before
    public void setup(){
        this.board = new MeadowBoard(10, 12);
        this.outContent = new ByteArrayOutputStream();
        this.originalOut = System.out;
        System.setOut(new PrintStream(this.outContent));
    }

    @After
    public void teardown(){
        System.setOut(this.originalOut);
    }

    @Test
    public void testMeadowDimension(){
        int xSize = this.board.getMeadow().length;
        int ySize = this.board.getMeadow()[0].length;
        assertArrayEquals(new int[]{this.board.getXSize(), this.board.getYSize()}, new int[]{xSize, ySize});
    }

    @Test
    public void testIsEmptyWhenEmpty(){
        assertTrue(this.board.isFieldEmpty(0, 0));
    }

    @Test
    public void testPrintBoardLineEmpty(){
        this.board.printBoard();
        assertTrue(this.outContent
                .toString()
                .contains("\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D" +
                        "\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9\uD83D\uDFE9"));
    }

}
