package Local;

import List.ArrayUnorderedList;
import Player.Player;
import Player.PlayerCooldown;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class Connector extends Local {

    private int minas;
    private int energy;
    private int cooldown;

    private ArrayUnorderedList<Player> Player = new ArrayUnorderedList<>();
    private ArrayUnorderedList<PlayerCooldown> PlayerLastEntryList = new ArrayUnorderedList<>();

    public Connector(int id, int cooldown, Coordinates coordinates) {
        super(id, coordinates);
        this.cooldown = cooldown;
    }

    public Connector(int energy, int cooldown, int id, int minas, Coordinates coordinates) {
        super(id, coordinates);
        this.energy = energy;
        this.cooldown = cooldown;
        this.minas = minas;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public ArrayUnorderedList<PlayerCooldown> getPlayerLastEntryList() {
        return PlayerLastEntryList;
    }

    public void setPlayerLastEntryList(ArrayUnorderedList<PlayerCooldown> PlayerLastEntryList) {
        this.PlayerLastEntryList = PlayerLastEntryList;
    }

    public int getMinas() {
        return minas;
    }

    public void setMinas(int minas) {
        this.minas = minas;
    }

    public ArrayUnorderedList<Player> getPlayer() {
        return Player;
    }

    public void setPlayer(ArrayUnorderedList<Player> Player) {
        this.Player = Player;
    }
    
      public int temMinaDeDescarga() {
        return minas;
    }

}
