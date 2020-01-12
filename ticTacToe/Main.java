package ticTacToe;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(true, List.of(new HumanPlayer(), new RandomPlayer()));
        int result;
        result = game.play();
        System.out.println("Game Over!\n" + result);
    }
}