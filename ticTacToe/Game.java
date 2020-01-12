package ticTacToe;

import java.util.List;
import java.io.*;

public class Game {
    private N_M_K_Board board;
    private final boolean log;
    private final List<Player> players;
    private final int cntPlayers;
    private int pntPl;

    public Game(final boolean log, final List<Player> players) {
        this.log = log;
        this.players = players;
        cntPlayers = players.size();
        pntPl = 1;
    }

    public int play() {
        while (true) {
            try (Scanner3000 sc = new Scanner3000(System.in)) {
                System.out.println("Enter correct n, m, k");
                int n = 0, m = 0, k = 0;
                n = sc.nextInt();
                m = sc.nextInt();
                k = sc.nextInt();
                // String type = sc.next();
                if (n * m >= (int)1e8) {
                    System.out.println("Board is too large!");
                    continue;
                }
                if (cntPlayers < 1 || cntPlayers > 4) {
                    System.out.println("Choose from 1 up to 4 players");
                    continue;
                }
                board = new N_M_K_Board(n, m, k, cntPlayers);
                for (Player player : players) {
                    player.setParams(n, m);
                }
                sc.close();
                break;
            } catch (IOException e) {
                System.out.println("Incorrect parametres! " + e.getMessage());
            } finally {

            }
        }
        while (true) {
            final int result = move(players.get(pntPl - 1), pntPl);
            if (result != -1) {
                return result;
            }
            pntPl = pntPl % cntPlayers + 1;
        }
    }

    private int move(final Player player, final int no) {
        final Move move = player.move(board.getPosition(), board.getCell());
        final Result result = board.makeMove(move);
        log("Player " + no + " move: " + move);
        log("Position:\n" + board);
        if (result == Result.WIN) {
            finish("Player " + no + " won");
            return no;
        } else if (result == Result.LOSE) {
            finish("Player " + no + " lose");
            return no == cntPlayers ? 1 : no + 1;
        } else if (result == Result.DRAW) {
            finish("Draw");
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
