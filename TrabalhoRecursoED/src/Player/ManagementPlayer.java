package Player;

import List.ArrayUnorderedList;
import Enum.EnumTeam;
import Exceptions.EmptyCollectionException;
import Node.LinearNode;
import Local.Connector;
import Node.DoubleNode;
import OrderedList.OrderedList;
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

    private ArrayUnorderedList<Player> player = new ArrayUnorderedList<>();

    public ManagementPlayer() {

    }

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

    public Player findPlayer(String name) {
        Player player;
        Iterator iter = this.player.iterator();
        while (iter.hasNext()) {
            player = (Player) iter.next();
            if (player.getName().equals(name)) {
                return player;

            }
        }
        throw new IllegalArgumentException("Este jogador não exite existe");

    }

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
                            +", Level: " + currentPlayer.getLevel()
                            + ", Energia atual: " + currentPlayer.getCurrentEnergy()
                            + ", Equipa: " + currentPlayer.getTeam());
                }
            }
        }
    }

    public void removePlayer(String name) throws EmptyCollectionException {
        Player player = findPlayer(name);
        if (name != null) {
            this.player.remove(player);
        }
    }

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

    public void changePlayerTeam(Player player, EnumTeam team) {
        Iterator iter = this.player.iterator();
        while (iter.hasNext()) {
            Player oldPlayer = (Player) iter.next();
            if (oldPlayer.equals(player)) {
                player.setTeam(team);
            }
        }

    }

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

    public ArrayUnorderedList<Player> getPlayer() {
        return player;
    }

    public void setPlayer(ArrayUnorderedList<Player> player) {
        this.player = player;
    }

    public String toString(Player player) {
        Iterator iter = player.iterator();
        while (iter.hasNext()) {
            System.out.println("jogador1: Nome:" + player.getName() + "id:" + player.getId() + "team" + player.getTeam());
        }
        return "ManamagentPlayer{" + "player=" + player + '}';
    }

    public ArrayUnorderedList<Player> listPlayers() {

        return this.player;
    }

}
