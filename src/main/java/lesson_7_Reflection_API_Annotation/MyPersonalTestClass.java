package lesson_7_Reflection_API_Annotation;

import lesson_7_Reflection_API_Annotation.myAnotation.AfterSuite;
import lesson_7_Reflection_API_Annotation.myAnotation.BeforeSuite;
import lesson_7_Reflection_API_Annotation.myAnotation.MyTest;
import org.apache.log4j.Logger;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MyPersonalTestClass {

    // Инициализация логера
    private static final Logger log = Logger.getLogger(MyPersonalTestClass.class);      //Файл с настройками лежит рябом с файлами с расширением .class

    public static void main(String[] args) {

        try {

            log.info("Старт работы программы");
            startTest();

        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        log.info("Программа завершила работу");
    }

    public static void startTest() throws IllegalAccessException, InstantiationException, InvocationTargetException {

        log.info("Создаем экземпляр класса без ключевого слова new");
        Class myTests1Class = MyTests1.class;
        MyTests1 mt1 = (MyTests1) myTests1Class.newInstance();

        //Эти флаги послужат для последовательного запуска методов класса
        log.info("Инициализация переменных для работы с методами");
        Method beforeSuiteMethod = null;
        Method afterSuiteMethod = null;

        //Эти флаги послужат для определения - единажды-ли встречается метод с определенной анотацией
        log.info("Инициализация переменных для управления логикой");
        boolean isBeforeSuiteMeetsOnce = true;
        boolean isAfterSuiteMeetsOnce = true;

        //Извлекаем все методы,которые содержаться в классе
        log.info("Извлечение методов из класса");
        Method[] methods = MyTests1.class.getDeclaredMethods();
        Method[] onlyTestMethods = new Method[methods.length - 2];
        int count = 0;
        for (Method o : methods) {
            if(o.getAnnotation(BeforeSuite.class) != null) {        //Если соответствует определенной анотации
                if (isBeforeSuiteMeetsOnce){                        //Если еще не встречался
                    beforeSuiteMethod = o;
                    isBeforeSuiteMeetsOnce = false;
                } else {                                            //Иначе выкидываем исключение
                    throw new RuntimeException("Метод с анотацией @BeforeSuite должен быть только один!");
                }
            }
            if(o.getAnnotation(MyTest.class) != null) {
                onlyTestMethods[count] = o;
                count ++;
            }
            if(o.getAnnotation(AfterSuite.class) != null) {
                if (isAfterSuiteMeetsOnce){
                    afterSuiteMethod = o;
                    isAfterSuiteMeetsOnce = false;
                } else {
                    throw new RuntimeException("Метод с анотацией @AfterSuite должен быть только один!");
                }

            }
        }

        //Исполняем указанные методы
        log.info("Старт тестов");
        beforeSuiteMethod.invoke(mt1);
        //TODO сделать, чтобы был не 1 метод, а несколько в массиве,
        //TODO отсортированном по приоритетам

        onlyTestMethods = mySortingArr(onlyTestMethods);
//        System.out.println(onlyTestMethods.length);
//        for (int i = 0; i < onlyTestMethods.length; i++) {
//            onlyTestMethods[i].invoke(mt1);
//            System.out.println(onlyTestMethods[i].getName());
//        }

//            m.invoke(mt1);
        afterSuiteMethod.invoke(mt1);
        log.info("Тесты проведены");
    }


    public static Method[] mySortingArr(Method[] onlyTestMethods){
        Method[] sortedArr = new Method[onlyTestMethods.length];
        ArrayList<Method> list = new ArrayList<Method>();
        for (Method m : onlyTestMethods){
            list.add(m);
        }
        int j = 0;
        while (list.size() > 0) {
            int max = list.get(0).getAnnotation(MyTest.class).priority();
            int index = 0;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).getAnnotation(MyTest.class).priority() > max){
                    max = list.get(i).getAnnotation(MyTest.class).priority();
                    index = i;
                }
            }
            sortedArr[j] = list.remove(index);
            System.out.println(sortedArr[j].getName());
            j++;
        }
        return sortedArr;
    }
}

