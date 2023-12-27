package GameMapa;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class Configuration implements Comparable {

    private int level;
    private int xp;
    private int energy;

    /**
     *
     * Creates a new Configuration instance with the specified level, XP, and
     * energy values.
     *
     * @param level the player's level
     * @param xp the player's experience points
     * @param energy the player's energy
     */
    public Configuration(int level, int xp, int energy) {
        this.level = level;
        this.xp = xp;
        this.energy = energy;
    }

    /**
     *
     * /**
     *
     * Returns the player's level.
     *
     * @return the player's level
     */
    public int getLevel() {
        return level;
    }

    /**
     *
     * Sets the player's level to the specified value.
     *
     * @param level the new level value
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     *
     * Returns the player's experience points.
     *
     * @return the player's experience points
     */
    public int getXp() {
        return xp;
    }

    /**
     *
     * Sets the player's experience points to the specified value.
     *
     * @param xp the new experience points value
     */
    public void setXp(int xp) {
        this.xp = xp;
    }

    /**
     *
     * Returns the player's energy.
     *
     * @return the player's energy
     */
    public int getEnergy() {
        return energy;
    }

    /**
     *
     * Sets the player's energy to the specified value.
     *
     * @param energy the new energy value
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    /**
     *
     * Compares this Configuration object with the specified object for order.
     *
     * @param o the object to be compared
     * @return a negative integer, zero, or a positive integer as this object is
     * less than, equal to, or greater than the specified object
     */
    @Override
    public int compareTo(Object o) {
        if (((Configuration) o).getLevel() == this.getLevel()) {
            return 0;
        } else if (((Configuration) o).getLevel() > this.getLevel()) {
            return 1;
        } else {
            return -1;
        }
    }

}
