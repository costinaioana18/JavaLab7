package com.company;

import java.util.ArrayList;

/**
 * The player repeatedly chooses a token, waits for his turn due to the synchronisation, creates an arithmetic progression
 */
public class Player implements Runnable {

    private String name;
    private int id;
    int value;
    Board board;
    private ArrayList<Integer> tokensValues = new ArrayList<>();

    public Player(int id, String name, Board board) {
        this.id = id;
        this.name = name;
        this.board = board;
        board.addPlayers(this);
    }

    /**
     * @return the player's name
     */
    public String getName() {
        return this.name;
    }

    @Override
    public void run() {
        this.extractToken();

    }

    /**
     * The method randomly extracts a token from the board while the board still has tokens and while there is no other winner
     * "value" holds the round number
     * It tells the board to change the players turn after he extracts his number
     * After the extractions are over, it prints his own arithmetic progression and adds his max length to the board
     *
     */
    public synchronized void extractToken() {
        int i = 1;
        int gameOver = 0;
        while (i < 5 && board.outOfTokens() == 0 && gameOver == 0) {
            if (board.getTurn() == id) {
                value++;
                double rand = Math.random();
                int index = (int) (rand * board.getNumberOfTokens());
                System.out.println("Round " + value + ": " + name + " has chosen the token with index " + index);
                tokensValues.add(board.getTokenValue(index));
                if (this.progressionLength() == board.getProgressionsSize()) gameOver = 1;
                board.chooseToken(index);
                board.printBoard();
                i++;
                board.changeTurn();

            }
        }
        try {
            wait(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "'s progression is: " + tokensValues);
        board.addScore(this.progressionLength());


    }

    /**
     * the method calculated the players maximum arithmetic progression lenght
     * @return max length
     */
    public int progressionLength() {
        int maxLenght = 2;
        if (tokensValues.size() > 2) {
            int currentLenght = 2;
            int r = tokensValues.get(1) - tokensValues.get(0);
            for (int i = 2; i < tokensValues.size(); i++) {
                if (tokensValues.get(i) - tokensValues.get(i - 1) == r || tokensValues.get(i) == 0 || tokensValues.get(i - 1) == 0)
                    currentLenght++;
                else {
                    if (currentLenght > maxLenght) maxLenght = currentLenght;
                    r = tokensValues.get(i) - tokensValues.get(i - 1);
                    currentLenght = 2;

                }

            }
        }
        return maxLenght;
    }

}
