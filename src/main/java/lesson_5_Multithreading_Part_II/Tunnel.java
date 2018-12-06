package lesson_5_Multithreading_Part_II;

import java.util.concurrent.Semaphore;

/**
 * Класс описывает тоннель, по которому одновременно могут ехать только половина машин
 * Регулирует потоки java.util.concurrent.Semaphore
 */
public class Tunnel extends Stage {
    Semaphore smp;
    public Tunnel(Semaphore smp) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.smp = smp;
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                smp.acquire();                                                                  //"Включаем красный"
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                smp.release();                                                                  //Освобождаем место для нового потока
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
