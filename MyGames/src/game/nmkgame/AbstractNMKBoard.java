package game.nmkgame;

public abstract class AbstractNMKBoard extends AbstractBoard implements BoardNMK {
    private final int k;
    protected int cntMoves, maxCntMoves;

    public AbstractNMKBoard(int n, int m, int k, int cntPlayers) {
        super(n, m, cntPlayers);
        this.k = k;
        cntMoves = 0;
    }

    public int getK() {
        return k;
    }

    public PlayerBoardNMK getPosition() {
        return new PlayerBoardNMK(this);
    }

    public boolean isValid(final MoveNMK move) {
        return isValid(move.getRow(), move.getColumn()) &&
                cells[move.getRow()][move.getColumn()] == Cell.E &&
                turn == move.getValue();
    }

    protected boolean checkForLine(int r, int c, int dX, int dY) {
        int res = -1, x = r, y = c;
        while (isValid(x, y) && cells[x][y] == turn) {
            res++;
            x += dX;
            y += dY;
        }
        x = r;
        y = c;
        while (isValid(x, y) && cells[x][y] == turn) {
            res++;
            x -= dX;
            y -= dY;
        }
        return res >= k;
    }

    private boolean isWinResult(int r, int c) {
        return checkForLine(r, c, 1, 0) ||
                checkForLine(r, c, 0, 1) ||
                checkForLine(r, c, 1, 1) ||
                checkForLine(r, c, 1, -1);
    }

    public Result makeMove(final MoveNMK move) {
        if (!isValid(move)) {
            return Result.LOSE;
        }
        cells[move.getRow()][move.getColumn()] = turn;
        if (isWinResult(move.getRow(), move.getColumn())) {
            return Result.WIN;
        }
        cntMoves++;
        if (cntMoves == m * n) {
            return Result.DRAW;
        }

        if (turn == Cell.X) {
            turn = Cell.O;
        } else if (turn == Cell.O) {
            turn = cntPlayers >= 3 ? Cell.L : Cell.X;
        } else if (turn == Cell.L) {
            turn = cntPlayers >= 4 ? Cell.I : Cell.X;
        } else {
            turn = Cell.X;
        }
        return Result.UNKNOWN;
    }
}
