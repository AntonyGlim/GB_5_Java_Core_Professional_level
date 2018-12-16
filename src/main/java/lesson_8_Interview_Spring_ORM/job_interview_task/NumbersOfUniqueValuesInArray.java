/**
 * Представьте, что лесник пытается сосчитать сосны, ели и березы на участке леса. Он может обойти весь участок трижды,
 *  сосчитав сначала только сосны, потом только ели и в третий раз только березы.
 *
 * Конечно, более эффективно обойти лес только один раз, отмечая крестиками сосны на одной странице блокнота,
 *  ели на другой и березы на третьей. Потом останется только сосчитать количество крестиков на каждой странице.
 *  Аналогичная идея работает для подсчета схожих элементов в последовательности или наборе,
 *  с использованием массива счетчиков (в качестве блокнота со страницами).
 *
 * Дан массив длины M с числами в диапазоне 1 ... N, где N не больше 20. Вам нужно пройти по этому массиву и сосчитать
 * сколько раз встречается каждое число.
 * Пожалуйста, не используйте 20 отдельных переменных для счетчиков, а сделайте один массив из них.
 *
 * Пример
 * входные данные:
 * 1 2 3 2 3 1 1 1 1 3
 *
 * ответ:
 * 5 2 3
 */
package lesson_8_Interview_Spring_ORM.job_interview_task;

import java.util.*;

public class NumbersOfUniqueValuesInArray {

    public static void main(String[] args) {

//        int[] array = {1, 2, 3, 2, 3, 1, 1, 1, 1, 3};
        int[] array = {0, 0, 2, 2, 0, 0, 0, 0, 1};                                              //Массив для примера
        int[] arr = HowManyDifferentValuesInArr(array);                                         //Массив с количеством повторений уникальных значений
        printArr(arr);                                                                          //Выведем массив в консоль
    }

    /**
     * Метод посчитает количество уникальных значений во входном массиве
     * @param array - исходный массив
     * @return - массив с количеством уникальных значений
     */
    private static int[] HowManyDifferentValuesInArr(int[] array){
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            if (linkedHashMap.containsKey(array[i])){                                           //Если такое значение уже встречалось
                linkedHashMap.put(array[i], linkedHashMap.get(array[i]) + 1);                   //Увеличиваем значение на 1
            } else {
                linkedHashMap.put(array[i], 1);                                                 //Иначе присваиваем значение 1
            }
        }
        int count = 0;
        int[] result = new int[linkedHashMap.size()];
        for (Integer i : linkedHashMap.values()){                                               //Выводим значения
            result[count] = i;
            count++;
        }
        return result;
    }

    /**
     * Метод выведет массив в консоль
     * @param arr
     */
    private static void printArr (int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
