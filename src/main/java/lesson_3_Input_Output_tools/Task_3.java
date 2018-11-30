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

    final static String pathAndName = "src/main/java/lesson_3_Input_Output_tools/Task_3_King.txt";
    final static int symbolsOnPage = 1800;

    public static void main(String[] args) throws IOException {

        InputStream in = new BufferedInputStream(new FileInputStream(pathAndName));

        int x;
        int count = 1;
        char[] chars = new char[symbolsOnPage];
        ArrayList<String> list = new ArrayList<String>();

        while((x = in.read()) != -1) {
            chars[count - 1] = (char) x;
            if (count == symbolsOnPage){
                list.add(String.valueOf(chars));
                count = 1;
            } else {
                count++;
            }
        }
        list.add(String.valueOf(chars));
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
        in.close();

        System.out.println(list.size());
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println(list.get(0));
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println(list.get(list.size() - 1));
    }

}
