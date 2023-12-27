package GameLocal;

import Enums.EnumPortalState;
import Enums.EnumTeam;
import GamePlayer.Player;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class Portal extends Local {

    private Ownership ownership;
    private EnumPortalState state;
    private int energy;
    private String name;
    private int maxEnergy;
    private EnumTeam team;

    /**
     * Constructs a new Portal object with the given parameters.
     *
     * @param id the ID of the portal
     * @param ownership the ownership status of the portal
     * @param energy the current energy level of the portal
     * @param name the name of the portal
     * @param maxEnergy the maximum energy level of the portal
     * @param coordinates the coordinates of the portal
     */
    public Portal(int id, Ownership ownership, int energy, String name, int maxEnergy, Coordinates coordinates) {
        super(id, coordinates);
        this.ownership = ownership;
        this.state = state.Conquered;
        this.energy = energy;
        this.name = name;
        this.maxEnergy = maxEnergy;
    }

    /**
     * Constructs a new Portal object with the given parameters, setting the
     * portal state to neutral.
     *
     * @param state the state of the portal
     * @param energy the current energy level of the portal
     * @param name the name of the portal
     * @param maxEnergy the maximum energy level of the portal
     * @param id the ID of the portal
     * @param coordinates the coordinates of the portal
     */
    public Portal(EnumPortalState state, int energy, String name, int maxEnergy, int id, Coordinates coordinates) {
        super(id, coordinates);
        this.state = state.Neutral;
        this.energy = energy;
        this.name = name;
        this.maxEnergy = maxEnergy;
    }

    /**
     *
     * Constructs a new Portal object with the specified energy, name, maximum
     * energy, id, and coordinates.
     *
     * @param energy the energy level of the portal
     * @param name the name of the portal
     * @param maxEnergy the maximum energy level of the portal
     * @param id the ID of the portal
     * @param coordinates the coordinates of the portal
     *
     */
    public Portal(int energy, String name, int maxEnergy, int id, Coordinates coordinates) {
        super(id, coordinates);
        this.energy = energy;
        this.name = name;
        this.state = state.Neutral;
        this.maxEnergy = maxEnergy;
    }

    /**
     *
     * Returns the coordinates of the portal.
     *
     * @return the coordinates of the portal
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     *
     * Sets the coordinates of the portal.
     *
     * @param coordinates the coordinates of the portal
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     *
     * Returns the team that owns the portal.
     *
     * @return the team that owns the portal
     */
    public EnumTeam getTeam() {
        return team;
    }

    /**
     *
     * Sets the team that owns the portal.
     *
     * @param team the team that owns the portal
     */
    public void setTeam(EnumTeam team) {
        this.team = team;
    }

    /**
     *
     * Returns the maximum amount of energy the portal can have.
     *
     * @return the maximum amount of energy the portal can have
     */
    public int getMaxEnergy() {
        return maxEnergy;
    }

    /**
     *
     * Sets the maximum amount of energy the portal can have.
     *
     * @param maxEnergy the maximum amount of energy the portal can have
     */
    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    /**
     *
     * Returns the player who owns the portal.
     *
     * @return the player who owns the portal
     */
    public Ownership getOwnership() {
        return ownership;
    }

    /**
     *
     * Sets the player who owns the portal.
     *
     * @param player the player who owns the portal
     */
    public void setOwnership(Player player) {
        this.ownership = new Ownership(player);
    }

    /**
     *
     * Returns the state of the portal.
     *
     * @return the state of the portal
     */
    public EnumPortalState getState() {
        return state;
    }

    /**
     *
     * Sets the state of the portal.
     *
     * @param state the state of the portal
     */
    public void setState(EnumPortalState state) {
        this.state = state;
    }

    /**
     *
     * Returns the amount of energy the portal has.
     *
     * @return the amount of energy the portal has
     */
    public int getEnergy() {
        return energy;
    }

    /**
     *
     * Sets the amount of energy the portal has.
     *
     * @param energy the amount of energy the portal has
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    /**
     *
     * Returns the name of the portal.
     *
     * @return the name of the portal
     */
    public String getName() {
        return name;
    }

    /**
     *
     * This method sets the name of the Portal object.
     *
     * @return Nothing. This method does not return anything.
     */

    public void setName(String name) {
        this.name = name;

    }

}
