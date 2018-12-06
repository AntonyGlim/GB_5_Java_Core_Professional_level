package lesson_5_Multithreading_Part_II;

/**
 * Класс описывает препятствия
 */
public abstract class Stage {
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
}
