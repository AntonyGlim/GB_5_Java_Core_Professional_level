package lesson_7_Reflection_API_Annotation;

import lesson_7_Reflection_API_Annotation.myAnotation.AfterSuite;
import lesson_7_Reflection_API_Annotation.myAnotation.BeforeSuite;
import lesson_7_Reflection_API_Annotation.myAnotation.MyTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyPersonalTestClass {


    public static void main(String[] args) {

        try {
            startTest();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static void startTest() throws IllegalAccessException, InstantiationException, InvocationTargetException {

        //Создаем экземпляр класса без ключевого слова new
        Class myTests1Class = MyTests1.class;
        MyTests1 mt1 = (MyTests1) myTests1Class.newInstance();

        //Эти флаги послужат для последовательного запуска методов класса
        Method beforeSuiteMethod = null;
        Method myTestMethod = null;
        Method afterSuiteMethod = null;

        //Эти флаги послужат для определения - единажды-ли встречается метод с определенной анотацией
        boolean isBeforeSuiteMeetsOnce = true;
        boolean isAfterSuiteMeetsOnce = true;

        //Извлекаем все методы,которые содержаться в классе
        Method[] methods = MyTests1.class.getDeclaredMethods();
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
                myTestMethod = o;
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
        beforeSuiteMethod.invoke(mt1);
        //TODO сделать, чтобы был не 1 метод, а несколько в массиве,
        //TODO отсортированном по приоритетам
        myTestMethod.invoke(mt1);
        afterSuiteMethod.invoke(mt1);
    }

}
