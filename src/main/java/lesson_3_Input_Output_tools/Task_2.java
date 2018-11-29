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
import static lesson_3_Input_Output_tools.Task_1.readFromFileInArray;
import static lesson_3_Input_Output_tools.Task_1.writeArrInFile;

public class Task_2 {

    private static String[] pathNameslist;
    private static ArrayList<InputStream> ali;
    final static int arrSize = 100;
    final static int filesCount = 5;

    public static void main(String[] args) throws IOException {

    //Создание файлов и заполнение их бфйтами
        pathNameslist = new String[filesCount];                                                                         //Имена файлов пропишем в отдельный массив, чтобы с ним работать
        byte[] symbols = {'1', '2', '3', '4', '5'};                                                                     //Чтобы в файлах были записаны разные символы
        for (int i = 0; i < pathNameslist.length; i++) {
            pathNameslist[i] = returnDirectoryAndName(i + 1);                                                           //Заполняем массив именами и директориями
            writeArrInFile(pathNameslist[i], createNewByteArr(arrSize, symbols[i]));                                    //Пишем в определенные директории массивы с разными байтами, массивы формируем в аргументах метода
        }

    //Создаем и заполняем лист с потоками для чтения в SequenceInputStream
        ali = new ArrayList<InputStream>();
        for (int i = 0; i < filesCount; i++) {
            try {
                ali.add(new FileInputStream(returnDirectoryAndName(i + 1)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    //Читаем последовательно файлы и пишем их в единый файл (для контроля выводим в консоль)
        SequenceInputStream sqis = new SequenceInputStream(Collections.enumeration(ali));
        int x;
        int count = 0;
        FileOutputStream fos = new FileOutputStream(returnDirectoryAndName(1000));
        while ((x = sqis.read()) != -1){
            fos.write(x);
            System.out.print((char) x);
            count ++;
            if (count % 100 == 0 ){
                fos.write('\n');
                System.out.println();
            }
        }
        System.out.println("Всего прочитано байт: " + count);
        sqis.close();
    }

    /**
     *
     * @param serialNumber
     * @return
     */
    public static String returnDirectoryAndName(int serialNumber){
        String str = String.format("src/main/java/lesson_3_Input_Output_tools/Task_2_file_%s.txt", serialNumber);
        return str;
    }
}
