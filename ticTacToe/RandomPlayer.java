package ticTacToe;

import java.util.Random;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class RandomPlayer implements Player {
    private final Random random;
    private int n, m;

    public RandomPlayer(final Random random) {
        this.random = random;
    }

    public RandomPlayer() {
        this(new Random());
    }

    public void setParams(int n, int m) {
        this.n = n;
        this.m = m;
    }

    @Override
    public Move move(final Position position, final Cell cell) {
        while (true) {
            int r = random.nextInt(m);
            int c = random.nextInt(n);
            final Move move = new Move(r, c, cell);
            if (position.isValid(move)) {
                return move;
            }
        }
    }
}
