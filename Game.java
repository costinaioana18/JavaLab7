package com.company;

import java.util.ArrayList;

/**
 * The game creates the borad, adds the players
 */
public class Game {
    private ArrayList<Player> players = new ArrayList<>();
    private int tokensNumber;
    private int maxValue;
    private int progressionsSize;

    public Game(int tokensNumber, int maxValue, int progressionsSize) {
        this.tokensNumber = tokensNumber;
        this.maxValue = maxValue;
        this.progressionsSize = progressionsSize;
    }

    /**
     * The method creates the board and the players and uses a thread for each player
     */
    public void playGame() {
        Board board = new Board(tokensNumber, maxValue, progressionsSize);
        Runnable player1 = new Player(1, "Noah", board);
        Runnable player2 = new Player(2, "Sam", board);
        Runnable player3 = new Player(3, "Jasmine", board);

        System.out.println("The current game has the following " + board.getPlayersNumber() + " players:");
        board.printPlayers();
        board.printBoard();
        new Thread(player1).start();
        new Thread(player2).start();
        new Thread(player3).start();

    }

}
