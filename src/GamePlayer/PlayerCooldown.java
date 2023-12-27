package GamePlayer;

import java.time.LocalDateTime;

/**
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
/**
 *
 * Represents a player's cooldown.
 *
 * Keeps track of the player and the last time they performed an action.
 */
public class PlayerCooldown {

    /**
     *
     * The player associated with this cooldown.
     */
    private Player player;
    /**
     *
     * The time of the last action performed by the player.
     */
    private LocalDateTime LastEntry;

    /**
     *
     * Constructs a new PlayerCooldown object with the given player and last
     * entry time.
     *
     * @param player the player associated with this cooldown
     * @param LastEntry the time of the last action performed by the player
     */
    public PlayerCooldown(Player player, LocalDateTime LastEntry) {
        this.player = player;
        this.LastEntry = LastEntry;
    }

    /**
     *
     * Returns the player associated with this cooldown.
     *
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     *
     * Sets the player associated with this cooldown.
     *
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     *
     * Returns the time of the last action performed by the player.
     *
     * @return the last entry time
     */
    public LocalDateTime getLastEntry() {
        return LastEntry;
    }

    /**
     *
     * Sets the time of the last action performed by the player.
     *
     * @param LastEntry the last entry time to set
     */
    public void setLastEntry(LocalDateTime LastEntry) {
        this.LastEntry = LastEntry;
    }
}
