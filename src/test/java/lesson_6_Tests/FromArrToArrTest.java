package lesson_6_Tests;

import lesson_6_Tests_jUnit_Logging_Log4о.FromArrToArr;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

//TODO не реализован праметризованый ввод 2 массивов. Вопрос Артему.
@RunWith(Parameterized.class)
public class FromArrToArrTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 4, 3, 4, 5}, new int[]{3, 4, 5}},
                {new int[]{1, 0, 3, 4, 5}, new int[]{5}},
                {new int[]{1, 2, 3, 2, 5, 10, 12, 4}, new int[]{}},
                {new int[]{4, 7, 3, 4, 5}, new int[]{7, 3, 4, 5}},
                {new int[]{1, 2, 3, 4, 5}, new int[]{5}},
                {new int[]{1, 2, 3, 3, 5}, new int[]{}}
        });
    }
    private int[] arrStart;
    private int[] expectedResult;

    public FromArrToArrTest(int[] arrStart, int[] expectedResult) {
        this.arrStart = arrStart;
        this.expectedResult = expectedResult;
    }

    private FromArrToArr fromArrToArr;

    //Все, что создадим здесь, будет выполняться перед запуском каждого теста
    @Before
    public void startFromArrToArrTest(){
        fromArrToArr = new FromArrToArr();
    }

    @Test
    public void testFromArrToArr0() throws RuntimeException {
        try {                                                                                       //При помощи try/catch мы проведем наши тесты с исключениями
            Assert.assertArrayEquals(expectedResult, fromArrToArr.arrStrtsAfterFour(arrStart));
        } catch (RuntimeException e){
            System.out.println("В массиве нет числа 4!");
        }

    }
}


//    @Test
//    public void testFromArrToArr1() {
//        int[] arrStart = {1, 4, 3, 4, 5};
//        int[] expectedResult = {3, 4, 5};
//        Assert.assertArrayEquals(expectedResult, fromArrToArr.arrStrtsAfterFour(arrStart));
//    }
//    @Test
//    public void testFromArrToArr2() {
//        int[] arrStart = {1, 0, 3, 4, 5};
//        int[] expectedResult = {5};
//        Assert.assertArrayEquals(expectedResult, fromArrToArr.arrStrtsAfterFour(arrStart));
//    }
//    @Test
//    public void testFromArrToArr3() {
//        int[] arrStart = {1, 2, 3, 2, 5, 10, 12, 4};
//        int[] expectedResult = {};
//        Assert.assertArrayEquals(expectedResult, fromArrToArr.arrStrtsAfterFour(arrStart));
//    }
//    @Test
//    public void testFromArrToArr4() {
//        int[] arrStart = {4, 7, 3, 4, 5};
//        int[] expectedResult = {7, 3, 4, 5};
//        Assert.assertArrayEquals(expectedResult, fromArrToArr.arrStrtsAfterFour(arrStart));
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void testFromArrToArrException1(){
//        int[] arrStart = {1, 2, 3, 3, 5};
//        fromArrToArr.arrStrtsAfterFour(arrStart);
//    }

