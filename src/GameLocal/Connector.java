package GameLocal;

import Exceptions.EmptyCollectionException;
import EstruturasList.ArrayUnorderedList;
import EstruturasList.DoubleUnorderedLinkedList;
import EstruturasNode.DoubleNode;
import GamePlayer.Player;
import GamePlayer.PlayerCooldown;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class Connector extends Local {

    private int energy;
    private int cooldown;
    private ArrayUnorderedList<PlayerCooldown> PlayerLastEntryList = new ArrayUnorderedList<>();
    private DoubleUnorderedLinkedList<Interaction> interaction = new DoubleUnorderedLinkedList<>();
    private boolean mina;

    /**
     *
     * Creates a new Connector object with the given id, cooldown time, and
     * coordinates.
     *
     * @param id the unique identifier of the connector
     * @param cooldown the cooldown time of the connector
     * @param coordinates the coordinates of the connector on the game map
     */
    public Connector(int id, int cooldown, Coordinates coordinates) {
        super(id, coordinates);
        this.cooldown = cooldown;
        this.mina = false;
    }

    /**
     *
     * Creates a new instance of Connector with energy, cooldown, id, and
     * coordinates.
     *
     * @param energy the energy of the Connector
     * @param cooldown the cooldown of the Connector
     * @param id the id of the Connector
     * @param coordinates the coordinates of the Connector
     */
    public Connector(int energy, int cooldown, int id, Coordinates coordinates) {
        super(id, coordinates);
        this.energy = energy;
        this.cooldown = cooldown;
        this.mina = false;
    }

    /**
     *
     * Returns the coordinates of this Connector.
     *
     * @return the coordinates of this Connector
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     *
     * Sets the coordinates of this Connector.
     *
     * @param coordinates the coordinates to be set
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     *
     * Returns the energy of this Connector.
     *
     * @return the energy of this Connector
     */
    public int getEnergy() {
        return energy;
    }

    /**
     *
     * Sets the energy of this Connector.
     *
     * @param energy the energy to be set
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    /**
     *
     * Returns the cooldown of the Connector.
     *
     * @return the cooldown of the Connector
     */
    public int getCooldown() {
        return cooldown;
    }

    /**
     *
     * Sets the cooldown of the Connector.
     *
     * @param cooldown the new cooldown value to be set
     */
    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    /**
     *
     * Returns the list of player cooldowns for the Connector.
     *
     * @return the list of player cooldowns for the Connector
     */
    public ArrayUnorderedList<PlayerCooldown> getPlayerLastEntryList() {
        return PlayerLastEntryList;
    }

    /**
     *
     * Sets the list of player cooldowns for the Connector.
     *
     * @param playerLastEntryList the new list of player cooldowns to be set
     */
    public void setPlayerLastEntryList(ArrayUnorderedList<PlayerCooldown> PlayerLastEntryList) {
        this.PlayerLastEntryList = PlayerLastEntryList;
    }

    /**
     *
     * Returns whether the Connector has a mine.
     *
     * @return true if the Connector has a mine, false otherwise
     */
    public boolean isMina() {
        return mina;
    }

    /**
     *
     * Sets whether the Connector has a mine.
     *
     * @param mina true if the Connector has a mine, false otherwise
     */
    public void setMina(boolean mina) {
        this.mina = mina;
    }

    /**
     *
     * Returns the DoubleUnorderedLinkedList of interactions associated with
     * this Connector.
     *
     * @return the DoubleUnorderedLinkedList of interactions
     */
    public DoubleUnorderedLinkedList<Interaction> getInteractions() {
        return interaction;
    }

    /**
     *
     * Sets the DoubleUnorderedLinkedList of interactions associated with this
     * Connector.
     *
     * @param interactions the DoubleUnorderedLinkedList of interactions to set
     */
    public void setInteractions(DoubleUnorderedLinkedList<Interaction> interactions) {
        this.interaction = interactions;
    }

    /**
     *
     * Adds an Interaction to the DoubleUnorderedLinkedList of interactions
     * associated with this Connector.
     *
     * @param interaction the Interaction to add
     */
    public void addInteraction(Interaction interaction) {

        if (interaction == null) {
            System.out.println("Interações nao encontrada");
        }

        this.interaction.addToFront(interaction);
    }

    /**
     *
     * Removes the interaction associated with the given player name from the
     * list of interactions.
     *
     * @param player the name of the player whose interaction is to be removed
     *
     * @return true if the interaction was successfully removed, false otherwise
     *
     * @throws EmptyCollectionException if the list of interactions is empty
     *
     * @throws NoSuchElementException if the interaction associated with the
     * given player name is not found in the list
     */
    public boolean removeInteraction(String player) throws EmptyCollectionException, NoSuchElementException {

        if (player == null) {
            System.out.println("O player é nulo !");
        }

        if (this.interaction == null) {

            System.out.println("Interações nao encontrada");
        }

        Interaction interaction = this.findInteraction(player);

        if (interaction == null) {

            System.out.println("Jogador não encontrado");
            return false;
        } else {

            this.interaction.remove(interaction);
            return true;
        }
    }

    /**
     *
     * Finds the interaction associated with the given player name in the list
     * of interactions.
     *
     * @param player the name of the player whose interaction is to be found
     *
     * @return the interaction associated with the given player name, or null if
     * not found
     */
    public Interaction findInteraction(String player) {

        Interaction find = null;
        Iterator<Interaction> i = this.interaction.iterator();
        while (i.hasNext()) {
            Interaction p1 = i.next();
            if (p1 != null && p1.getPlayer().getName().equals(player)) {
                find = p1;
            }
        }

        if (find == null) {

            return null;
        } else {

            return find;
        }
    }

    /**
     *
     * Replaces the interaction associated with the given player name with the
     * given interaction in the list of interactions.
     *
     * @param interaction the interaction to replace the existing interaction
     * associated with the given player name
     */
    public void editInteraction(Interaction interaction) {

        for (DoubleNode<Interaction> node = this.interaction.getHead(); node != null; node = node.getNext()) {
            Player player = node.getElement().getPlayer();

            if (player.getName().equals(interaction.getPlayer().getName())) {
                node.setElement(interaction);
            }
        }
    }

}

