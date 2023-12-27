package Player;

import List.ArrayUnorderedList;
import Enum.EnumTeam;
import java.util.Objects;

/**
 *
 * @author Angelo Mendes 8180655
 * @author Francisco Azevedo 8170318
 * @param <T>
 */
public class Player<T> extends ArrayUnorderedList<T> {

    private int id;
    private static int countPlayers = 1;
    private String name;
    private int level;
    private int currentEnergy;
    private int maxEnergy;
    public EnumTeam team;
    public long experiencePoints;
    

    public Player(String name, int level,int experiencePoints, int currentEnergy, EnumTeam team) {
        this.id = countPlayers++;
        this.name = name;
        this.level = level;
        this.currentEnergy = currentEnergy;
        this.team = team;
        this.experiencePoints = experiencePoints;
    }

    public Player(String name, EnumTeam team) {
        this.id = countPlayers++;
        this.name = name;
        this.level = 1;
        this.currentEnergy = 50;
        this.team = team;
       
    }

    public Player(String name) {
        this.name = name;
    }
    
    public Player(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public EnumTeam getTeam() {
        return team;
    }

    public void setTeam(EnumTeam team) {
        this.team = team;
    }

    public static int getCountPlayers() {
        return countPlayers;
    }

    public static void setCountPlayers(int countPlayers) {
        Player.countPlayers = countPlayers;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    public long getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(long experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player<?> other = (Player<?>) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

}
