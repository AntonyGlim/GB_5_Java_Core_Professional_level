/**
 * 1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
 */
package lesson_3_Input_Output_tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task_1 {
    final static String pathAndName = "src/main/java/lesson_3_Input_Output_tools/task_1_2/task_1_file.txt";
    final static int arrSize = 50;

    public static void main(String[] args) {
        FileInputStream fis = null;
        createFileWithBytes(pathAndName, arrSize);

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

    public static byte[] createNewByteArr (int arrSize){
        byte[] byteArray = new byte[arrSize];
        for (int i = 0; i < byteArray.length; i++) {
            byteArray[i] = 'i';
        }
        return byteArray;
    }

    public static void printByteArr (byte[] arr){
        System.out.println("Выведем массив: ");
        for (int i = 0; i < arr.length; i++) {
            if (i % 50 == 0 && i != 0){
                System.out.println();
            }
            System.out.print((char) arr[i]);
        }
    }

    public static void createFileWithBytes (String pathAndName, int arrSize){
        byte[] byteArr = createNewByteArr(arrSize);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(pathAndName);   //Файл создасться, если до этого не существовал
            fos.write(byteArr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
