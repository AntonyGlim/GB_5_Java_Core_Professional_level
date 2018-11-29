/**
 * 2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт). Может пригодиться следующая конструкция:
 * ArrayList<InputStream> al = new ArrayList<>(); ... Enumeration<InputStream> e = Collections.enumeration(al);
 */
package lesson_3_Input_Output_tools;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static lesson_3_Input_Output_tools.Task_1.createNewByteArr;
import static lesson_3_Input_Output_tools.Task_1.writeArrInFile;

public class Task_2 {

    private static String[] pathNameslist;
    private static ArrayList<InputStream> ali;
    final static int arrSize = 100;
    final static int filesCount = 5;

    public static void main(String[] args) throws IOException {

        pathNameslist = new String[filesCount];                                                                         //Имена файлов пропишем в отдельный массив, чтобы с ним работать
        byte[] symbols = {'a', 'b', 'c', 'd', 'f'};                                                                     //Чтобы в файлах были записаны разные символы
        for (int i = 0; i < pathNameslist.length; i++) {
            pathNameslist[i] = String.format("src/main/java/lesson_3_Input_Output_tools/Task_2_file_%s.txt", (i + 1));  //Заполняем массив именами и директориями
            writeArrInFile(pathNameslist[i], createNewByteArr(arrSize, symbols[i]));                                    //Пишем в определенные директории массивы с разными байтами, массивы формируем в аргументах метода
        }

        ali = new ArrayList<InputStream>();
        for (int i = 0; i < ali.size(); i++) {
            try {
                ali.add(new FileInputStream(String.format("src/main/java/lesson_3_Input_Output_tools/Task_2_file_%s.txt", (i + 1))));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        SequenceInputStream sqis = new SequenceInputStream(Collections.enumeration(ali));
//        int x;
//        int count = 0;
//        while ((x = sqis.read()) != -1){
//            System.out.print((char) x);
//            count ++;
//            if (count % 100 == 0 ){
//                System.out.println();
//            }
//        }
//        System.out.println("Всего прочитано байт: " + count);
//        sqis.close();
    }
}
