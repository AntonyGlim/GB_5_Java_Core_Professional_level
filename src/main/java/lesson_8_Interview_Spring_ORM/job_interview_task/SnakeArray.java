/**
 * 1 Задать размерность матрицы от 5 до 7
 * 2 Создать матрицу с указанной размерностью
 * 3 Заполнить матрицу по спирали (числа увеличиваются на 1) (число начинается с 1)
 */
package lesson_8_Interview_Spring_ORM.job_interview_task;

import java.util.Scanner;

public class SnakeArray {

    static private int maxNumberInArr = 0;
    static private int squareSideSize = 0;

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите последнее число последовательности...");
            maxNumberInArr = sc.nextInt();
            System.out.println(calculateSquareSideSize(maxNumberInArr));
        }
    }

    private static int calculateSquareSideSize(int maxNumberInArr){
        double sqrDoub = Math.sqrt(maxNumberInArr);
        int sqrInt = (int) Math.sqrt(maxNumberInArr);
        int result;
        if (sqrDoub % sqrInt != 0){
            result = sqrInt + 1;
        } else {
            result = sqrInt;
        }
        return result;
    }
}
