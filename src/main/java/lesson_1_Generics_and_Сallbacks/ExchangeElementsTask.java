/**
 * 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
 */

package lesson_1_Generics_and_Сallbacks;

public class ExchangeElementsTask {
    public static void main(String[] args) {

        String[] strArr = {"1", "2", "3", "4", "5"};
        Integer[] intArr = {1, 2, 3, 4, 5};
        Float[] fltArr = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        ExampleCat[] catArr = {
                new ExampleCat("Мурзик"),
                new ExampleCat("Барсик"),
                new ExampleCat("Васька"),
                new ExampleCat("Рыжик"),
                new ExampleCat("Снежок"),
        };


    }
}
