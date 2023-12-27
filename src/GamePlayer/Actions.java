package GamePlayer;

import EstruturasList.ArrayUnorderedList;
import static Enums.EnumPortalState.Conquered;
import static Enums.EnumPortalState.Neutral;
import Exceptions.EmptyCollectionException;
import GameLocal.Connector;
import GameLocal.Portal;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 *
 *
 *
 *
 * This class represents a set of actions that can be performed in the game
 * management system.
 */
public class Actions {

    public Actions() {

    }

    /**
     *
     * Recharges the energy of the given player using the provided connector,
     *
     * if the player is not on cooldown for the connector.
     *
     * @param player the player whose energy will be recharged
     *
     * @param connector the connector that will be used to recharge the energy
     *
     * @throws EmptyCollectionException if the player's last entry list in the
     * connector is empty
     */
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

    /**
     *
     * Attempts to conquer a portal by a player. If the portal is in a Neutral
     * state, the player's current energy is decreased by 25%, and the portal is
     * conquered. If the portal is in a Conquered state, and it does not belong
     * to the player's team, and the player has enough energy to conquer it, the
     * player's current energy is decreased by the energy required to conquer
     * the portal, and the portal is conquered. If the portal is in a Conquered
     * state, and it belongs to the player's team, the portal is not conquered.
     *
     * @param player the player attempting to conquer the portal
     * @param portal the portal being targeted for conquest
     * @return true if the portal is conquered, false otherwise
     */
    public boolean conquerPortal(Player player, Portal portal) {

        if (portal.getState().equals(Neutral)) {
            player.setCurrentEnergy((int) (player.getCurrentEnergy() * 0.75));
            portal.setOwnership(player);
            portal.setTeam(player.getTeam());
            portal.setState(Conquered);
            portal.setEnergy(0);
            return true;

        } else if (portal.getState().Conquered.equals(Conquered)) {
            if (portal.getTeam() != player.getTeam()) {
                if (portal.getEnergy() <= player.getCurrentEnergy()) {
                    player.setCurrentEnergy(player.getCurrentEnergy() - portal.getEnergy());
                    portal.setOwnership(player);
                    portal.setTeam(player.getTeam());
                    portal.setEnergy(0);
                    return true;
                } else {
                    portal.setEnergy(portal.getEnergy() - player.getCurrentEnergy());
                    player.setCurrentEnergy(0);

                }

            } else {
                System.out.println("Portal já pertence à sua equipa");

            }

        }

        return false;
    }

    /**
     *
     * Recharges a portal with energy, if certain conditions are met.
     *
     * @param player the player recharging the portal
     * @param portal the portal being recharged
     * @param energy the amount of energy being used to recharge the portal
     */
    public void rechargePortal(Player player, Portal portal, int energy) {
        int newEnergy = energy + portal.getEnergy();
        if (player.getTeam().equals(portal.getTeam())) {
            if (newEnergy <= portal.getMaxEnergy() && player.getCurrentEnergy() >= energy) {
                portal.setEnergy(newEnergy);
                player.setCurrentEnergy(player.getCurrentEnergy() - energy);
            }
        } else {
            System.out.println("Portal não conquistado pela sua equipa!");

        }

    }

}
