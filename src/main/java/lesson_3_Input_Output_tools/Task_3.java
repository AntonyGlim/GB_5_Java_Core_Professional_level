//package lesson_3_Input_Output_tools;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Collections;
//
//import static lesson_3_Input_Output_tools.Task_1.printByteArr;
////TODO Для чтения использовать буферы всякие
////TODO Разобраться с кодировкой
////TODO Вынести метод чтения в отдельный метод
////TODO Поработать со структурой файлов в задании
////TODO Засечь время выполнения
////TODO Оптимизировать задания 1 и 2
//public class Task_3 {
//    final static String pathAndName_1 = "src/main/java/lesson_3_Input_Output_tools/vi/01.htm";
//    final static String pathAndName_2 = "src/main/java/lesson_3_Input_Output_tools/vi/02.htm";
//    final static String pathAndName_3 = "src/main/java/lesson_3_Input_Output_tools/vi/03.htm";
//    final static String pathAndName_4 = "src/main/java/lesson_3_Input_Output_tools/vi/04.htm";
//    final static String pathAndName_5 = "src/main/java/lesson_3_Input_Output_tools/vi/05.htm";
//    final static String pathAndName_6 = "src/main/java/lesson_3_Input_Output_tools/vi/06.htm";
//    final static String pathAndName_7 = "src/main/java/lesson_3_Input_Output_tools/vi/07.htm";
//    final static String pathAndName_8 = "src/main/java/lesson_3_Input_Output_tools/vi/08.htm";
//    final static String pathAndName_9 = "src/main/java/lesson_3_Input_Output_tools/vi/09.htm";
//    final static String pathAndName_10 = "src/main/java/lesson_3_Input_Output_tools/vi/10.htm";
//    final static String pathAndName_11 = "src/main/java/lesson_3_Input_Output_tools/vi/result.txt";
//
//    final static int arrSize = 18000;
//
//    public static void main(String[] args) throws IOException {
//
//        ArrayList<InputStream> ali = new ArrayList<InputStream>();
//        try {
//            ali.add(new FileInputStream(pathAndName_1));
//            ali.add(new FileInputStream(pathAndName_2));
//            ali.add(new FileInputStream(pathAndName_3));
//            ali.add(new FileInputStream(pathAndName_4));
//            ali.add(new FileInputStream(pathAndName_5));
//            ali.add(new FileInputStream(pathAndName_6));
//            ali.add(new FileInputStream(pathAndName_7));
//            ali.add(new FileInputStream(pathAndName_8));
//            ali.add(new FileInputStream(pathAndName_9));
//            ali.add(new FileInputStream(pathAndName_10));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        SequenceInputStream sqis = new SequenceInputStream(Collections.enumeration(ali));
//        int x;
//        int count = 0;
//        while ((x = sqis.read()) != -1){
//            System.out.print((char) x);
//            count ++;
//            if (count % 200 == 0 ){
//                System.out.println();
//            }
//        }
//        System.out.println("Всего прочитано байт: " + count);
//        sqis.close();
//
//
//
////        FileInputStream fis = null;
////        try {
////            byte[] secondArr = new byte[arrSize];
////            fis = new FileInputStream(pathAndName);
////            int count = fis.read(secondArr);
////            System.out.println("Размер массива: " + count);
////            printByteArr(secondArr);
////        } catch (FileNotFoundException e) {
////            e.printStackTrace();
////        } catch (IOException e) {
////            e.printStackTrace();
////        } finally {
////            try {
////                fis.close();
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////        }
////    }
//
//    public static void writeInFile (String pathAndName_11){
//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream(pathAndName_11);   //Файл создасться, если до этого не существовал
//            fos.write(byteArr);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
