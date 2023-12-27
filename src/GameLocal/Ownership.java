package GameLocal;

import GamePlayer.Player;

/**
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class Ownership {

    private Player player;

    /**
     * Constructs a new Ownership object with the given player as the owner.
     *
     * @param player the player who owns the game entity
     */
    public Ownership(Player player) {
        this.player = player;
    }

    /**
     * Returns the player who owns the game entity.
     *
     * @return the player who owns the game entity
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Sets the player who owns the game entity.
     *
     * @param player the new owner of the game entity
     */
    public void setPlayer(Player player) {
        this.player = player;
    }
}
