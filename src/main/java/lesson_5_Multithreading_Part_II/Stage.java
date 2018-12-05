package lesson_5_Multithreading_Part_II;

import java.util.concurrent.Semaphore;

import static lesson_5_Multithreading_Part_II.MainClass.CARS_COUNT;

public abstract class Stage {
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
//    protected Semaphore smp = new Semaphore(CARS_COUNT / 2);
}
