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
        play();
    }

    private void play() {
        Player currentPlayer = null;
        boolean keepPlaying = true;
        while(keepPlaying) {
            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
            currentPlayer.move();
            printStream.println(board.produceBoard());
            if (board.isDraw()) {
                printStream.println("Game is a draw");
                keepPlaying = false;
            }
        }
    }
}
