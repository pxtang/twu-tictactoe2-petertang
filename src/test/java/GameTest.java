import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by ptang on 8/8/15.
 */
public class GameTest {

    private PrintStream printStream;
    private Board board;
    private BufferedReader bufferedReader;
    private Player player1, player2;
    private Game game;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        bufferedReader = mock(BufferedReader.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        game = new Game(printStream, board, player1, player2);
    }

    @Test
    public void shouldPrintBoardWhenStart() throws Exception {

        game.start();
        verify(printStream, atLeastOnce()).println(board.produceBoard());

    }

    @Test
    public void shouldHavePlayer1MoveWhenStart() throws Exception {
        game.start();

        verify(player1).move();
    }

    @Test
    public void shouldPrintBoardAfterPlayer1Move() throws Exception {
        game.start();
        verify(printStream, atLeast(2)).println(board.produceBoard());

    }

    @Test
    public void shouldHavePlayer2MoveWhenStart() throws Exception {
        game.start();

        verify(player2).move();
    }

    @Test
    public void shouldPrintBoardAfterPlayer2Move() throws Exception {
        game.start();
        verify(printStream, atLeast(3)).println(board.produceBoard());
    }

    @Test
    public void shouldPrintDrawIfGameIsDraw() throws Exception {
        when(board.isDraw()).thenReturn(true);
        game.start();
        verify(printStream).println("Game is a draw");

    }

}
