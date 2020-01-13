package game.nmkgame;



public class PlayerBoardNMK {
    private AbstractNMKBoard position;

    PlayerBoardNMK(AbstractNMKBoard position) {
        this.position = position;
    }

    public int getN() {
        return position.getN();
    }

    public int getM() {
        return position.getM();
    }

    public int getK() {
        return position.getK();
    }

    public Cell getCell() {
        return position.getCell();
    }

    public boolean isValid(final MoveNMK move) {
        return position.isValid(move);
    }
}