import java.io.PrintStream;

/**
 * Created by ptang on 8/8/15.
 */
public class Game {
    private PrintStream printStream;
    private Board board;

    public Game(PrintStream printStream, Board board) {

        this.printStream = printStream;
        this.board = board;
    }

    public void start() {
        printStream.println(board.produceBoard());
    }
}
