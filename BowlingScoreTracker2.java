/**
 * File name: BowlingScoreTracker2.java
 * Author: kultaran singh
 * Date: 07 july 2024
 * Description: A program to track and score a game of bowling for multiple players.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Player class to store player's name, scores, and total score.
class Player {
    private String name;
    private List<Integer> scores;
    private int totalScore;

    // Constructor to initialize player with a name.

    public Player(String name) {
        this.name = name;
        this.scores = new ArrayList<>();
        this.totalScore = 0;
    }

    // Prompt the user for the number and name of the players

    public String getName() {
        return name;
    }

    // Prompt the user for the scores of the players.

    public List<Integer> getScores() {
        return scores;
    }

    // prompt the user for the total scores of the players

    public int getTotalScore() {
        return totalScore;
    }

    // adds a score to the player's total and updates the score list.

    public void addScore(int score) {
        this.scores.add(score);
        this.totalScore += score;
    }

    // resets the scores for the player for a new game.
    public void resetScores() {
        this.scores.clear();
        this.totalScore = 0;
    }
}

// BowlingScoreTracker class to manage the game.

public class BowlingScoreTracker2 {

    private static Scanner scanner = new Scanner(System.in);

    // main method to initialise the game.

    public static void main(String[] args) {
        System.out.println("Welcome to the Bowling Score Tracker!");

        System.out.print("Enter the number of players: ");
        int numberOfPlayers = Integer.parseInt(scanner.nextLine().trim());

        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Enter name for player " + i + ": ");
            String playerName = scanner.nextLine().trim();
            players.add(new Player(playerName));
        }

        boolean playAgain;
        do {
            getGameScores(players);

            System.out.print("Would you like to play another game? (yes/no): ");
            playAgain = scanner.nextLine().trim().equalsIgnoreCase("yes");

            if (playAgain) {
                for (Player player : players) {
                    player.resetScores();
                }
            }
        } while (playAgain);
    }

    // validates the scores of the players provided by the user
    private static int getRoll(String playerName) {
        int score;
        while (true) {
            try {
                System.out.print("Enter the score for " + playerName + "'s roll: ");
                score = Integer.parseInt(scanner.nextLine());
                if (score >= 0 && score <= 10) {
                    return score;
                } else {
                    System.out.println("Invalid score. Please enter a number between 0 and 10.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    // manages a player's turn, handling strikes and spares.

    private static int getTurnScores(Player player) {
        int roll1 = getRoll(player.getName());
        if (roll1 == 10) {
            System.out.println(player.getName() + " got a strike!");
            player.addScore(10);
            return 10;
        } else {
            int roll2 = getRoll(player.getName());
            int frameScore = roll1 + roll2;
            if (frameScore == 10) {
                System.out.println(player.getName() + " got a spare!");
            }
            player.addScore(frameScore);
            return frameScore;
        }
    }

    // manages the game for all players over 10 frames.

    private static void getGameScores(List<Player> players) {
        for (int frame = 1; frame <= 10; frame++) {
            System.out.println("\nFrame " + frame + ":");
            for (Player player : players) {
                System.out.println(player.getName() + "'s turn:");
                getTurnScores(player);
            }
        }

        System.out.println("\nFinal Scores:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getTotalScore());
        }
    }
}
