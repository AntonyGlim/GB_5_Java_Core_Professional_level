/**
 * 1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
 * Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
 * идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
 * иначе в методе необходимо выбросить RuntimeException.
 * Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 *
 * Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
 */
package lesson_6_Tests_jUnit_Logging_Log4о;

public class FromArrToArr {
    public int[] arrStrtsAfterFour (int[] arr){
        int index;
        int[] arrAfterFour;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4){
                arrAfterFour = new int[arr.length - i - 1];
                for (int j = 0; j < arrAfterFour.length; j++) {
                    arrAfterFour[j] = arr[j + i + 1];
                }
                return arrAfterFour;
            }
        }
        throw new RuntimeException("В массиве нет 4!");
    }
}
