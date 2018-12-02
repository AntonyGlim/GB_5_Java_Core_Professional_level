/**
 * 1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
 * Используйте wait/notify/notifyAll.
 */
package lesson_4_Multithreading_Part_I;

public class Task_1_ABCABC {

        private final Object mon = new Object();
        private volatile char currentLetter = 'A';
        private final int cicleCount = 5;

        public static void main(String[] args) {

            final Task_1_ABCABC abc = new Task_1_ABCABC();

            Thread tA = new Thread(new Runnable() {
                @Override
                public void run() {
                    abc.printA();
                }
            });

            Thread tB = new Thread(new Runnable() {
                @Override
                public void run() {
                    abc.printB();
                }
            });

            Thread tC = new Thread(new Runnable() {
                @Override
                public void run() {
                    abc.printC();
                }
            });


            tA.start();
            tB.start();
            tC.start();
        }

        public void printA() {
            synchronized (mon) {
                try {
                    for (int i = 0; i < cicleCount; i++) {
                        while (currentLetter != 'A') {
                            mon.wait();
                        }
                        System.out.print("A");
                        currentLetter = 'B';
                        mon.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void printB() {
            synchronized (mon) {
                try {
                    for (int i = 0; i < cicleCount; i++) {
                        while (currentLetter != 'B') {
                            mon.wait();
                        }
                        System.out.print("B");
                        currentLetter = 'C';
                        mon.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    public void printC() {
        synchronized (mon) {
            try {
                for (int i = 0; i < cicleCount; i++) {
                    while (currentLetter != 'C') {
                        mon.wait();
                    }
                    System.out.print("C");
                    currentLetter = 'A';
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
