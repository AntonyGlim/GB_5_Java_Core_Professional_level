package lesson_5_Multithreading_Part_II.ShipsInTheSea;

public abstract class Seaway {
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void toDo(Ship ship);
}
