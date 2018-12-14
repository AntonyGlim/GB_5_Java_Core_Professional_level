package lesson_7_Reflection_API_Annotation;

import lesson_7_Reflection_API_Annotation.myAnotation.AfterSuite;
import lesson_7_Reflection_API_Annotation.myAnotation.BeforeSuite;
import lesson_7_Reflection_API_Annotation.myAnotation.MyTest;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Класс запускает класс с тестами myTests1 дляя класса ExampleForMyPersonalTestClass,
 * который содержит простые методы
 */
public class MyPersonalTestClass {

    // Инициализация логера
    private static final Logger log = Logger.getLogger(MyPersonalTestClass.class);      //Файл с логом лежит в файле log4j.properties

    public static void main(String[] args) {

        try {

            log.info("Старт работы программы");

            startTest();                                        //Запускаем тест

        } catch (InvocationTargetException e) {
            e.printStackTrace();
            log.error(e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            log.error(e);
        } catch (InstantiationException e) {
            e.printStackTrace();
            log.error(e);
        }

        log.info("Программа завершила работу");
    }

    /**
     * В методе реализована вся логика работы программы.
     * Метод подключается к классу myTests1, и запускает его методы, которые, в свою очередь,
     * запускают методы класса ExampleForMyPersonalTestClass и тестируют их.
     * Определенное количество событий пишется в лог.
     */
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
        //И отделяем одни методы от других по аннотации
        log.info("Извлечение методов из класса");
        Method[] methods = MyTests1.class.getDeclaredMethods();
        Method[] onlyTestMethods = new Method[methods.length - 2];  //TODO - слабое место, если @BeforeSuite или @AfterSuite будет больше чем по одному - то здесь возникнет ошибка. Пока пропускаю
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
            if(o.getAnnotation(MyTest.class) != null) {             //Все методы с аннотацией MyTest складываем в отдельный массив
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

        log.info("Старт тестов");

        beforeSuiteMethod.invoke(mt1);                                      //Запускаем первый метод
        onlyTestMethods = mySortingArr(onlyTestMethods);                    //Сортируем массив по приоритетам
        for (int i = 0; i < onlyTestMethods.length; i++) {                  //Запускаем тесты
            onlyTestMethods[i].invoke(mt1);
        }
        afterSuiteMethod.invoke(mt1);                                       //Запускаем последний метод

        log.info("Тесты проведены");
    }

    /**
     * Сортировка массива методов по значениям приоритетов
     * @param onlyTestMethods
     * @return
     */
    public static Method[] mySortingArr(Method[] onlyTestMethods){
        Method[] sortedArr = new Method[onlyTestMethods.length];                    //Новый пустой массив
        ArrayList<Method> list = new ArrayList<Method>();                                   //Переписываем массив в лист, чтобы удалять из него элементы
        for (Method m : onlyTestMethods){
            list.add(m);
        }
        int j = 0;
        while (list.size() > 0) {                                                   //Пока в листе есть элементы
            int max = list.get(0).getAnnotation(MyTest.class).priority();           //Всегда считаем первый элемент максимальным приоритетом
            int index = 0;                                                          //Обнуляем индекс максимального элемента
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).getAnnotation(MyTest.class).priority() > max){
                    max = list.get(i).getAnnotation(MyTest.class).priority();
                    index = i;
                }
            }
            sortedArr[j] = list.remove(index);                                      //Удаляем элемент из таблицы
            j++;
        }
        return sortedArr;
    }
}

