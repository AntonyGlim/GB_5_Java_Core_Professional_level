package lesson_1_Generics_and_Сallbacks.task_2;

import java.util.ArrayList;

public class ArrToList<T> {

    private T[] arr;

    public ArrToList(T[] arr) {
        this.arr = arr;
    }

    public ArrayList<T> toList(T[] arr) {
        ArrayList<T> list = new ArrayList<T>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    void printArr(T[] arr) {
        System.out.println("Массив: ");
        for (T t : arr) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
}
