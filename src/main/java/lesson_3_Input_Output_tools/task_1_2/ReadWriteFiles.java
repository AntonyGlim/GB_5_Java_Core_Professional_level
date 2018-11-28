/**
 * 1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
 * 2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт). Может пригодиться следующая конструкция:
 * ArrayList<InputStream> al = new ArrayList<>(); ... Enumeration<InputStream> e = Collections.enumeration(al);
 */
package lesson_3_Input_Output_tools.task_1_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadWriteFiles {
    public static void main(String[] args) {
        byte[] byteArr = createNewByteArr(50);
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("src/main/java/lesson_3_Input_Output_tools/task_1_2/task_1_file.txt");   //Файл создасться, если до этого не существовал
            fos.write(byteArr);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
        for (int i = 0; i < arr.length; i++) {
            if (i % 10 == 0){
                System.out.println();
            }
            System.out.print(arr[i] + " ");
        }
    }
}
