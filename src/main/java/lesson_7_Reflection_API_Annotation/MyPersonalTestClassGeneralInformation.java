/**
 * http://www.quizful.net/post/java-reflection-api
 *
 * Создать класс, который может выполнять «тесты». В качестве тестов выступают классы с наборами методов
 * с аннотациями @Test. Для этого у него должен быть статический метод start(), которому в качестве параметра
 * передается или объект типа Class, или имя класса. Из «класса-теста» вначале должен быть запущен метод
 * с аннотацией @BeforeSuite, если такой имеется. Далее запущены методы с аннотациями @Test, а по завершении
 * всех тестов – метод с аннотацией @AfterSuite. К каждому тесту необходимо добавить приоритеты
 * (int числа от 1 до 10), в соответствии с которыми будет выбираться порядок их выполнения.
 * Если приоритет одинаковый, то порядок не имеет значения. Методы с аннотациями @BeforeSuite и @AfterSuite
 * должны присутствовать в единственном экземпляре, иначе необходимо бросить RuntimeException при запуске «тестирования».
 * Это домашнее задание никак не связано с темой тестирования через JUnit и использованием этой библиотеки:
 * проект пишется с нуля.
 */
package lesson_7_Reflection_API_Annotation;

import java.lang.reflect.*;

/**
 * Класс не относиться к ДЗ на прямую, в нем просто собраны методы с коментариями
 */
public class MyPersonalTestClassGeneralInformation {

    public static void MyPersonalTestClassGeneralInformation() throws IllegalAccessException, NoSuchFieldException {

        ExampleForMyPersonalTestClass example = new ExampleForMyPersonalTestClass();

        //Получение объекта типа Class
        Class exampleClass = example.getClass();
        System.out.println("Объект типа Class: " + exampleClass + "\n");

        //Получение имени класса
        System.out.println("Имя класса: " + exampleClass.getName() + "\n");

        //Исследование модификаторов класса
        int mods = exampleClass.getModifiers();

        if (Modifier.isPublic(mods)) {
            System.out.println("Модификаторов класса: " + "public" + "\n");
        }
        if (Modifier.isAbstract(mods)) {
            System.out.println("Модификаторов класса: " + "abstract" + "\n");
        }
        if (Modifier.isFinal(mods)) {
            System.out.println("Модификаторов класса: " + "final" + "\n");
        }

        //Нахождение суперклассов
        System.out.println("Суперкласс: " + exampleClass.getSuperclass() + "\n");

        //Определение интерфейсов, реализуемых классом
        Class[] interfaces = exampleClass.getInterfaces();
        if (interfaces.length < 1){
            System.out.println("Класс не подписан на интерфейсы" + "\n");
        }
        for(Class cInterface : interfaces) {
            System.out.println("Класс подписан на интерфейс: " + cInterface.getName() + "\n");
        }

        //Исследование всех полей класса
        Field[] privateFields = exampleClass.getDeclaredFields();
        System.out.println("В классе есть следующие поля: ");
        for (int i = 0; i < privateFields.length; i++) {
            Class fieldType = privateFields[i].getType();
            System.out.println("Имя: " + privateFields[i].getName());
            System.out.println("Тип: " + fieldType.getName());
            privateFields[i].setAccessible(true);
            System.out.println("Значение: " + privateFields[i].get(example));
            System.out.println();
        }

        //Конструкторы класса
        Constructor[] constructors = exampleClass.getDeclaredConstructors();
        if (constructors.length == 1){
            System.out.println("Класс содержит только конструктор по умолчанию" + "\n");
        }
        for (Constructor constructor : constructors) {
            Class[] paramTypes = constructor.getParameterTypes();
            System.out.println("Конструктор принимает параметры следующих типов: ");
            if (paramTypes.length < 1){
                System.out.println("Конструктор по умолчанию");
            }
            for (Class paramType : paramTypes) {
                System.out.print(paramType.getName() + " ");
            }
            System.out.println();
        }

        //Исследование информации о методе, вызов метода.
        Method[] methods = exampleClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Имя: " + method.getName());
            System.out.println("Возвращаемый тип: " + method.getReturnType().getName());

            Class[] paramTypes = method.getParameterTypes();
            System.out.print("Типы параметров: ");
            for (Class paramType : paramTypes) {
                System.out.print(" " + paramType.getName());
            }
            System.out.println();
        }

        //Использование метода
        try {
            Class[] paramTypes = new Class[] { int.class, int.class };
            Method method = exampleClass.getDeclaredMethod("plus", paramTypes);
            Object[] arr = new Object[] { new Integer(2), new Integer(3) };
            float d = (Float) method.invoke(example, arr);
            System.out.println("\nРезультат работы метода: " + d);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
