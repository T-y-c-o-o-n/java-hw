package game;

import java.util.*;
import game.*;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        int k = 3;
        List<PlayerNMK> players;
        try {
            players = List.of(
                    new HumanPlayerNMK(),
                    new HumanPlayerNMK()
            );
        } catch (NullPointerException e) {
            System.err.println("Null is bad player!");
            throw new IllegalArgumentException();
        }
        int cntPlayers = players.size();
        if (n * m >= 100000) {
            System.err.println("board is too large");
            throw new IllegalArgumentException();
        }
        if (cntPlayers < 1 || cntPlayers > 4) {
            System.err.println("Choose 2 / 3 / 4 players");
            throw new IllegalArgumentException();
        }
        if (n < 1 || m < 1 || k < 1) {
            throw new IllegalArgumentException();
        }
        final GameNMK game = new GameNMK(true, players);
        int result;
        /*
        NMKServerBoard args: n, m, k, count of players
        NMKRzhombusBoard args: n, k, count of players
         */
        result = game.play(new NMKRzhombusBoard(n, k, cntPlayers));
        System.out.println(result);
    }
}