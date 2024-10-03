/**
 * Represents a player.
 */
public class Player {
    /**
     * Player name.
     */
    final private String name;

    /**
     * Number of victories.
     */
    private int victories;

    /**
     * Whether Player instance is a computer.
     */
    final private boolean isComputer;

    private String symbol;

    /**
     * Creates an instance of Player.
     * @param name - Name of player.
     * @param isComputer - Whether player is a computer.
     */
    public Player(String name, boolean isComputer) {
        this.isComputer = isComputer;
        this.victories = 0;
        this.symbol = "";

        if (this.isComputer) {
            this.name = "Sauron's Finger";
        } else {
            this.name = name;
        }
    }

    /**
     * Increments number of victories by one.
     */
    public void incrementVictories() {
        this.victories++;
    }

    /**
     * Returns number of victories.
     * @return - Number of victories.
     */
    public int getVictories() {
        return this.victories;
    }

    /**
     * Returns player name.
     * @return - Player name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns player TicTacToe symbol.
     * @return - Symbol.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Sets player TicTacToe symbol.
     * @param symbol - Symbol.
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
