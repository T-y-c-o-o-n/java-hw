package game.nmkgame;

import java.util.Random;

public class RandomPlayerNMK implements PlayerNMK {
    private final Random random;

    public RandomPlayerNMK(final Random random) {
        this.random = random;
    }

    public RandomPlayerNMK() {
        this(new Random());
    }

    @Override
    public MoveNMK move(final PlayerBoardNMK position, final Cell cell) {
        while (true) {
            int r = random.nextInt(position.getN());
            int c = random.nextInt(position.getM());
            final MoveNMK move = new MoveNMK(r, c, cell);
            if (position.isValid(move)) {
                return move;
            }
        }
    }
}
