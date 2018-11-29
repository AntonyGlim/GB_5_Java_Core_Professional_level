/**
 * 1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
 */
package lesson_3_Input_Output_tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task_1 {
    final static String pathAndName = "src/main/java/lesson_3_Input_Output_tools/Task_1_file.txt";
    final static int arrSize = 500;

    public static void main(String[] args) {

        byte[] byteArr = createNewByteArr(arrSize);
        writeArrInFile(pathAndName, byteArr);
        byte[] secondArr = readFromFileInArray();
        printByteArr(secondArr);

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

    public static void writeArrInFile (String pathAndName, byte[] byteArr){
        FileOutputStream fos = null;
        try {

            int count = 0;
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

    public static byte[] readFromFileInArray (){
        FileInputStream fis = null;
        byte[] arr = new byte[arrSize];
        try {

            fis = new FileInputStream(pathAndName);
            int count = fis.read(arr);
            System.out.println("Размер массива: " + count);

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
        return arr;
    }

}
