import java.io.PrintStream;

/**
 * Created by ptang on 8/8/15.
 */
public class Game {
    private PrintStream printStream;
    private Board board;
    private Player player1;
    private Player player2;

    public Game(PrintStream printStream, Board board, Player player1, Player player2) {

        this.printStream = printStream;
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        printStream.println(board.produceBoard());
        player1.move();
        printStream.println(board.produceBoard());
        player2.move();
        printStream.println(board.produceBoard());
    }
}
