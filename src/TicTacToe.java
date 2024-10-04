import java.util.Arrays;

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
    final private String[] board;

    /**
     * Creates an instance of TicTacToe.
     * @param playerOne - Player one.
     * @param playerTwo - Player two.
     */
    public TicTacToe(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;

        // TicTacToe board.
        this.board = new String[9];
        Arrays.fill(this.board, " ");
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
        for (String s : this.board) {
            System.out.print("|");
            System.out.print(s);
            System.out.println(" |");
        }
    }

    /**
     * Updates a square to the value of X or O if the square is unoccupied.
     * @param squareNumber - The square number that the player entered.
     * @param player - The player playing its turn.
     * @return - Whether the square was successfully updated or not.
     */
    public boolean updateSquare(int squareNumber, Player player) {
        boolean result = false;
        if (squareNumber >= 1 && squareNumber <=3) {
            if (this.board[squareNumber].equals(" ")) {
                this.board[squareNumber] = player.getSymbol();
                result = true;
            }
        } else if (squareNumber >= 4 && squareNumber <=6) {
            if (this.board[squareNumber].equals(" ")) {
                this.board[squareNumber] = player.getSymbol();
                result = true;
            }
        } else if (squareNumber >= 7 && squareNumber <=9) {
            if (this.board[squareNumber].equals(" ")) {
                this.board[squareNumber] = player.getSymbol();
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
    public boolean isWinner(Player player) {
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
    public boolean isDraw() {
        for (int i = 0; i < this.board.length; i++) {
            if (this.board[i].equals(" ")) {
                return true;
            }
        }
        return false;
    }
}
