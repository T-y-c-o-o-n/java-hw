package ticTacToe;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class N_M_K_Board implements Board, Position {
    private static final Map<Cell, Character> SYMBOLS = Map.of(
            Cell.X, 'X',
            Cell.O, 'O',
            Cell.L, '-',
            Cell.I, '|',
            Cell.E, '.'
    );

    private final int n;
    private final int m;
    private final int k;
    private final int cntPlayers;
    private final Cell[][] cells;
    private int cntMoves;
    private Cell turn;

    public N_M_K_Board(int n, int m, int k, int cntPlayers) {
        this.n = n;
        this.m = m;
        this.k = k;
        this.cntPlayers = cntPlayers;
        cntMoves = 0;
        cells = new Cell[n][m];
        for (Cell[] row : cells) {
            Arrays.fill(row, Cell.E);
        }
        turn = Cell.X;
    }

    public Position getPosition() {  // FIXME
        return this;
    }

    public Cell getCell() {
        return turn;
    }

    public Result makeMove(final Move move) {
        if (!isValid(move)) {
            return Result.LOSE;  // ржомба
        }

        int xx = move.getRow();
        int yy = move.getColumn();
        cells[xx][yy] = move.getValue();
        cntMoves++;

        int inDiag1Sum = 1;
        int inDiag2Sum = 1;
        int inRowSum = 1;
        int inColSum = 1;
        int x = xx;
        int y = yy;
        while (y > 0 && cells[x][y] == turn) {  // в столбце
            y--;
            if (cells[x][y] == turn) {
                inColSum++;
            }
        }
        y = yy;
        while (y < (n - 1) && cells[x][y] == turn) {
            y++;
            if (cells[x][y] == turn) {
                inColSum++;
            }
        }
        y = yy;
        while (x > 0 && cells[x][y] == turn) {  // в строчке
            x--;
            if (cells[x][y] == turn) {
                inRowSum++;
            }
        }
        x = xx;
        while (x < (m - 1) && cells[x][y] == turn) {
            x++;
            if (cells[x][y] == turn) {
                inRowSum++;
            }
        }
        x = xx;
        while (x > 0 && y > 0 && cells[x][y] == turn) {  // в главной диагонали
            y--;
            x--;
            if (cells[x][y] == turn) {
                inDiag1Sum++;
            }
        }
        x = xx;
        y = yy;
        while (x < (m - 1) && y < (n - 1) && cells[x][y] == turn) {
            y++;
            x++;
            if (cells[x][y] == turn) {
                inDiag1Sum++;
            }
        }
        x = xx;
        y = yy;
        while (x < (m - 1) && y > 0 && cells[x][y] == turn) {  // в побочной диагонали
            x++;
            y--;
            if (cells[x][y] == turn) {
                inDiag2Sum++;
            }
        }
        x = xx;
        y = yy;
        while (x > 0 && y < (n - 1) && cells[x][y] == turn) {
            x--;
            y++;
            if (cells[x][y] == turn) {
                inDiag2Sum++;
            }
        }

        if (inRowSum >= k || inColSum >= k || inDiag1Sum >= k || inDiag2Sum >= k) {
            return Result.WIN;
        }
        
        if (cntMoves == m * n) {
            return Result.DRAW;
        }

        
    }


    public boolean isValid(final Move move) {
        return 0 <= move.getRow() && move.getRow() < n
                && 0 <= move.getColumn() && move.getColumn() < m
                && cells[move.getRow()][move.getColumn()] == Cell.E
                && turn == move.getValue();
    }

    public Cell getCell(final int r, final int c) {
        return cells[r][c];
    }

    @Override
    public String toString() {
        int lenX = (new StringBuilder(m + " ")).toString().length();
        int lenY = (new StringBuilder(n + " ")).toString().length();
        final StringBuilder sb = new StringBuilder((" ").repeat(lenY));
        for (int c = 0; c < m; ++c) {
            int tempLen = (new StringBuilder(c + " ")).toString().length();
            sb.append(c + (" ").repeat(lenX - tempLen + 1));
        }
        sb.append("\n");
        for (int r = 0; r < n; r++) {
            int tempLen = (new StringBuilder(r + " ")).toString().length();
            sb.append(r + (" ").repeat(lenY - tempLen + 1));
            for (int c = 0; c < m; c++) {
                sb.append(SYMBOLS.get(cells[r][c]) + (" ").repeat(lenY - 1));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}