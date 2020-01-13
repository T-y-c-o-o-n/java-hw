package game.nmkgame;

import java.util.Random;

public class Cheater implements Player {
    public Cheater() {
    }

    public Move move(PlayerBoard position, final Cell cell) {
        // AbstractBoard board = (AbstractBoard) position;
        // board.cells[2][2] = Cell.L;
        for (int r = 0; r < position.getN(); r++) {
            for (int c = 0; c < position.getM(); c++) {
                final Move move = new Move(r, c, cell);
                if (r >= position.getN() / 2) {
                    if (position.isValid(move)) {
                        return move;
                    }
                }
                if (position.isValid(move)) {
                    // board.makeMove(move);
                }
            }
        }
        return new Move(position.getN() / 2, position.getM() / 2, cell);
        // throw new IllegalStateException("Your game has been hacked!");
    }
}
