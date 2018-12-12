package lesson_7_Reflection_API_Annotation;

public class ExampleForMyPersonalTestClass {
    /**
     * Создать переменные всех пройденных типов данных, и инициализировать их значения;
     */
    static void example_1 () {
        byte b = 127;
        short s = 45;
        int a = 125;
        long l = 5248L;
        float f = 4568.56f;
        double d = 457868.5696d;
        char ch = 'C';
        boolean bul = true;

        System.out.println(b);
        System.out.println(s);
        System.out.println(a);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(ch);
        System.out.println(bul);
    }

    /**
     * Написать метод, вычисляющий выражение a + b и возвращающий результат,
     * где a, b – входные параметры этого метода;
     */
    static float plus  (int a, int b){
        return (a + b);
    }

    /**
     * Написать метод, вычисляющий выражение a * b и возвращающий результат,
     * где a, b – входные параметры этого метода;
     */
    static float multiply  (int a, int b){
        return (a * b);
    }

    /**
     * Написать метод, вычисляющий выражение a + b и возвращающий результат,
     * где a, b – входные параметры этого метода;
     */
    static float minus (int a, int b){
        return (a - b);
    }

    /**
     * Написать метод, вычисляющий выражение a * b и возвращающий результат,
     * где a, b – входные параметры этого метода;
     */
    static float divide (int a, int b) throws ArithmeticException{
        float res = 0;
        try {
             res = (a / b);
        } catch (ArithmeticException e){
            System.out.println("Деление на ноль!");
        }
        return res;
    }

    /**
     * Написать метод, принимающий на вход два числа, и проверяющий,
     * что их сумма лежит в пределах от 10 до 20 (включительно),
     * если да – вернуть true, в противном случае – false;
     * @param a
     * @param b
     * @return
     */
    static boolean example_3(int a, int b){
        if ((a + b) >= 10 && (a + b) <= 20)
            return true;
        else
            return false;
    }

    /**
     * Написать метод, которому в качестве параметра передается целое число,
     * метод должен напечатать в консоль положительное число передали или отрицательное
     * (Замечание: ноль считаем положительным числом.);
     * @param a
     * @return
     */
    static String example_4(int a){
        if (a >= 0)
            return "Положительное";
        else
            return "Отрицательное";
    }

    /**
     * Написать метод, которому в качестве параметра передается целое число,
     * метод должен вернуть true, если число отрицательное;
     * @param a
     * @return
     */
    static boolean example_5(int a) {
        if (a < 0)
            return true;
        else
            return false;
    }

    /**
     * Написать метод, которому в качестве параметра передается строка, обозначающая имя,
     * метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
     * @param str
     */
    static void example_6(String str){
        System.out.println("Привет, " + str + "!");
    }

    /**
     * *Написать метод, который определяет, является ли год високосным,
     * и выводит сообщение в консоль. Каждый 4-й год является високосным,
     * кроме каждого 100-го, при этом каждый 400-й – високосный.
     * @param year
     */
    static void example_7(int year){
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
            System.out.println("Год высокосный");
        else
            System.out.println("Год не высокосный");
    }

}
