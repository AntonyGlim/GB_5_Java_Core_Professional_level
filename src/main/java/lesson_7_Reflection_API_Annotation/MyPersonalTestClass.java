package lesson_7_Reflection_API_Annotation;

import lesson_7_Reflection_API_Annotation.myAnotation.AfterSuite;
import lesson_7_Reflection_API_Annotation.myAnotation.BeforeSuite;
import lesson_7_Reflection_API_Annotation.myAnotation.MyTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyPersonalTestClass {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        Class myTests1Class = MyTests1.class;
        MyTests1 mt1 = (MyTests1) myTests1Class.newInstance();
        Method[] methods = MyTests1.class.getDeclaredMethods();
        Method beforeSuiteMethod = null;
        Method myTestMethod = null;
        Method afterSuiteMethod = null;
        for (Method o : methods) {
            if(o.getAnnotation(BeforeSuite.class) != null) {
                beforeSuiteMethod = o;
            }
            if(o.getAnnotation(MyTest.class) != null) {
                myTestMethod = o;
            }
            if(o.getAnnotation(AfterSuite.class) != null) {
                afterSuiteMethod = o;
            }
        }
        beforeSuiteMethod.invoke(mt1);
        myTestMethod.invoke(mt1);
        afterSuiteMethod.invoke(mt1);
    }

}
