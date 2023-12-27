/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Player;

import java.time.LocalDateTime;

/**
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class PlayerCooldown {

    private Player player;
    private LocalDateTime LastEntry;

    public PlayerCooldown(Player player, LocalDateTime LastEntry) {
        this.player = player;
        this.LastEntry = LastEntry;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public LocalDateTime getLastEntry() {
        return LastEntry;
    }

    public void setLastEntry(LocalDateTime LastEntry) {
        this.LastEntry = LastEntry;
    }

}
