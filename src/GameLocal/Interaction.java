package GameLocal;

import EstruturasList.ArrayUnorderedList;
import EstruturasList.DoubleUnorderedLinkedList;
import EstruturasNode.DoubleNode;
import Exceptions.EmptyCollectionException;
import GamePlayer.Player;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class Interaction {

    DoubleUnorderedLinkedList<Interaction> interaction = new DoubleUnorderedLinkedList<>();

    private Player player;

    private LocalTime time;

    private LocalDate date;

    /**
     *
     * Constructs an Interaction object with the given player, time, and date.
     *
     * @param player the player involved in the interaction
     * @param time the time the interaction occurred
     * @param date the date the interaction occurred
     */
    public Interaction(Player player, LocalTime time, LocalDate date) {
        this.player = player;
        this.time = time;
        this.date = date;
    }

    /**
     *
     * Returns the player involved in the interaction.
     *
     * @return the player involved in the interaction
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     *
     * Sets the player involved in the interaction.
     *
     * @param player the player involved in the interaction
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     *
     * Returns the time the interaction occurred.
     *
     * @return the time the interaction occurred
     */
    public LocalTime getTime() {
        return this.time;
    }

    /**
     *
     * Sets the time the interaction occurred.
     *
     * @param time the time the interaction occurred
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    /**
     *
     * Returns the date the interaction occurred.
     *
     * @return the date the interaction occurred
     */
    public LocalDate getDate() {
        return this.date;
    }

    /**
     *
     * Sets the date the interaction occurred.
     *
     * @param date the date the interaction occurred
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     *
     * Returns the list of interactions.
     *
     * @return the list of interactions
     */
    public DoubleUnorderedLinkedList<Interaction> getInteractions() {
        return interaction;
    }

    /**
     *
     * Sets the list of interactions.
     *
     * @param interactions the list of interactions
     */
    public void setInteractions(DoubleUnorderedLinkedList<Interaction> interactions) {
        this.interaction = interactions;
    }

    /**
     *
     * Adds an interaction to the list of interactions.
     *
     * @param interaction the interaction to add
     */
    public void addInteraction(Interaction interaction) {

        if (interaction == null) {
            System.out.println("Interações nao encontrada");
        }

        this.interaction.addToFront(interaction);
    }

    /**
     *
     * Removes an interaction from the list of interactions.
     *
     * @param player the name of the player involved in the interaction to
     * remove
     *
     * @return true if the interaction was successfully removed, false otherwise
     *
     * @throws EmptyCollectionException if the list of interactions is empty
     *
     * @throws NoSuchElementException if the interaction to remove is not found
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
     * Finds the first interaction in the list with the given player name.
     *
     * @param player the name of the player to find the interaction for
     * @return the first interaction with the given player name, or null if no
     * such interaction exists
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
     * Replaces the first occurrence of an interaction in the list with the same
     * player name as the given interaction.
     *
     * @param interaction the interaction to replace
     * @throws NullPointerException if the given interaction is null
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
