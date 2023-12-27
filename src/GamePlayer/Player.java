package GamePlayer;

import EstruturasList.ArrayUnorderedList;
import Enums.EnumTeam;
import GameLocal.Local;
import java.util.Objects;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 * @param <T>
 *
 *
 * Represents a player in the game.
 */
public class Player<T> extends ArrayUnorderedList<T> {

    private int id;
    private static int countPlayers = 1;
    private String name;
    private int level;
    private int currentEnergy;
    public EnumTeam team;
    private long experiencePoints;
    private Local posicaoAtual;

    /**
     *
     * Creates a new player with the given name, level, experience points,
     * current energy, and team.
     *
     * @param name The name of the player.
     * @param level The level of the player.
     * @param experiencePoints The experience points of the player.
     * @param currentEnergy The current energy of the player.
     * @param team The team the player belongs to.
     */
    public Player(String name, int level, int experiencePoints, int currentEnergy, EnumTeam team) {
        this.id = countPlayers++;
        this.name = name;
        this.level = level;
        this.currentEnergy = currentEnergy;
        this.team = team;
        this.experiencePoints = experiencePoints;
    }

    /**
     *
     * Creates a new player with the given name and team. Sets default values
     * for level and current energy.
     *
     * @param name The name of the player.
     * @param team The team the player belongs to.
     */
    public Player(String name, EnumTeam team) {
        this.id = countPlayers++;
        this.name = name;
        this.level = 1;
        this.currentEnergy = 50;
        this.team = team;

    }

    /**
     *
     * Creates a new player with the given name.
     *
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     *
     * Creates a new player with default values for all fields.
     */
    public Player() {
    }

    /**
     *
     * Gets the ID of the player.
     *
     * @return The ID of the player.
     */
    public int getId() {
        return id;
    }

    /**
     *
     * Sets the ID of the player.
     *
     * @param id The ID of the player.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * Gets the name of the player.
     *
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * Sets the name of the player.
     *
     * @param name The name of the player.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * Gets the level of the player.
     *
     * @return The level of the player.
     */
    public int getLevel() {
        return level;
    }

    /**
     *
     * Sets the level of the player based on their experience points.
     *
     * @param experience The experience points of the player.
     */
    public void setLevel(long experience) {
        float x = (float) 0.07;
        this.level = (int) (x * Math.sqrt(experience));
    }

    /**
     *
     * Gets the team of the player.
     *
     * @return The team of the player.
     */
    public EnumTeam getTeam() {
        return team;
    }

    /**
     *
     * Sets the team of the player.
     *
     * @param team The team of the player.
     */
    public void setTeam(EnumTeam team) {
        this.team = team;
    }

    /**
     *
     * Gets the count of all players.
     *
     * @return The count of all players.
     */
    public static int getCountPlayers() {
        return countPlayers;
    }

    /**
     *
     * Sets the count of all players.
     *
     * @param countPlayers The count of all players.
     */
    public static void setCountPlayers(int countPlayers) {
        Player.countPlayers = countPlayers;
    }

    /**
     *
     * Gets the current energy of the player.
     *
     * @return The current energy of the player.
     */
    public int getCurrentEnergy() {
        return currentEnergy;
    }

    /**
     *
     * Sets the current energy of the player.
     *
     * @param currentEnergy The current energy of the player.
     */
    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    /**
     *
     * Gets the experience points of the player.
     *
     * @return The experience points of the player.
     */
    public long getExperiencePoints() {
        return experiencePoints;
    }

    /**
     *
     * Sets the experience points of the player.
     *
     * @param experiencePoints the new experience points of the player
     */
    public void setExperiencePoints(long experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    /**
     *
     * Returns the current position of the player.
     *
     * @return the current position of the player
     */
    public Local getPosicaoAtual() {
        return posicaoAtual;
    }

    /**
     *
     * Sets the current position of the player.
     *
     * @param posicaoAtual the new position of the player
     */
    public void setPosicaoAtual(Local posicaoAtual) {
        this.posicaoAtual = posicaoAtual;
    }

    /**
     *
     * Returns a hash code value for the object. The hash code is generated
     * based on the player's id.
     *
     * @return the hash code value for the object.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        return hash;
    }

    /**
     *
     * Compares this player to the specified object for equality. Returns true
     * if and only if the specified object is also a Player object, both objects
     * have the same id and name fields.
     *
     * @param obj the object to compare to
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player<?> other = (Player<?>) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

}
