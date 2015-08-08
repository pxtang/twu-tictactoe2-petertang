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

    public Player(PrintStream printStream, BufferedReader bufferedReader, Board board) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.board = board;
    }

    public void move() {
        printStream.println("Input 1-9 to move");
        String locationInput = null;
        try {
            locationInput = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int locationToMark = 0;
        try {
            locationToMark = parseInt(locationInput)-1;
        } catch(NumberFormatException e) {
            printStream.println("Invalid input");
        }

        board.mark(locationToMark);
    }
}
