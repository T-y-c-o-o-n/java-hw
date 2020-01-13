package game.nmkgame;

public final class NMKRzhombusBoard extends AbstractNMKBoard {
    public NMKRzhombusBoard(int n, int k, int cntPlayers) {
        super(n, n, k, cntPlayers);
        for (int j = 0; j < n; j++) {
            cells[0][j] = Cell.F;
        }
        cells[0][n/2] = Cell.E;
        maxCntMoves++;
        if (n % 2 == 0) {
            cells[0][n/2 - 1] = Cell.E;
            maxCntMoves++;
        }
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 0; j < n; j++) {
                boolean f = false;
                if (j > 0 && cells[i-1][j-1] == Cell.E || j < n - 1 && cells[i-1][j+1] == Cell.E || cells[i-1][j] == Cell.E) {
                    cells[i][j] = Cell.E;
                } else {
                    cells[i][j] = Cell.F;
                    maxCntMoves++;
                }
            }
        }
        for (int i = n / 2 + 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean f = false;
                if (j > 0 && cells[i-1][j-1] == Cell.E && j < n - 1 && cells[i-1][j+1] == Cell.E) {
                    cells[i][j] = Cell.E;
                } else {
                    cells[i][j] = Cell.F;
                    maxCntMoves++;
                }
            }
        }
    }
}
