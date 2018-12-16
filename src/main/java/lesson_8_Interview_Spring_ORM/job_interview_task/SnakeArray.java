/**
 * 1 Задать размерность матрицы от 5 до 7
 * 2 Создать матрицу с указанной размерностью
 * 3 Заполнить матрицу по спирали (числа увеличиваются на 1) (число начинается с 1)
 */
package lesson_8_Interview_Spring_ORM.job_interview_task;

import java.util.Scanner;

public class SnakeArray {

    static private int maxNumberInArr;
    static private int squareSideSize;
    static private int[][] snakeArr;

    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите последнее число последовательности...");
            maxNumberInArr = sc.nextInt();
            squareSideSize = calculateSquareSideSize(maxNumberInArr);
            snakeArr = new int[squareSideSize][squareSideSize];
        }
    }

    /**
     * Расчитываем размерность будующего массива
     * @param maxNumberInArr - максимальное значение в массиве
     * @return - длина стороны массива
     */
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

    /**
     * Метод выведет на экран двумерный массив
     * @param arr
     */
    private static void printArray(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
//                arr[i][j] = j;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
