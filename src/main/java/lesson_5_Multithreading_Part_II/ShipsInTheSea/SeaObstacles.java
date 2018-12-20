package lesson_5_Multithreading_Part_II.ShipsInTheSea;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Класс формирует лист с этапами движения корабля
 * (используя аргумент переменной длинны)
 */
public class SeaObstacles {
    private ArrayList<SeaAdventure> seaAdventures;

    public ArrayList<SeaAdventure> getSeaAdventures() {
        return seaAdventures;
    }

    public SeaObstacles(SeaAdventure ... seaAdventures) {
        this.seaAdventures = new ArrayList<SeaAdventure>(Arrays.asList(seaAdventures));
    }
}
