import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ptang on 8/8/15.
 */
public class PlayerTest {

    private PrintStream printStream;
    private Player player;
    private Board board;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        board = mock(Board.class);
        player = new Player(printStream, bufferedReader, board);
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

        verify(board).mark(0);
    }

    @Test
    public void shouldTryToMarkBoardLocation1WhenUserInput2() throws Exception {
        when(bufferedReader.readLine()).thenReturn("2");
        player.move();

        verify(board).mark(1);
    }
}
