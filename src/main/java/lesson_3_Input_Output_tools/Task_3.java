/**
 * 3. Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
 * Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль.
 * Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.
 */
package lesson_3_Input_Output_tools;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import static lesson_3_Input_Output_tools.Task_1.printByteArr;
import static lesson_3_Input_Output_tools.Task_1.readFromFileInArray;

//TODO Для чтения использовать буферы всякие
//TODO Разобраться с кодировкой
//TODO Вынести метод чтения в отдельный метод
//TODO Поработать со структурой файлов в задании
//TODO Засечь время выполнения
//TODO Оптимизировать задания 1 и 2
public class Task_3 {

//    final static String pathAndName = "src/main/java/lesson_3_Input_Output_tools/Task_3_voina-i-mir.txt";
    final static String pathAndName = "src/main/java/lesson_3_Input_Output_tools/Task_3_voina-i-mir111.txt";
//    final static String pathAndName = "src/main/java/lesson_3_Input_Output_tools/Task_3_voina-i-mir222.txt";
    final static int symbolsOnPage = 1800;

    public static void main(String[] args) {
        ArrayList<byte[]> pagesList = new ArrayList<byte[]>();
        try {
//            InputStream in = new BufferedInputStream(new FileInputStream(pathAndName));
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(pathAndName), "UTF-8"));
            int count = 1;
            byte[] byteArr = new byte[symbolsOnPage];
            while (in.read() != -1){
                byteArr[count - 1] = (byte) in.read();
                if (count == symbolsOnPage){
                    pagesList.add(byteArr);
                    count = 1;
                } else {
                    count++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(pagesList.size());
//        printByteArr(pagesList.get(1));
        ArrayList<byte[]> newList = readFromFileInArrayList(pathAndName);
        printByteArr(newList.get(0));
    }



    public static ArrayList<byte[]> readFromFileInArrayList (String pathAndName){
        FileInputStream fis = null;
        byte[] arr = new byte[symbolsOnPage];
        ArrayList<byte[]> list = new ArrayList<byte[]>();
        try {

            fis = new FileInputStream(pathAndName);
            StringBuilder stringBuilder = new StringBuilder();
            while (fis.read() != -1){
                int count = fis.read(arr);
                if(count == symbolsOnPage){
                    count = 0;
                    list.add(arr);
                }
            }
//            int count = fis.read(arr);
//            System.out.println("Размер массива: " + count);

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
        return list;
    }

    public static void printByteArr (byte[] arr){
        System.out.println("Выведем массив: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print((char) arr[i]);
        }
    }

}
