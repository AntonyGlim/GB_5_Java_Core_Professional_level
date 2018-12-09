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

//@RunWith(Parameterized.class)
public class FromArrToArrTest {
//
//    @Parameterized.Parameters
//    public static Collection<Object[][]> data() {
//        return Arrays.asList(new Object[][][]{
//                {{1, 2, 3, 4, 5}, {5}}
//        });
//    }
//    private int[] arrStart;
//    private int[] expectedResult;
//
//    public FromArrToArrTest(int[] arrStart, int[] expectedResult) {
//        this.arrStart = arrStart;
//        this.expectedResult = expectedResult;
//    }

    private FromArrToArr fromArrToArr;

    @Before
    public void startFromArrToArrTest(){
        fromArrToArr = new FromArrToArr();
    }

    @Test
    public void testFromArrToArr1() {
        int[] arrStart = {1, 4, 3, 4, 5};
        int[] expectedResult = {3, 4, 5};
        Assert.assertArrayEquals(expectedResult, fromArrToArr.arrStrtsAfterFour(arrStart));
    }
    @Test
    public void testFromArrToArr2() {
        int[] arrStart = {1, 0, 3, 4, 5};
        int[] expectedResult = {5};
        Assert.assertArrayEquals(expectedResult, fromArrToArr.arrStrtsAfterFour(arrStart));
    }
    @Test
    public void testFromArrToArr3() {
        int[] arrStart = {1, 2, 3, 2, 5, 10, 12, 4};
        int[] expectedResult = {};
        Assert.assertArrayEquals(expectedResult, fromArrToArr.arrStrtsAfterFour(arrStart));
    }
    @Test
    public void testFromArrToArr4() {
        int[] arrStart = {4, 7, 3, 4, 5};
        int[] expectedResult = {7, 3, 4, 5};
        Assert.assertArrayEquals(expectedResult, fromArrToArr.arrStrtsAfterFour(arrStart));
    }

    @Test(expected = RuntimeException.class)
    public void testFromArrToArrException1(){
        int[] arrStart = {1, 2, 3, 3, 5};
        fromArrToArr.arrStrtsAfterFour(arrStart);
    }
}
