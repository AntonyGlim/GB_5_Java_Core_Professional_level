package lesson_1_Generics_and_Сallbacks.task_2;

import lesson_1_Generics_and_Сallbacks.task_1.ExampleCat;

import java.util.ArrayList;

public class MainArrToList {
    public static void main(String[] args) {
        String[] strArr = {"0", "1", "2", "3", "4", "5"};
        Integer[] intArr = {0, 11, 22, 33, 44, 55};
        Float[] fltArr = {0.1f, 1.1f, 2.1f, 3.1f, 4.1f, 5.1f};
        ExampleCat[] catArr = {
                new ExampleCat("Мурзик"),
                new ExampleCat("Барсик"),
                new ExampleCat("Васька"),
                new ExampleCat("Рыжик"),
                new ExampleCat("Снежок"),
                new ExampleCat("Котей"),
        };

        ArrayList<String> strList;
        ArrayList<Integer> intList;
        ArrayList<Float> fltList;
        ArrayList<Float> catList;

        ArrToList al_1 = new ArrToList<String>(strArr);
        ArrToList al_2 = new ArrToList<Integer>(intArr);
        ArrToList al_3 = new ArrToList<Float>(fltArr);
        ArrToList al_4 = new ArrToList<ExampleCat>(catArr);

        strList = al_1.toList(strArr);
        intList = al_2.toList(intArr);
        fltList = al_3.toList(fltArr);
        catList = al_4.toList(catArr);

        al_1.printArr(strArr);
        System.out.println(strList);

        al_2.printArr(intArr);
        System.out.println(intList);

        al_3.printArr(fltArr);
        System.out.println(fltList);

        al_4.printArr(catArr);
        System.out.println(catList);
        
    }

}
