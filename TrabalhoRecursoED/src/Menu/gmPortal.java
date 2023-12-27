/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import Player.Player;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class gmPortal {

    /**
     * Energia {@link gameSettingsConnector}
     */
    private int energy;
    /**
     * Máximo de Energia {@link gameSettingsConnector}
     */
    private int maxEnergy;
    /**
     * Dono {@link gameSettingsConnector}
     */
    private Player ownership;

    /**
     * Experiência {@link gameSettingsConnector}
     */
    private final int experience = 20;

    public gmPortal(int energy, int maxEnergy, Player ownership) {
        this.energy = energy;
        this.maxEnergy = maxEnergy;
        this.ownership = ownership;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public Player getOwnership() {
        return ownership;
    }

    public void setOwnership(Player ownership) {
        this.ownership = ownership;
    }

}
