package game.nmkgame;

import java.io.PrintStream;
import java.util.Scanner;

public class HumanPlayerNMK implements PlayerNMK {
    private final PrintStream out;
    private final Scanner in;

    public HumanPlayerNMK() {
        this(System.out, new Scanner(System.in));
    }

    public HumanPlayerNMK(final PrintStream out, final Scanner in) {
        this.out = out;
        this.in = in;

    }

    @Override
    public MoveNMK move(final PlayerBoardNMK position, final Cell cell) {
        while (true) {
            out.println("Enter row and column");
            int r = 0, c = 0;
            boolean incorrect = true;
            if (in.hasNextInt()) {
                r = in.nextInt();
                if (in.hasNextInt()) {
                    c = in.nextInt();
                    incorrect = false;
                }
            }
            in.nextLine();
            if (incorrect) {
                out.println("Input is incorrect");
                continue;
            }
            final MoveNMK move = new MoveNMK(r, c, cell);
            if (position.isValid(move)) {
                return move;
            }
            final int row = move.getRow();
            final int column = move.getColumn();
            out.println("Move " + move + " is invalid");
        }
    }
}
