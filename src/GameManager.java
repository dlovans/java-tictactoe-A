import java.util.Scanner;

/**
 * Manages program.
 */
public class GameManager {
    /**
     * TicTacToe object.
     */
    private TicTacToe ticTacToe;

    /**
     * Player one.
     */
    private Player playerOne;

    /**
     * Player two.
     */
    private Player playerTwo;

    private boolean playerOneTurn = true;

    public GameManager() {
        this.ticTacToe = new TicTacToe();
    }

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

    /**
     * Creates players. Asks user for names and if
     * opponent is a computer.
     */
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

    /**
     * Asks user to make a move. Evaluates board after each turn.
     * @param player - Player making a move.
     */
    private boolean playerMakesMove(Player player) {
        int squareNumber;
        System.out.println(player.getSymbol() + ". " + player.getName() + " with " + " turn. Select square between 1-9: ");
        while (true) {
            if (scanner.hasNextInt()) {
                squareNumber = scanner.nextInt();
                if (squareNumber < 1 || squareNumber > 9) {
                    System.out.println("Enter a valid number between 1-9!");
                    continue;
                } else {
                    if (this.ticTacToe.updateSquare(squareNumber, player)) {
                        System.out.println("Square updated!");
                        ticTacToe.printBoard();
                        if (this.ticTacToe.isWinner(player)) {
                            System.out.println(player.getName() + " wins!");
                            player.incrementVictories();
                            System.out.println(player.getName() + " has " + player.getVictories() + " win(s).");
                            ticTacToe.resetBoard();
                            break;
                        } else {
                            if (this.ticTacToe.isDraw()) {
                                System.out.println("It's a draw.");
                                break;
                            } else {
                                System.out.println("Square number " + squareNumber + " already occupied.");
                                continue;
                            }
                        }
                    }
                    break;
                }
            } else {
                System.out.println("Enter a digit between 1-9!");
            }
        }
    }
}