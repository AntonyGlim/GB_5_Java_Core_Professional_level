/**
 * 2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
 * то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 */
package lesson_6_Tests_jUnit_Logging_Log4о;

public class ArrWithFourAndOne {

    /**
     * Метод отвечает требованиям задания
     * @param arr - получает на вход массив с числами
     * @return - true если массив содержит и 4 и 1 и не содержит других чисел
     */
    public boolean isFourOrOne (int[] arr){
        boolean isFour = false;                                 //Есть 4?
        boolean isOne = false;                                  //Есть 1?
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) isOne = true;
            if (arr[i] == 4) isFour = true;
            if (arr[i] != 1 && arr[i] != 4) return false;       //Если встретилось хоть одно число отличное от 4 и 1
        }
        return (isOne && isFour);
    }
}
