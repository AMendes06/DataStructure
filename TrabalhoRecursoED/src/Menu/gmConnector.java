/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import List.LinkedList;
import Local.Interaction;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class gmConnector {
    private int energy;
    /**
     * Tempo de espera para recarregar o conector {@link gameSettingsConnector}
     */
    private int cooldown;
    /**
     * Lista de Interações de Jogadores com o conector
     * {@link gameSettingsConnector}
     */
    private LinkedList<Interaction> interactions;
    /**
     * Experiência {@link gameSettingsConnector}
     */
    private final int experience = 30;

    public gmConnector(int energy, int cooldwon, LinkedList<Interaction> interactions) {
        this.energy = energy;
        this.cooldown = cooldwon;
        this.interactions = interactions;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getCooldwon() {
        return cooldown;
    }

    public void setCooldwon(int cooldwon) {
        this.cooldown = cooldwon;
    }

    public LinkedList<Interaction> getInteractions() {
        return interactions;
    }

    public void setInteractions(LinkedList<Interaction> interactions) {
        this.interactions = interactions;
    }

    
}
