package game.nmkgame;

public interface BoardNMK {
    int getN();
    int getM();
    int getK();
    Cell getCell();
    PlayerBoard getPosition();
    Result makeMove(MoveNMK move);
}
