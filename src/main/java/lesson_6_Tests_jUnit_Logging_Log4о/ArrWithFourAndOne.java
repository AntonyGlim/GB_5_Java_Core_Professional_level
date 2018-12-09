/**
 * 2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
 * то метод вернет false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 */
package lesson_6_Tests_jUnit_Logging_Log4о;

public class ArrWithFourAndOne {

    public boolean isFourOrOne (int[] arr){
        boolean isFour = false;
        boolean isOne = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) isOne = true;
            if (arr[i] == 1) isFour = true;
            if (arr[i] != 1 && arr[i] != 4) return false;
        }
        return (isOne && isFour);
    }
}
