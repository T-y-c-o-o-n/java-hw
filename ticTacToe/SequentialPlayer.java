package ticTacToe;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class SequentialPlayer implements Player {
    private int n, m;
    public SequentialPlayer() {
    }

    public void setParams(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public Move move(final Position position, final Cell cell) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                final Move move = new Move(r, c, cell);
                if (position.isValid(move)) {
                    return move;
                }
            }
        }
        throw new IllegalStateException("No valid moves");
    }
}
