import java.util.Scanner;

/**
 * Manages program.
 */
public class GameManager {
    /**
     * TicTacToe object.
     */
    final private TicTacToe ticTacToe;

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
        System.out.println("Type `:quit` at any time to quit the program!");
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
                    this.quitProgram(name);
                    this.playerOne = new Player(name, false, "X");
                    break;
                } else {
                    System.out.println("Enter a valid name!");
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
                    this.quitProgram(name);
                    break;
                } else {
                    System.out.println("Enter a valid name!");
                }
            }
        }

        // Ask user if player two is a computer.
        String isComputerResponse;
        System.out.println("Do you want to play against a computer? Y/n");
        while (true) {
            boolean isComputer;
            if (scanner.hasNextLine()) {
                isComputerResponse = scanner.nextLine();

                this.quitProgram(isComputerResponse);

                if (isComputerResponse.equalsIgnoreCase("y")) {
                    isComputer = true;
                } else if (isComputerResponse.equalsIgnoreCase("n")) {
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
        String userInput;
        System.out.println(player.getName() + "'s turn, with symbol " + player.getSymbol() + ". Select square between 1-9: ");

        this.ticTacToe.printBoard();

        while (true) {
            // Check if user wants to quit program.
            if (scanner.hasNextLine()) {
                userInput = scanner.nextLine();
                if (!userInput.isEmpty()) {
                    this.quitProgram(userInput);
                    try {
                        squareNumber = Integer.parseInt(userInput);
                    } catch (NumberFormatException e) {
                        System.out.println("Enter a valid number!");
                        continue;
                    }
                } else {
                    break;
                }

                // Check if user entered an integer within valid interval.
                if (squareNumber < 1 || squareNumber > 9) {
                    System.out.println("Enter a valid number between 1-9!");
                    continue;
                } else {
                    // Update board, then check if player has won, or if it's a draw.
                    if (this.ticTacToe.updateSquare(squareNumber, player)) {
                        playerOneTurn = !playerOneTurn;
                        System.out.println("Square updated!");
                        ticTacToe.printBoard();

                        // Checks if player is a winner after making a move.
                        if (this.ticTacToe.isWinner(player)) {
                            playerOneTurn = true;
                            System.out.println(player.getName() + " wins!");
                            player.incrementVictories();
                            System.out.println(player.getName() + " has " + player.getVictories() + " win(s).");
                            ticTacToe.resetBoard();
                            break;
                        } else {

                            // Checks if it's a draw after each move.
                            if (this.ticTacToe.isDraw()) {
                                playerOneTurn = true;
                                System.out.println("It's a draw.");
                                ticTacToe.resetBoard();
                                break;
                            }
                        }
                    } else {
                        // If user enters an integer already occupied in the board.
                        System.out.println("Square number " + squareNumber + " already occupied.");
                        System.out.println("Enter another square number between 1-9: ");
                        continue;
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
            // Makes sure random integer isn't occupied.
            squareNumber = (int) (Math.random() * 9) + 1;
            if (this.ticTacToe.updateSquare(squareNumber, player)) {
                playerOneTurn = !playerOneTurn;
                System.out.println("Square updated!");
                ticTacToe.printBoard();

                // Checks if computer is a winner.
                if (this.ticTacToe.isWinner(player)) {
                    playerOneTurn = true;
                    System.out.println(player.getName() + " wins!");
                    player.incrementVictories();
                    System.out.println(player.getName() + " has " + player.getVictories() + " win(s).");
                    ticTacToe.resetBoard();
                    break;

                    // Checks if it's a draw after computer makes a move.
                } else if (this.ticTacToe.isDraw()) {
                    playerOneTurn = true;
                    System.out.println("It's a draw.");
                    ticTacToe.resetBoard();
                    break;
                } else { break; }
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
            System.exit(0);
        }
    }
}