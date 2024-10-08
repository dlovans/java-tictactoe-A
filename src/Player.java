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

    /**
     * A player's TicTacToe symbol.
     */
    final private String symbol;

    /**
     * Creates an instance of Player.
     * @param name - Name of player.
     * @param isComputer - Whether player is a computer.
     */
    public Player(String name, boolean isComputer, String symbol) {
        this.isComputer = isComputer;
        this.victories = 0;
        this.symbol = symbol;
        this.name = name;
    }

    /**
     * Increments number of victories by one.
     */
    protected void incrementVictories() {
        this.victories++;
    }

    /**
     * Returns number of victories.
     * @return - Number of victories.
     */
    protected int getVictories() {
        return this.victories;
    }

    /**
     * Returns player name.
     * @return - Player name.
     */
    protected String getName() {
        return this.name;
    }

    /**
     * Returns player TicTacToe symbol.
     * @return - Symbol.
     */
    protected String getSymbol() {
        return symbol;
    }

    /**
     * Returns whether player instance is a computer.
     * @return - Whether player is a computer.
     */
    protected boolean isComputer() {
        return isComputer;
    }

}
