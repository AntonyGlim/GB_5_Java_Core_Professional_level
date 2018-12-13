package lesson_7_Reflection_API_Annotation;

import lesson_7_Reflection_API_Annotation.myAnotation.AfterSuite;
import lesson_7_Reflection_API_Annotation.myAnotation.BeforeSuite;
import lesson_7_Reflection_API_Annotation.myAnotation.MyTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTests1 {

    static ExampleForMyPersonalTestClass example = new ExampleForMyPersonalTestClass();
    static Class exampleClass = example.getClass();

    public static void main(String[] args) {

        firstOfAll();
        afterAll();

        try {
            myTest1();
        } catch (NoSuchMethodException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }

    }

    @BeforeSuite
    public static void firstOfAll(){
        ExampleForMyPersonalTestClass example = new ExampleForMyPersonalTestClass();
        exampleClass = example.getClass();
    }

    @AfterSuite
    public static void afterAll(){

    }

    /**
     * Метод тестирует метод "plus", который складывает 2 числа
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @MyTest
    public static void myTest1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
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
                System.out.println("Test passed!");
            } else {
                System.err.println("Test failed!");
            }
        }
    }

}
