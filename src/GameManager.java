import java.util.Scanner;

/**
 * Manages program.
 */
public class GameManager {
    /**
     * Player one.
     */
    private Player playerOne;

    /**
     * Player two.
     */
    private Player playerTwo;

    /**
     * Reads input from standard output.
     */
    Scanner scanner = new Scanner(System.in);

    /**
     * Starts the program, provides a console interface.
     */
    public void run() {
        System.out.println("TicTacToe Game");
        System.out.println("--------------------------");
        this.createPlayers();
    }

    private void createPlayers() {
        String name;

        // Create player one.
        System.out.println("Create player one: ");
        System.out.println("--------------------");
        System.out.println("Enter player one name: ");
        while (true) {
            if (scanner.hasNextLine()) {
                name = scanner.nextLine();
                if (!name.isEmpty()) {
                    this.playerOne = new Player(name, false, "X");
                    break;
                } else {
                    System.out.println("Enter a valid name!");
                    continue;
                }
            }
        }

        // Create player two.
        System.out.println("--------------------");
        System.out.println("Enter player two name:");
        while (true) {
            if (scanner.hasNextLine()) {
                name = scanner.nextLine();
                if (!name.isEmpty()) {
                    break;
                } else {
                    System.out.println("Enter a valid name!");
                }
            }
        }

        // Ask user if player two is a computer.
        System.out.println("Do you want to play against a computer? Y/n");
        while (true) {
            boolean isComputer;
            if (scanner.hasNextLine()) {
                if (scanner.nextLine().equalsIgnoreCase("y")) {
                    isComputer = true;
                } else if (scanner.nextLine().equalsIgnoreCase("n")) {
                    isComputer = false;
                } else {
                    System.out.println("Enter `Y` for yes and `n` for no.");
                    System.out.println("Is player two a computer? Y/n");
                    continue;
                }
                this.playerTwo = new Player(name, isComputer, "O");
                break;
            } else {
                System.out.println("Enter a valid option!");
            }
        }
    }
}