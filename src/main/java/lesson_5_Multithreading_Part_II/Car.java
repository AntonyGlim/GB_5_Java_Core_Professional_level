package lesson_5_Multithreading_Part_II;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Класс создает машину в отдельном потоке
 */
public class Car implements Runnable {

    private static int CARS_COUNT;
    static { CARS_COUNT = 0; }
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

    /**
     * Конструктор принимает, кроме прочих, параметры для синхронизации
     * @param race - полоса препятствий
     * @param speed - скорость
     * @param cb - CyclicBarrier для одновременного старта
     * @param cdl_1 - Для синхронизации с Main потоком (объявление о старте)
     * @param cdl_2 - Для синхронизации с Main потоком (объявление о завершении)
     */
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
            cdl_1.countDown();                                                          //Закончил подготовку
            Thread.sleep(1);                                                            //Чтобы избежать фальстартов
            cb.await();                                                                 //Готов к старту!
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {                             //Проходит препятствия
            race.getStages().get(i).go(this);
        }
        cdl_2.countDown();                                                              //Финишировал!
        MainClass.number++;                                                             //Вычисляем номер победителя
        if (MainClass.number == 1) System.out.println(this.name + " финишировал под номером " + MainClass.number + ". ПОБЕДА!");
        else System.out.println(this.name + " финишировал под номером " + MainClass.number);
    }
}
