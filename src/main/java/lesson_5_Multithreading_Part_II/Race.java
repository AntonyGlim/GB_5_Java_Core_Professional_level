package lesson_5_Multithreading_Part_II;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Класс формирует массив с препятствиями
 * (используя аргумент переменной длинны)
 */
public class Race {
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<Stage>(Arrays.asList(stages));
    }
}
