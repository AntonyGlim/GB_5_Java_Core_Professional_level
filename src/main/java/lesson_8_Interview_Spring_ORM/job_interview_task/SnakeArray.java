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
            snakeArr = fillInWithNumbers(snakeArr, maxNumberInArr, squareSideSize);
            printArray(snakeArr);
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
     * Метод выведет на экран двумерный массив (с форматированием)
     * @param arr
     */
    private static void printArray(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%6d", arr[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Метод заполняет массив по спирали
     * @param arr - передаем в метод массив
     * @param maxNumberInArr - максимальное значение, которое будет присутствовать в этом массиве
     * @param size - обределенные ранее размеры массивва
     * @return - заполненный по спирали массив
     */
    private static int[][] fillInWithNumbers(int[][] arr, int maxNumberInArr, int size) {
        //Если пришел массив с 1 элементом
        if(size == 1){
            arr[0][0] = 1;
        }

        int startLineIndex = 0;                                             //индекс строки с которой начнется заполнение
        int startColumnIndex = 0;                                           //индекс столбца с которого начнется заполнение
        int presentValue = 1;                                               //текущее значение с которого начнется заполнение массива

        while (size >= 2){                                                  //пока размеры массива больше или равны 2
            //Работа с первой строкой
            for (int i = startLineIndex; i < size; i++) {
                arr[startLineIndex][i] = presentValue;
                presentValue++;
                if (presentValue > maxNumberInArr)return arr;               //если мы дошли до максимального значения в массиве, то завершаем заполнение
            }
            //Работа с последним столбцом
            for (int i = startLineIndex + 1; i < size; i++) {
                arr[i][size - 1] = presentValue;
                presentValue++;
                if (presentValue > maxNumberInArr)return arr;
            }
            //Работа с последней строкой
            for (int i = size - 2; i >= startColumnIndex; i--) {
                arr[size - 1][i] = presentValue;
                presentValue++;
                if (presentValue > maxNumberInArr)return arr;
            }
            //Работа с первым столбцом
            for (int i = size - 2; i >= startLineIndex + 1; i--) {
                arr[i][startColumnIndex] = presentValue;
                presentValue++;
                if (presentValue > maxNumberInArr)return arr;
            }
            size -= 1;                                                      //уменьшаем значение размера на 1
            startLineIndex++;                                               //изменяем стартовые индексы для следующей итерации
            startColumnIndex++;
        }

        return arr;
    }
}
