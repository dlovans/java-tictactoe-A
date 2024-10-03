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
     * Creates an instance of TicTacToe.
     * @param playerOne - Player one.
     * @param playerTwo - Player two.
     */
    public TicTacToe(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    /**
     * Assigns TicTacToe symbols for players.
     */
    public void assignSymbol() {
        this.playerOne.setSymbol("X");
        this.playerTwo.setSymbol("O");
    }
}
