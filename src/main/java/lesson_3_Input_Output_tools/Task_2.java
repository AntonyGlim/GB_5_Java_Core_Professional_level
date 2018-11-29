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

    private static ArrayList<String> pathNameslist;
    final static int arrSize = 100;

    public static void main(String[] args) throws IOException {

        pathNameslist = new ArrayList<String>();
        pathNameslist.add("src/main/java/lesson_3_Input_Output_tools/Task_2_file_1.txt");
        pathNameslist.add("src/main/java/lesson_3_Input_Output_tools/Task_2_file_2.txt");
        pathNameslist.add("src/main/java/lesson_3_Input_Output_tools/Task_2_file_3.txt");
        pathNameslist.add("src/main/java/lesson_3_Input_Output_tools/Task_2_file_4.txt");
        pathNameslist.add("src/main/java/lesson_3_Input_Output_tools/Task_2_file_5.txt");

        byte[] sumbols = {'a', 'b', 'c', 'd', 'f'};
        for (int i = 0; i < pathNameslist.size(); i++) {
            byte[] byteArr = createNewByteArr(arrSize, (byte) 'g');
            writeArrInFile(pathNameslist.get(i), byteArr);
        }
        ArrayList<InputStream> ali = new ArrayList<InputStream>();
        try {
            ali.add(new FileInputStream(pathAndName_1));
            ali.add(new FileInputStream(pathAndName_2));
            ali.add(new FileInputStream(pathAndName_3));
            ali.add(new FileInputStream(pathAndName_4));
            ali.add(new FileInputStream(pathAndName_5));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        SequenceInputStream sqis = new SequenceInputStream(Collections.enumeration(ali));
        int x;
        int count = 0;
        while ((x = sqis.read()) != -1){
            System.out.print((char) x);
            count ++;
            if (count % 100 == 0 ){
                System.out.println();
            }
        }
        System.out.println("Всего прочитано байт: " + count);
        sqis.close();
    }
}
