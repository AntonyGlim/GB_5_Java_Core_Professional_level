/**
 * 3. Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
 * Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль.
 * Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.
 */
package lesson_3_Input_Output_tools;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Scanner scanner = new Scanner(System.in);

        while((x = in.read()) != -1) {
            chars[count - 1] = (char) x;
            if (count == symbolsOnPage){
                list.add(String.valueOf(chars));
                count = 1;
            } else {
                count++;
            }
        }
        char[] ch = new char[count - 1];
        for (int i = 0; i < ch.length; i++) {
            ch[i] = chars[i];
        }
        list.add(String.valueOf(ch));

        System.out.println("В файле всего: " + list.size() + " страниц.");
        in.close();

        while (true){
            System.out.println("Введите номер страницы: (Номер должен быть числом)");
            String s = scanner.nextLine();
            if (s.equalsIgnoreCase("/q")){                                                          //Ветка для выхода из программы
                break;
            }
            if (isValidNumber(s)){
                int pageNumber = Integer.parseInt(s);
                if (pageNumber <= list.size() && pageNumber != 0){
                    System.out.println("PAGE " + pageNumber + " START:");
                    System.out.println(list.get(pageNumber - 1));
                    System.out.println("** PAGE " + pageNumber + " END **");
                } else {
                    System.out.println("Такой страницы нет!");
                }
            } else {
                System.out.println("Введенное значение должно быть числом");
            }
        }
    }

    /**
     * Метод проверит, является-ли строка введенная пользователем положительным числом
     * @param str
     * @return
     */
    private static boolean isValidNumber(String str){
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(str);
        return m.matches();
    }

}
