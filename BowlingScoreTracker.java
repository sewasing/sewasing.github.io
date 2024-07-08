import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Player {
    private String name;
    private List<Integer> scores;
    private int totalScore;

    public Player(String name) {
        this.name = name;
        this.scores = new ArrayList<>();
        this.totalScore = 0;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void addScore(int score) {
        this.scores.add(score);
        this.totalScore += score;
    }

    public void resetScores() {
        this.scores.clear();
        this.totalScore = 0;
    }
}

public class BowlingScoreTracker {

    private static Scanner scanner = new Scanner(System.in);

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
