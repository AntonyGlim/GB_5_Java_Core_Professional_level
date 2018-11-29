package lesson_3_Input_Output_tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static lesson_3_Input_Output_tools.Task_1.printByteArr;
//TODO Для чтения использовать буферы всякие
//TODO Разобраться с кодировкой
//TODO Вынести метод чтения в отдельный метод
//TODO Поработать со структурой файлов в задании
//TODO Засечь время выполнения
//TODO Оптимизировать задания 1 и 2
public class Task_3 {
    final static String pathAndName = "src/main/java/lesson_3_Input_Output_tools/task_3_voina-i-mir.txt";
    final static int arrSize = 18000;

    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            byte[] secondArr = new byte[arrSize];
            fis = new FileInputStream(pathAndName);
            int count = fis.read(secondArr);
            System.out.println("Размер массива: " + count);
            printByteArr(secondArr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
