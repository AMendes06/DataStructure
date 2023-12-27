package GamePlayer;

import EstruturasList.ArrayUnorderedList;
import Enums.EnumTeam;
import Exceptions.EmptyCollectionException;
import EstruturasNode.LinearNode;
import GameLocal.Connector;
import EstruturasNode.DoubleNode;
import EstruturasList.OrderedList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class ManagementPlayer {

    /**
     *
     * An ArrayUnorderedList that stores the players.
     */
    private ArrayUnorderedList<Player> player = new ArrayUnorderedList<>();

    /**
     *
     *
     *
     *
     * /**
     *
     * Exports all players in the list to a JSON file named
     * "ExportPlayers.json".
     *
     * Each player is represented by a JSONObject with their attributes.
     *
     * The method uses the listPlayers() method to get the player list.
     *
     * @throws IOException if an I/O error occurs while writing to the file
     */
    public void exportPlayersToJson() {
        // Create a JSON array to hold the connectors
        JSONArray playersJson = new JSONArray();

        // Iterate over all connectors and add them to the JSON array
        ArrayUnorderedList<Player> playerList = listPlayers();
        for (Player player : playerList) {
            JSONObject playerJson = new JSONObject();
            playerJson.put("id: ", player.getId());
            playerJson.put("Name: ", player.getName());
            playerJson.put("Team: ", player.getTeam());
            playerJson.put("Current Energy: ", player.getCurrentEnergy());
            playerJson.put("Experience Points: ", player.getExperiencePoints());
            playerJson.put("Level", player.getLevel());
            playersJson.add(playerJson);
        }

        // Write the JSON array to a file
        try (FileWriter file = new FileWriter("ExportPlayers.json")) {
            file.write(playersJson.toJSONString());
            System.out.println("\nFicheiro exportado com sucesso!");
        } catch (IOException e) {
            System.out.println("\nErro ao guardar o ficheiro!");
        }

    }

    /**
     *
     * Searches for a player by name in the player list.
     *
     * @param name the name of the player to search for
     *
     * @return the Player object if found, null otherwise
     */
    public Player findPlayer(String name) {
        Player player;
        Iterator iter = this.player.iterator();
        while (iter.hasNext()) {
            player = (Player) iter.next();
            if (player.getName().equals(name)) {
                return player;

            }
        }
        System.out.println("Este jogador não existe!");
        return null;

    }

    /**
     *
     * Adds a new player to the list of players, checking if a player with the
     * same name already exists.
     *
     * @param player the player to be added
     * @throws IllegalArgumentException if a player with the same name already
     * exists
     */
    public void addPlayer(Player player) {

        Iterator iter = this.player.iterator();
        while (iter.hasNext()) {
            Player oldPlayer = (Player) iter.next();
            if (oldPlayer.getName().equals(player.getName())) {
                throw new IllegalArgumentException("Jogador com o mesmo nome já existe");
            }
        }

        this.player.addToRear(player);
    }

    /**
     *
     * Prints a list of all players in a given team.
     *
     * @param team the team for which to list the players
     */
    public void listPlayersByTeam(EnumTeam team) {
        System.out.println("Jogadores equipa: " + team);
        Iterator iter = player.iterator();
        while (iter.hasNext()) {
            Player currentPlayer = (Player) iter.next();
            if (currentPlayer.getTeam() == team) {
                System.out.println("Nome: " + currentPlayer.getName()
                        + ", ID: " + currentPlayer.getId()
                        + ", Energia atual: " + currentPlayer.getCurrentEnergy()
                        + ", Equipa: " + currentPlayer.getTeam());
            }
        }

    }

    /**
     *
     * Lists all players grouped by their level, in ascending order. For each
     * level, prints the name, ID, level, current experience points, current
     * energy, and team of each player.
     */
    public void listPlayerPerlevel() {
        int MAX_LEVEL = 100;
        for (int i = 0; i <= MAX_LEVEL; i++) {

            Iterator<Player> iter = player.iterator();
            while (iter.hasNext()) {
                Player currentPlayer = iter.next();
                if (currentPlayer.getLevel() == i) {
                    System.out.println("Level " + i + ":");
                    System.out.println("Nome: " + currentPlayer.getName()
                            + ", ID: " + currentPlayer.getId()
                            + ", Level: " + currentPlayer.getLevel()
                            + ", Experiencia atual: " + currentPlayer.getExperiencePoints()
                            + ", Energia atual: " + currentPlayer.getCurrentEnergy()
                            + ", Equipa: " + currentPlayer.getTeam());
                }
            }
        }
    }

    /**
     *
     * Removes a player from the list by name.
     *
     * @param name the name of the player to be removed
     * @throws EmptyCollectionException if the list is empty
     */
    public void removePlayer(String name) throws EmptyCollectionException {
        Player player = findPlayer(name);
        if (name != null) {
            this.player.remove(player);
        }
    }

    /**
     *
     * Updates the name and team of a player.
     *
     * @param player the player to be updated
     * @param name the new name of the player
     * @param team the new team of the player
     */
    public void updatePlayer(Player player, String name, EnumTeam team) {
        Iterator iter = this.player.iterator();
        while (iter.hasNext()) {
            Player oldPlayer = (Player) iter.next();
            if (oldPlayer.equals(player)) {
                oldPlayer.setName(name);
                oldPlayer.setTeam(team);
                break;
            }
        }
    }

    /**
     *
     * Changes the team of a given player.
     *
     * @param player the player to change the team
     * @param team the new team of the player
     */
    public void changePlayerTeam(Player player, EnumTeam team) {
        Iterator iter = this.player.iterator();
        while (iter.hasNext()) {
            Player oldPlayer = (Player) iter.next();
            if (oldPlayer.equals(player)) {
                player.setTeam(team);
            }
        }

    }

    /**
     *
     * Prints the information of all players in the player list. The information
     * includes the player's name, ID, current energy, and team.
     */
    public void printPlayers() {
        Iterator iter = player.iterator();
        while (iter.hasNext()) {
            Player currentPlayer = (Player) iter.next();
            System.out.println("Nome: " + currentPlayer.getName()
                    + ", ID: " + currentPlayer.getId()
                    + ", Energia atual: " + currentPlayer.getCurrentEnergy()
                    + ", Equipa: " + currentPlayer.getTeam());
        }

    }

    /**
     *
     * Returns true if the management system contains a player with the given
     * name, false otherwise.
     *
     * @param name the name of the player to search for
     * @return true if the management system contains a player with the given
     * name, false otherwise
     */
    public boolean containsPlayer(String name) {
        Iterator iter = player.iterator();
        while (iter.hasNext()) {
            Player currentPlayer = (Player) iter.next();
            if (currentPlayer.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    /**
     *
     * Returns the list of players.
     *
     * @return the list of players
     */
    public ArrayUnorderedList<Player> getPlayer() {
        return player;
    }

    /**
     *
     * Sets the list of players to the specified list.
     *
     * @param player the list of players to set
     */
    public void setPlayer(ArrayUnorderedList<Player> player) {
        this.player = player;
    }

/**
 * Returns the list of players.
 * 
 * @return the list of players
 */
public ArrayUnorderedList<Player> listPlayers() {
    return this.player;
}
/**
 * Returns a string representation of the player list.
 * 
 * @return a string representation of the player list
 */
public String toString() {
    String result = "Player List:\n";
    Iterator<Player> iter = player.iterator();
    while (iter.hasNext()) {
        Player currentPlayer = iter.next();
        result += "Name: " + currentPlayer.getName() + ", ID: " + currentPlayer.getId()
                + ", Team: " + currentPlayer.getTeam() + "\n";
    }
    return result;
}


}
