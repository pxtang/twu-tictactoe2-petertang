import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by ptang on 8/8/15.
 */
public class GameLauncher {
    public static void main(String[] args) {
        PrintStream printStream = System.out;

        List<String> cells = new ArrayList<>(asList(" "," "," "," "," "," "," "," "," "));
        Board board = new Board(cells);

        Game game = new Game(printStream, board);
        game.start();
    }
}
