package Local;

import Enum.EnumPortalState;
import static Enum.EnumPortalState.Neutral;
import Enum.EnumTeam;
import Player.Player;

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

    public Portal(int id, Ownership ownership, int energy, String name, int maxEnergy, Coordinates coordinates) {
        super(id, coordinates);
        this.ownership = ownership;
        this.state = state.Conquered;
        this.energy = energy;
        this.name = name;
        this.maxEnergy = maxEnergy;
    }

    public Portal(EnumPortalState state, int energy, String name, int maxEnergy, int id, Coordinates coordinates) {
        super(id, coordinates);
        this.state = state.Neutral;
        this.energy = energy;
        this.name = name;
        this.maxEnergy = maxEnergy;
    }

    public Portal(int energy, String name, int maxEnergy, int id, Coordinates coordinates) {
        super(id, coordinates);
        this.energy = energy;
        this.name = name;
        this.maxEnergy = maxEnergy;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public EnumTeam getTeam() {
        return team;
    }

    public void setTeam(EnumTeam team) {
        this.team = team;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public Ownership getOwnership() {
        return ownership;
    }

    public void setOwnership(Player player) {
        this.ownership = ownership;
    }

    public EnumPortalState getState() {
        return state;
    }

    public void setState(EnumPortalState state) {
        this.state = state;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

}
