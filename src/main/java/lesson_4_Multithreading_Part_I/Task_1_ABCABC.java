/**
 * 1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
 * Используйте wait/notify/notifyAll.
 */
package lesson_4_Multithreading_Part_I;

public class Task_1_ABCABC {

        private final Object mon1 = new Object();
        private final Object mon2 = new Object();
        private volatile char currentLetter = 'A';

        public static void main(String[] args) {
            Task_1_ABCABC abc = new Task_1_ABCABC();
            Thread t1 = new Thread(() -> {
                w.printA();
            });
            Thread t2 = new Thread(() -> {
                w.printB();
            });
            t1.start();
            t2.start();
        }

        public void printA() {
            synchronized (mon) {
                try {
                    for (int i = 0; i < 3; i++) {
                        while (currentLetter != 'A') {
                            mon.wait();
                        }
                        System.out.print("A");
                        currentLetter = 'B';
                        mon.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void printB() {
            synchronized (mon) {
                try {
                    for (int i = 0; i < 3; i++) {
                        while (currentLetter != 'B') {
                            mon.wait();
                        }
                        System.out.print("B");
                        currentLetter = 'A';
                        mon.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

}
