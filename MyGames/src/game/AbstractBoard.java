package game;

import java.util.Arrays;

public abstract class AbstractBoard {
    protected final int n, m, cntPlayers;
    protected final Cell[][] cells;
    protected Cell turn;

    public AbstractBoard(int n, int m, int cntPlayers) {
        this.n = n;
        this.m = m;
        this.cntPlayers = cntPlayers;
        cells = new Cell[n][m];
        for (Cell[] row : cells) {
            Arrays.fill(row, Cell.E);
        }
        turn = Cell.X;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public Cell getCell() {
        return turn;
    }

    protected boolean isValid(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < m;
    }

    @Override
    public String toString() {
        int lenX = (m + " ").length();
        int lenY = (n + " ").length();
        final StringBuilder sb = new StringBuilder((" ").repeat(lenY));
        for (int c = 0; c < m; ++c) {
            int tempLen = (c + " ").length();
            sb.append(c).append((" ").repeat(lenX - tempLen + 1));
        }
        sb.append("\n");
        for (int r = 0; r < n; r++) {
            int tempLen = (r + " ").length();
            sb.append(r).append((" ").repeat(lenY - tempLen + 1));
            for (int c = 0; c < m; c++) {
                sb.append(cells[r][c]).append((" ").repeat(lenY - 1));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}