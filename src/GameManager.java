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

    /**
     * Indicates if it's player one's turn.
     */
    private boolean playerOneTurn = true;

    /**
     * Indicates if program should continue.
     */
    private boolean continueProgram = true;

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

        // The game.
        while (continueProgram) {
            if (playerOneTurn) {
                this.playerMakesMove(this.playerOne);
            } else {
                if (this.playerTwo.isComputer()) {
                    this.computerMakesMove(this.playerTwo);
                } else {
                    this.playerMakesMove(this.playerTwo);
                }
            }
        }

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
    private void playerMakesMove(Player player) {
        int squareNumber;
        System.out.println(player.getSymbol() + ". " + player.getName() + " with " + " turn. Select square between 1-9: ");
        while (true) {
            // Check if user entered an integer within valid interval.
            if (scanner.hasNextInt()) {
                squareNumber = scanner.nextInt();
                if (squareNumber < 1 || squareNumber > 9) {
                    System.out.println("Enter a valid number between 1-9!");
                    continue;
                } else {
                    // Update board, then check if player has won, or if it's a draw.
                    if (this.ticTacToe.updateSquare(squareNumber, player)) {
                        playerOneTurn = !playerOneTurn;
                        System.out.println("Square updated!");
                        ticTacToe.printBoard();
                        if (this.ticTacToe.isWinner(player)) {
                            playerOneTurn = true;
                            System.out.println(player.getName() + " wins!");
                            player.incrementVictories();
                            System.out.println(player.getName() + " has " + player.getVictories() + " win(s).");
                            ticTacToe.resetBoard();
                            break;
                        } else {
                            if (this.ticTacToe.isDraw()) {
                                playerOneTurn = true;
                                ticTacToe.resetBoard();
                                System.out.println("It's a draw.");
                                break;
                            } else {
                                System.out.println("Square number " + squareNumber + " already occupied.");
                                System.out.println("Enter another square number between 1-9: ");
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

    /**
     * Computer makes a move. Evaluates board after each move.
     * @param player - Computer player.
     */
    private void computerMakesMove(Player player) {
        int squareNumber;

        System.out.println(player.getSymbol() + ". " + player.getName() + " makes a move.");
        while (true) {
            squareNumber = (int) (Math.random() * 9) + 1;
            if (this.ticTacToe.updateSquare(squareNumber, player)) {
                playerOneTurn = !playerOneTurn;
                System.out.println("Square updated!");
                ticTacToe.printBoard();
                if (this.ticTacToe.isWinner(player)) {
                    playerOneTurn = true;
                    System.out.println(player.getName() + " wins!");
                    player.incrementVictories();
                    System.out.println(player.getName() + " has " + player.getVictories() + " win(s).");
                    ticTacToe.resetBoard();
                    break;
                } else if (this.ticTacToe.isDraw()) {
                    playerOneTurn = true;
                    ticTacToe.resetBoard();
                    System.out.println("It's a draw.");
                    break;
                } else { break; }
            } else {
                continue;
            }
        }
    }

    /**
     * Quits the program.
     * @param quit - User input.
     */
    private void quitProgram(String quit) {
        if (quit.equalsIgnoreCase(":quit")) {
            this.continueProgram = false;
            System.out.println("Exiting program.");
        }
    }
}