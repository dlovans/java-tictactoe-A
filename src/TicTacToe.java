/**
 * Represents Tic-Tac-Toe game.
 */
public class TicTacToe {
    /**
     * Player one.
     */
    final private Player playerOne;

    /**
     * Player two.
     */
    final private Player playerTwo;

    /**
     *
     */
    final private String[][] board;

    /**
     * Creates an instance of TicTacToe.
     * @param playerOne - Player one.
     * @param playerTwo - Player two.
     */
    public TicTacToe(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;

        // Initialize a matrices.
        this.board = new String[][] {
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"}};
    }

    /**
     * Assigns TicTacToe symbols for players.
     */
    public void assignSymbol() {
        this.playerOne.setSymbol("X");
        this.playerTwo.setSymbol("O");
    }

    /**
     * Prints the TicTacToe board to the standard output.
     */
    public void printBoard() {
        System.out.println("|---|---|");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " +this.board[i][j]);
            }
            System.out.println(" |");
        }
    }
}
