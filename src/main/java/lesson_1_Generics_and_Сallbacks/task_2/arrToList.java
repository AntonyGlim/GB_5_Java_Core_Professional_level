package lesson_1_Generics_and_Сallbacks.task_2;

import java.util.ArrayList;

public class arrToList <T> {

    public ArrayList<T> arrToList(T[] arr) {
        ArrayList<T> list = new ArrayList<T>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
    return list;
    }
}
