package lesson_7_Reflection_API_Annotation;

/**
 * Класс содержит методы, которые необходимо тестировать
 */
public class ExampleForMyPersonalTestClass {

    public ExampleForMyPersonalTestClass(byte b, short s, int a, long l, float f, double d, char ch, boolean bul) {
        this.b = b;
        this.s = s;
        this.a = a;
        this.l = l;
        this.f = f;
        this.d = d;
        this.ch = ch;
        this.bul = bul;
    }

    public ExampleForMyPersonalTestClass() {
    }

    /**
     * Создать переменные всех пройденных типов данных, и инициализировать их значения;
     */
        byte b = 127;
        short s = 45;
        public int a = 125;
        public long l = 5248L;
        public float f = 4568.56f;
        private double d = 457868.5696d;
        private char ch = 'C';
        private boolean bul = true;

//    public float plus (){
//        return (a + b);
//    }
    /**
     * Написать метод, вычисляющий выражение a + b и возвращающий результат,
     * где a, b – входные параметры этого метода;
     */
    public float plus (int a, int b){
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
     * Написать метод, вычисляющий выражение a - b и возвращающий результат,
     * где a, b – входные параметры этого метода;
     */
    static float minus (int a, int b){
        return (a - b);
    }

    /**
     * Написать метод, вычисляющий выражение a / b и возвращающий результат,
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
     */
    static boolean example_3_1(int a, int b){
        if ((a + b) >= 10 && (a + b) <= 20)
            return true;
        else
            return false;
    }

    /**
     * Написать метод, принимающий на вход два числа, и проверяющий,
     * что их сумма лежит в пределах от 30 до 40 (включительно),
     * если да – вернуть true, в противном случае – false;
     */
    static boolean example_3_2(int a, int b){
        if ((a + b) >= 30 && (a + b) <= 40)
            return true;
        else
            return false;
    }

    /**
     * Написать метод, принимающий на вход два числа, и проверяющий,
     * что их сумма лежит в пределах от 50 до 60 (включительно),
     * если да – вернуть true, в противном случае – false;
     */
    static boolean example_3_3(int a, int b){
        if ((a + b) >= 50 && (a + b) <= 60)
            return true;
        else
            return false;
    }

    /**
     * Написать метод, принимающий на вход два числа, и проверяющий,
     * что их сумма лежит в пределах от 70 до 80 (включительно),
     * если да – вернуть true, в противном случае – false;
     */
    static boolean example_3_4(int a, int b){
        if ((a + b) >= 70 && (a + b) <= 80)
            return true;
        else
            return false;
    }

    /**
     * Написать метод, которому в качестве параметра передается целое число,
     * метод должен напечатать в консоль положительное число передали или отрицательное
     * (Замечание: ноль считаем положительным числом.);
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
     */
    static void example_6(String str){
        System.out.println("Привет, " + str + "!");
    }

    /**
     * *Написать метод, который определяет, является ли год високосным,
     * и выводит сообщение в консоль. Каждый 4-й год является високосным,
     * кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    static void example_7(int year){
        if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
            System.out.println("Год высокосный");
        else
            System.out.println("Год не высокосный");
    }

}
