/**
 * 1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
 * Используйте wait/notify/notifyAll.
 */
package lesson_4_Multithreading_Part_I;

public class Task_1_ABCABC {
    public static void main(String[] args) {

        Symbol symbol = new Symbol();
        Thread t1 = new Thread(new PrintSymbol(symbol, "A", 0));
        Thread t2 = new Thread(new PrintSymbol(symbol, "B", 100));
        Thread t3 = new Thread(new PrintSymbol(symbol, "C", 200));
        t1.start();
        t2.start();
        t3.start();
    }
}

/**
 * Класс по которому будет синхронизация
 */
class Symbol{
    String symbol = "";
}

/**
 * Распечатка символа в потоке
 */
class PrintSymbol implements Runnable{
    Symbol symb;
    String word;
    long sleepTime;

    public PrintSymbol(Symbol symb, String word, long sleepTime) {
        this.symb = symb;
        this.word = word;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
            symb.symbol = word;
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            for (int i = 0; i < 5; i++) {
                System.out.printf("%s", /*Thread.currentThread().getName(),*/ word);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}
