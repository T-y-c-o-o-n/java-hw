package ticTacToe;

import java.io.*;
import java.util.*;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class HumanPlayer implements Player {
    private final PrintStream out;

    public HumanPlayer() {
        this.out = System.out;
    }

    public void setParams(int n, int m) {

    }

    @Override
    public Move move(final Position position, final Cell cell) {
        //while (true) {
        //    try (Scanner sc = new Scanner(System.in)) {
        //        Scanner3000 fict = new Scanner3000("abacaba");
                out.println("Enter row and column");
                Scanner sc = new Scanner(System.in);
                int r = 0, c = 0;
                r = sc.nextInt();
                c = sc.nextInt();
                final Move move = new Move(r, c, cell);
                if (position.isValid(move)) {
                    return move;
                }
                out.println("Move " + move + " is invalid");
                return null;
        //    } catch(IOException e) {
        //        out.println("Incorrect data!" + e.getMessage());
        //    }
        //}
    }
}