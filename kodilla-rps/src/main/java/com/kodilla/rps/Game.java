package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int gameMode;
    private int roundsCounter;
    private Player userPlayer = new Player("Player 1");
    //private Player computerPlayer
    //private Arbiter arbiter = new Arbiter();
    private List<String> items = new ArrayList<>();

    public int chooseItem(int playerChoice, Player player) {
        System.out.println(player.getName() +": " + items.get(playerChoice));
        return playerChoice;
    }

}
