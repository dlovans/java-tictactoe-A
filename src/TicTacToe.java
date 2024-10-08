import java.util.Arrays;

/**
 * Represents Tic-Tac-Toe game.
 */
public class TicTacToe {
    /**
     *
     */
    final private String[] board;

    /**
     * Creates an instance of TicTacToe.
     */
    public TicTacToe() {
        // TicTacToe board.
        this.board = new String[9];
        Arrays.fill(this.board, " ");
    }

    /**
     * Prints the TicTacToe board to the standard output.
     */
    protected void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < this.board.length; i++) {
            System.out.print("|");
            System.out.print(" " + this.board[i] + " ");
            if (i == 2 || i == 5 || i == 8) {
                System.out.print("|");
                System.out.println();
            }
        }
        System.out.println("-------------");
        System.out.println();
    }

    /**
     * Updates a square to the value of X or O if the square is unoccupied.
     * @param squareNumber - The square number that the player entered.
     * @param player - The player playing its turn.
     * @return - Whether the square was successfully updated or not.
     */
    protected boolean updateSquare(int squareNumber, Player player) {
        boolean result = false;
        int squareNumberToIndex = squareNumber - 1;
        if (squareNumber >= 1 && squareNumber <=3) {
            if (this.board[squareNumberToIndex].equals(" ")) {
                this.board[squareNumberToIndex] = player.getSymbol();
                result = true;
            }
        } else if (squareNumber >= 4 && squareNumber <=6) {
            if (this.board[squareNumberToIndex].equals(" ")) {
                this.board[squareNumberToIndex] = player.getSymbol();
                result = true;
            }
        } else if (squareNumber >= 7 && squareNumber <=9) {
            if (this.board[squareNumberToIndex].equals(" ")) {
                this.board[squareNumberToIndex] = player.getSymbol();
                result = true;
            }
        }
        return result;
    }

    /**
     * Evaluates board. Returns whether player is a winner.
     * @param player - TicTacToe player.
     * @return - Whether player has won or not.
     */
    protected boolean isWinner(Player player) {
        int[][] threeInRow = new int[][] {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };
        String symbol = player.getSymbol();

        for (int i = 0; i < threeInRow.length; i++) {
            if (this.board[threeInRow[i][0]].equals(symbol) && this.board[threeInRow[i][1]].equals(symbol) && this.board[threeInRow[i][2]].equals(symbol)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if it's a draw.
     * @return - Whether it is a draw or not.
     */
    protected boolean isDraw() {
        for (String s : this.board) {
            if (s.equals(" ")) {
                return false;
            }
        }
        return true;
    }

    /**
     * Resets the board.
     */
    protected void resetBoard() {
        Arrays.fill(this.board, " ");
        System.out.println("Restarting game!");
        System.out.println();
    }
}
