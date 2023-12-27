package Player;

import List.ArrayUnorderedList;
import Enum.EnumPortalState;
import static Enum.EnumPortalState.Conquered;
import static Enum.EnumPortalState.Neutral;
import Exceptions.EmptyCollectionException;
import Local.Connector;
import Local.Portal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class Actions {

    private Player player;

    public Actions() {

    }

    public void rechargeEnergyPlayer(Player player, Connector connector) throws EmptyCollectionException {
        boolean VerifyConnector = true;
        ArrayUnorderedList<PlayerCooldown> lastEntryList = connector.getPlayerLastEntryList();
        for (PlayerCooldown playerCoold : lastEntryList) {
            LocalDateTime localDateTime = LocalDateTime.now();

            if (playerCoold.getPlayer().equals(player)) {
                LocalDateTime diff = LocalDateTime.from(playerCoold.getLastEntry());
                int minutes = (int) diff.until(localDateTime, ChronoUnit.MINUTES);
                if (minutes <= connector.getCooldown()) {
                    VerifyConnector = false;
                } else {
                    lastEntryList.remove(playerCoold);
                }

            }
        }
        if (VerifyConnector) {

            int energyToRecharge = connector.getEnergy();
            int currentEnergy = player.getCurrentEnergy();
            int newEnergy = currentEnergy + energyToRecharge;
            player.setCurrentEnergy(newEnergy);

            PlayerCooldown playerCooldown = new PlayerCooldown(player, LocalDateTime.now());
            lastEntryList.addToRear(playerCooldown);
        }
    }

    public boolean conquerPortal(Player player, Portal portal) {

        if (portal.getState().equals(Neutral)) {
            player.setCurrentEnergy((int) (player.getCurrentEnergy() * 0.75));
            portal.setOwnership(player);
            portal.setTeam(player.getTeam());
            portal.setState(Conquered);
            portal.setEnergy(0);
            return true;

        } else if (portal.getState().Conquered.equals(Conquered) && portal.getEnergy() <= player.getCurrentEnergy()) {
            player.setCurrentEnergy(player.getCurrentEnergy() - portal.getEnergy());
            portal.setOwnership(player);
            portal.setTeam(player.getTeam());
            portal.setEnergy(0);
            return true;
        }
        return false;
    }

    public void rechargePortal(Player player, Portal portal, int energy) {
        int newEnergy = energy + portal.getEnergy();
        if(this.player.getTeam().equals(portal.getTeam()))
        if (newEnergy <= portal.getMaxEnergy() && player.getCurrentEnergy() <= energy) {
            portal.setEnergy(portal.getEnergy() + energy);
        }else{
            throw new IllegalArgumentException("Portal não conquistado pela sua equipa!");
        }

    }
    
    
    

}
