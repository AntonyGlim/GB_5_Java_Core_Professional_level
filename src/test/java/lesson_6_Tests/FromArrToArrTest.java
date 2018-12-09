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
//    @Ignore
    public void testFromArrToArr() {
        int[] arrStart = {1, 4, 3, 4, 5};
        int[] expectedResult = {3, 4, 5};
        Assert.assertArrayEquals(expectedResult, fromArrToArr.arrStrtsAfterFour(arrStart));
    }

    @Test(expected = RuntimeException.class)
//    @Ignore ("исключение пока тестировать не нужно")
    public void testFromArrToArrException(){
        int[] arrStart = {1, 2, 3, 3, 5};
        fromArrToArr.arrStrtsAfterFour(arrStart);
    }
}
