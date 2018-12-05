package lesson_5_Multithreading_Part_II;

public class ddd {
    public static void main(String[] args) {
        System.out.println(sumOfHiddenNumbers(1, 0));
    }

    public static int sumOfHiddenNumbers (int a, int b){
        if (a == b) return 1;
        int sum = 0;
        int max = b;
        int min = a;
        if (a > b) {
            max = a;
            min = b;
        }
        for (int i = min; i < max; i++) {
            sum += i;
        }
        return sum;
    }
}
