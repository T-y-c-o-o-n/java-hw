package game.nmkgame;

import java.util.Random;

public class SequentialPlayerNMK implements PlayerNMK {
    public SequentialPlayerNMK() {
    }

    @Override
    public MoveNMK move(final PlayerBoardNMK position, final Cell cell) {
        for (int r = 0; r < position.getN(); r++) {
            for (int c = 0; c < position.getM(); c++) {
                final MoveNMK move = new MoveNMK(r, c, cell);
                if (position.isValid(move)) {
                    return move;
                }
            }
        }
        throw new IllegalStateException("No valid moves");
    }
}
