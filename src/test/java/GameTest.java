import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by ptang on 8/8/15.
 */
public class GameTest {
    @Test
    public void shouldPrintBoardWhenStart() throws Exception {
        PrintStream printStream = mock(PrintStream.class);
        Board board = mock(Board.class);

        Game game = new Game(printStream,board);
        game.start();
        verify(printStream).println(board.produceBoard());

    }
}
