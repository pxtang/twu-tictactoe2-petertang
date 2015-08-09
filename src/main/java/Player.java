import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static java.lang.Integer.parseInt;

/**
 * Created by ptang on 8/8/15.
 */
public class Player {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Board board;
    private String symbol;

    public Player(PrintStream printStream, BufferedReader bufferedReader, Board board, String symbol) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.board = board;
        this.symbol = symbol;
    }

    public void move() {
        boolean validMove = false;
        int locationToMark = 0;

        while(!validMove) {
            printStream.println("Input 1-9 to move");
            String locationInput = null;
            try {
                locationInput = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                locationToMark = parseInt(locationInput) - 1;
            } catch (NumberFormatException e) {
                printStream.println("Invalid input");
            }

            validMove = board.canMove(locationToMark);
            if (!validMove) {
                printStream.println("Location already taken");
            }
        }

        board.mark(locationToMark, symbol);
    }
}
