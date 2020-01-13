package game.nmkgame;

import java.util.List;
import java.util.Scanner;

public class GameNMK {
    private final boolean log;
    private final List<PlayerNMK> players;
    private final int cntPlayers;

    public GameNMK(final boolean log, final List<PlayerNMK> players) {
        this.log = log;
        this.players = players;
        if (players != null) {
            cntPlayers = players.size();
        } else {
            cntPlayers = 0;
        }
    }

    public int play(BoardNMK board) {
        try {
            int pnt = 0;
            while (true) {
                final int result = move(board, players.get(pnt), pnt + 1);
                if (result != -1) {
                    return result;
                }
                pnt = (pnt + 1) % cntPlayers;
            }
        } catch (NullPointerException e) {
            System.err.println("Null is bad player!");
        }
        return -1;
    }

    private int move(final BoardNMK board, final PlayerNMK player, final int no) throws NullPointerException  {
        System.out.println(board.getClass());
        final MoveNMK move = player.move(board.getPosition(), board.getCell());
        final Result result = board.makeMove(move);
        log("Player " + no + " move: " + move);
        log("Position:\n" + board);
        if (result == Result.WIN) {
            finish(" Player " + no + " won");
            return no;
        } else if (result == Result.LOSE) {
            finish("Player " + no + " lose");
            return no;
        } else if (result == Result.DRAW) {
            finish("     Draw");
            return 0;
        } else {
            return -1;
        }
    }

    private void log(final String message) {
        if (log) {
            System.out.println(message);
        }
    }

    private void finish(final String message) {
        System.out.println(("#").repeat(14));
        System.out.println(message);
        System.out.println(("#").repeat(14));
    }
}
