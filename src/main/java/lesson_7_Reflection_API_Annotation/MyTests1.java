package lesson_7_Reflection_API_Annotation;

import lesson_7_Reflection_API_Annotation.myAnotation.AfterSuite;
import lesson_7_Reflection_API_Annotation.myAnotation.BeforeSuite;
import lesson_7_Reflection_API_Annotation.myAnotation.MyTest;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTests1 {

    private static final Logger log = Logger.getLogger(MyTests1.class);

    @BeforeSuite
    public void firstOfAll(){
        log.info("Отработал метод с аннотацией @BeforeSuite");
        System.out.println("Класс \"MyTests1\" тестирует метод \"plus\", который складывает 2 числа");
    }

    @AfterSuite
    public void afterAll(){
        log.info("Отработал метод с аннотацией @AfterSuite");
        System.out.println("Тестирование завершено!");
    }

    /**
     * Метод тестирует метод "plus", который складывает 2 числа
     */
    @MyTest(priority = 2)
    public void myTest1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        log.info("Начал выполнение тест");
        ExampleForMyPersonalTestClass example = new ExampleForMyPersonalTestClass();
        Class exampleClass = example.getClass();
        Class[] paramTypes = new Class[] { int.class, int.class };
        Method method = exampleClass.getDeclaredMethod("plus", paramTypes);
        System.out.println("Тестирование метода : \"" + method.getName() + "\"");
        int a;
        int b;
        float result;
        for (int i = 0; i < 10; i++) {
            a = (int) Math.random() * 100;
            b = (int) Math.random() * 100;
            result = a + b;
            float d = (Float) method.invoke(example, a, b);
            if (Math.abs(d - result) < 0.000000001){
                log.info("Тест успешно пройден!");
                System.out.println("MyTest1 passed!");
            } else {
                log.error("Тест провален!");
                System.err.println("MyTest1 failed!");
            }
        }
    }

    /**
     * Метод тестирует метод "minus", который вычитает 2 числа
     */
    @MyTest(priority = 8)
    public void myTest2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ExampleForMyPersonalTestClass example = new ExampleForMyPersonalTestClass();
        Class exampleClass = example.getClass();
        Class[] paramTypes = new Class[] { int.class, int.class };
        Method method = exampleClass.getDeclaredMethod("minus", paramTypes);
        System.out.println("Тестирование метода : \"" + method.getName() + "\"");
        int a;
        int b;
        float result;
        for (int i = 0; i < 10; i++) {
            a = (int) Math.random() * 100;
            b = (int) Math.random() * 100;
            result = a - b;
            float d = (Float) method.invoke(example, a, b);
            if (Math.abs(d - result) < 0.000000001){
                System.out.println("MyTest2 passed!");
            } else {
                System.err.println("MyTest2 failed!");
            }
        }
    }

    /**
     * Тест создан, чтобы проверить корректность работы сортировки по значению приоритета
     */
    @MyTest(priority = 9)
    public void myTest3(){
        System.out.println("Тестирование метода : \"" + "myTest3" + "\"");
        System.out.println("MyTest3 passed!");
    }

    /**
     * Тест создан, чтобы проверить корректность работы сортировки по значению приоритета
     */
    @MyTest(priority = 9)
    public void myTest4(){
        System.out.println("Тестирование метода : \"" + "myTest4" + "\"");
        System.out.println("MyTest4 passed!");
    }

    /**
     * Тест создан, чтобы проверить корректность работы сортировки по значению приоритета
     */
    @MyTest(priority = 4)
    public void myTest5(){
        System.out.println("Тестирование метода : \"" + "myTest5" + "\"");
        System.out.println("MyTest5 passed!");
    }

}
