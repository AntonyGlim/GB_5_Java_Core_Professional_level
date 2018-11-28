/**
 * 2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт). Может пригодиться следующая конструкция:
 * ArrayList<InputStream> al = new ArrayList<>(); ... Enumeration<InputStream> e = Collections.enumeration(al);
 */
package lesson_3_Input_Output_tools;

import static lesson_3_Input_Output_tools.Task_1.createFileWithBytes;

public class Task_2 {

    final static String pathAndName_1 = "src/main/java/lesson_3_Input_Output_tools/task_1_2/task_2_file_1.txt";
    final static String pathAndName_2 = "src/main/java/lesson_3_Input_Output_tools/task_1_2/task_2_file_2.txt";
    final static String pathAndName_3 = "src/main/java/lesson_3_Input_Output_tools/task_1_2/task_2_file_3.txt";
    final static String pathAndName_4 = "src/main/java/lesson_3_Input_Output_tools/task_1_2/task_2_file_4.txt";
    final static String pathAndName_5 = "src/main/java/lesson_3_Input_Output_tools/task_1_2/task_2_file_5.txt";
    final static int arrSize = 100;

    public static void main(String[] args) {
        createFileWithBytes(pathAndName_1, arrSize);
        createFileWithBytes(pathAndName_2, arrSize);
        createFileWithBytes(pathAndName_3, arrSize);
        createFileWithBytes(pathAndName_4, arrSize);
        createFileWithBytes(pathAndName_5, arrSize);
    }
}
