/**
 * 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
 */

package lesson_1_Generics_and_Сallbacks;

public class MainGenericsTask {
    public static void main(String[] args) {

        String[] strArr1 = {"0", "1", "2", "3", "4", "5"};
        Integer[] intArr1 = {0, 1, 2, 3, 4, 5};
        Float[] fltArr1 = {0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        ExampleCat[] catArr1 = {
                new ExampleCat("Мурзик"),
                new ExampleCat("Барсик"),
                new ExampleCat("Васька"),
                new ExampleCat("Рыжик"),
                new ExampleCat("Снежок"),
                new ExampleCat("Котей"),
        };

        ExchangeElementsTask<String> strArr2 = new ExchangeElementsTask<String>(strArr1);
        strArr2.showType();
        strArr2.printArr(strArr1, "Массив до перестановки: ");
        strArr1 = strArr2.exchangeElements(2, 4);
        strArr2.printArr(strArr1, "Массив после перестановки: ");
    }
}
