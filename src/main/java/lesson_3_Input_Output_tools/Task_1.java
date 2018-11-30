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
    final static int arrSize = 50;                                              //Размер массива

    public static void main(String[] args) {

        byte[] byteArr = createNewByteArr(arrSize, (byte) 'g');                 //Создаем новый массив с байтами
        writeArrInFile(pathAndName, byteArr);                                   //Записываем массив в файл
        byte[] secondArr = readFromFileInArray(pathAndName);                    //Создаем второй массив в который записываем данные из файла
        printByteArr(secondArr);                                                //Выводим считаный массив в консоль

    }

    /**
     * Метод создаст массив с байтами
     * @param arrSize - размеры массива
     * @param b - символ, который будет помещен в массив
     * @return - массив с байтами
     */
    public static byte[] createNewByteArr (int arrSize, byte b){
        byte[] byteArray = new byte[arrSize];
        for (int i = 0; i < byteArray.length; i++) {
            byteArray[i] = b;
        }
        return byteArray;
    }

    /**
     * Метод выводит в консоль массив
     * @param arr - получает на вход байтовый массив
     */
    public static void printByteArr (byte[] arr){
        System.out.println("Выведем массив: ");
        for (int i = 0; i < arr.length; i++) {
            if (i % 100 == 0 && i != 0){
                System.out.println();
            }
            System.out.print((char) arr[i]);
        }
    }

    /**
     * Метод записывает байтовый массив в файл
     * @param pathAndName - директория и имя файла
     * @param byteArr - массив байтов
     */
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

    /**
     * Метод считывает байты из файла и записывает в массив
     * @param pathAndName - директория и имя файла
     * @return - возвращает масив
     */
    public static byte[] readFromFileInArray (String pathAndName){
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
