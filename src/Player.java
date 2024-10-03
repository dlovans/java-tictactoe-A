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
    int victories;

    /**
     * Creates an instance of Player.
     * @param name - Name of player.
     */
    public Player(String name) {
        this.name = name;
        this.victories = 0;
    }
}
