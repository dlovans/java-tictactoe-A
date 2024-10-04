/**
 * Manages program.
 */
public class GameManager {
    /**
     * Player one.
     */
    final private Player playerOne;

    /**
     * Player two.
     */
    final private Player playerTwo;

    /**
     * Starts the program, provides a console interface.
     */
    public void run() {
        System.out.println("TicTacToe Game");
        System.out.println("--------------------------");
        this.createPlayers();
    }
}

// TODO: Move Player instances to this class.