/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 */
public class Configuration implements Comparable {

    private int level;
    private int xp;
    private int energy;

    public Configuration(int level, int xp, int energy) {
        this.level = level;
        this.xp = xp;
        this.energy = energy;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public int compareTo(Object o) {
        if (((Configuration) o).getLevel() == this.getLevel()) {
            return 0;
        } else if (((Configuration) o).getLevel() > this.getLevel()) {
            return 1;
        } else {
            return -1;
        }
    }

}
