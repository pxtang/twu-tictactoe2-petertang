import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by ptang on 8/8/15.
 */
public class PlayerTest {

    private PrintStream printStream;
    private Player player;
    private Board board;
    private BufferedReader bufferedReader;
    private final String DEFAULT_SYMBOL = "X";

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        board = mock(Board.class);
        player = new Player(printStream, bufferedReader, board, DEFAULT_SYMBOL);
    }

    @Test
    public void shouldRequestMoveInputWhenPlayerMove() throws Exception {
        player.move();

        verify(printStream).println("Input 1-9 to move");
    }

    @Test
    public void shouldTryToMarkBoardLocation0WhenUserInput1() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1");
        player.move();

        verify(board).mark(0, "X");
    }

    @Test
    public void shouldTryToMarkBoardLocation1WhenUserInput2() throws Exception {
        when(bufferedReader.readLine()).thenReturn("2");
        player.move();

        verify(board).mark(1, "X");
    }

    @Test
    public void shouldMarkWithPlayerSymbolWhenPlayerMarks() throws Exception {
        player = new Player(printStream,bufferedReader,board,"e");
        when(bufferedReader.readLine()).thenReturn("1");

        player.move();
        verify(board).mark(0,"e");

    }

    @Test
    public void shouldSayInvalidLocationWhenPlayerTriesToMoveInOccupiedSpace() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1", "2");
        when(board.canMove(0)).thenReturn(false, true);
        player.move();

        verify(printStream).println("Location already taken");

    }

    @Test
    public void shouldSayInvalidLocationTwiceWhenPlayerTriesToMoveInOccupiedSpaceTwice() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1", "1", "2");
        when(board.canMove(0)).thenReturn(false, false);
        when(board.canMove(1)).thenReturn(true);
        player.move();

        verify(printStream, times(2)).println("Location already taken");

    }
}
