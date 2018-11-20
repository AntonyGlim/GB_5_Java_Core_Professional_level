/**
 * 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
 */

package lesson_1_Generics_and_Сallbacks;

public class MainGenericsTask {
    public static void main(String[] args) {

        String[] strArr1 = {"0", "1", "2", "3", "4", "5"};
        Integer[] intArr1 = {0, 11, 22, 33, 44, 55};
        Float[] fltArr1 = {0.1f, 1.1f, 2.1f, 3.1f, 4.1f, 5.1f};
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
        System.out.println();

        ExchangeElementsTask<Integer> intArr2 = new ExchangeElementsTask<Integer>(intArr1);
        intArr2.showType();
        intArr2.printArr(intArr1, "Массив до перестановки: ");
        intArr1 = intArr2.exchangeElements(2, 4);
        intArr2.printArr(intArr1, "Массив после перестановки: ");
        System.out.println();

        ExchangeElementsTask<Float> fltArr2 = new ExchangeElementsTask<Float>(fltArr1);
        fltArr2.showType();
        fltArr2.printArr(fltArr1, "Массив до перестановки: ");
        fltArr1 = fltArr2.exchangeElements(2, 4);
        fltArr2.printArr(fltArr1, "Массив после перестановки: ");
        System.out.println();

        ExchangeElementsTask<ExampleCat> catArr2 = new ExchangeElementsTask<ExampleCat>(catArr1);
        catArr2.showType();
        catArr2.printArr(catArr1, "Массив до перестановки: ");
        catArr1 = catArr2.exchangeElements(2, 4);
        catArr2.printArr(catArr1, "Массив после перестановки: ");
        System.out.println();

    }

//    public void showResults(ExchangeElementsTask<?> arr1){
//        ExchangeElementsTask<?>[] arr2 = new ExchangeElementsTask<?>[](arr1);
//        arr2.showType();
//        arr2.printArr(arr1, "Массив до перестановки: ");
//        arr1 = arr2.exchangeElements(2, 4);
//        arr2.printArr(arr1, "Массив после перестановки: ");
//        System.out.println();
//    }
}
