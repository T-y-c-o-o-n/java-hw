package game.nmkgame;

public final class NMKSquareBoard extends AbstractNMKBoard {
    public NMKSquareBoard(int n, int m, int k, int cntPlayers) {
        super(n, m, k, cntPlayers);
        maxCntMoves = n * m;
    }
}
