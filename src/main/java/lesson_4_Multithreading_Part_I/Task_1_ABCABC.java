package lesson_4_Multithreading_Part_I;

public class Task_1_ABCABC {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.print("A");
                }
            }
        });
        t1.start();
    }
}
