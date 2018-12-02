/**
 * 1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
 * Используйте wait/notify/notifyAll.
 */
package lesson_4_Multithreading_Part_I;

public class Task_1_ABCABC {
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    for (int i = 0; i < 5; i++) {
                        System.out.print("A");
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    for (int i = 0; i < 5; i++) {
                        System.out.print("B");
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    for (int i = 0; i < 5; i++) {
                        System.out.print("C");
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
