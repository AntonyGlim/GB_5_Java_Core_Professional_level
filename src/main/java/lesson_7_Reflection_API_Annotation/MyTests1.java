package lesson_7_Reflection_API_Annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTests1 {

    static Class exampleClass;

    public static void main(String[] args) {
        firstOfAll();
        afterAll();
        try {
            myTest1(2,3);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

//    @BeforeSuite
    public static void firstOfAll(){
        ExampleForMyPersonalTestClass example = new ExampleForMyPersonalTestClass();
        exampleClass = example.getClass();
    }

//    @AfterSuite
    public static void afterAll(){

    }
//    @MyTest
    public static void myTest1(int a, int b) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class[] paramTypes = new Class[] { int.class, int.class };
        Method method = exampleClass.getDeclaredMethod("plus", paramTypes);
        Object[] args = new Object[] { new String("plus"), new Integer(a), new Integer(b) };
        float d = (Float) method.invoke(exampleClass, args);
    }

}
