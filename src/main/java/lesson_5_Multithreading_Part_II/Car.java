package lesson_5_Multithreading_Part_II;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier cb;
    private CountDownLatch cdl_1;
    private CountDownLatch cdl_2;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier cb, CountDownLatch cdl_1, CountDownLatch cdl_2) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cb = cb;
        this.cdl_1 = cdl_1;
        this.cdl_2 = cdl_2;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cdl_1.countDown();
            Thread.sleep(1);
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        cdl_2.countDown();
        MainClass.number++;
        if (MainClass.number == 1) System.out.println(this.name + " финишировал под номером " + MainClass.number + ". ПОБЕДА!");
        else System.out.println(this.name + " финишировал под номером " + MainClass.number);
    }
}
