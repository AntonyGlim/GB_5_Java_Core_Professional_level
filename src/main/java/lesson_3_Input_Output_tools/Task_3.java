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

public class Task_3 {

//    final static String pathAndName = "src/main/java/lesson_3_Input_Output_tools/Task_3_voina-i-mir.txt";
//    final static String pathAndName = "src/main/java/lesson_3_Input_Output_tools/Task_3_voina-i-mir111.txt";
//    final static String pathAndName = "src/main/java/lesson_3_Input_Output_tools/Task_3_voina-i-mir222.txt";
    final static String pathAndName = "src/main/java/lesson_3_Input_Output_tools/Task_3_King.txt";
    final static int symbolsOnPage = 1800;

    public static void main(String[] args) throws IOException {

        FileInputStream in = new FileInputStream(pathAndName);
        int x;
        int count = 1;
        char[] chars = new char[symbolsOnPage];
        ArrayList<String> list = new ArrayList<String>();

        while((x = in.read()) != -1) {
            chars[count - 1] = (char) x;
            if (count == symbolsOnPage){
                list.add( String.valueOf(chars));
                count = 1;
            } else {
                count++;
            }

        }

        System.out.println(list.size());
        

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
