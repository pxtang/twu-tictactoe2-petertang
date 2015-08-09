import java.io.BufferedReader;
import java.io.InputStreamReader;
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

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Player player1 = new Player(printStream,bufferedReader, board, "X");
        Player player2 = new Player(printStream,bufferedReader, board, "O");
        Game game = new Game(printStream, board, player1, player2);
        game.start();
    }
}
