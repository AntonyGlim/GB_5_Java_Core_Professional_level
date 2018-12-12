package lesson_6_Tests;

import lesson_6_Tests_jUnit_Logging_Log4о.ArrWithFourAndOne;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrWithFourAndOneTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{}, false},
                {new int[]{1, 1, 1, 1, 1, 1, 1}, false},
                {new int[]{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, false},
                {new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, false},
                {new int[]{1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, true},
                {new int[]{1, 4}, true},
                {new int[]{1}, false},
                {new int[]{4}, false},
        });
    }
    private int[] arrStart;
    private boolean expectedResult;

    public ArrWithFourAndOneTest(int[] arrStart, boolean expectedResult) {
        this.arrStart = arrStart;
        this.expectedResult = expectedResult;
    }

    ArrWithFourAndOne arrWithFourAndOne;

    @Before
    public void init() {
        arrWithFourAndOne = new ArrWithFourAndOne();
    }

    @Test
//    @Ignore ("Не работает тест с параметрами")
    public void testWithParam() {
        Assert.assertEquals(expectedResult, arrWithFourAndOne.isFourOrOne(arrStart));
    }
}

//То что написано ниже - соответствует всему коду, который написан выше

//    @Test
//    public void test1() {
//        int[] arr = {};
//        Assert.assertFalse(arrWithFourAndOne.isFourOrOne(arr));
//    }
//    @Test
//    public void test2() {
//        int[] arr = {1, 1, 1, 1, 1, 1, 1};
//        Assert.assertFalse(arrWithFourAndOne.isFourOrOne(arr));
//    }
//    @Test
//    public void test3() {
//        int[] arr = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
//        Assert.assertFalse(arrWithFourAndOne.isFourOrOne(arr));
//    }
//    @Test
//    public void test4() {
//        int[] arr = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
//        Assert.assertFalse(arrWithFourAndOne.isFourOrOne(arr));
//    }
//    @Test
//    public void test5() {
//        int[] arr = {1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
//        Assert.assertTrue(arrWithFourAndOne.isFourOrOne(arr));
//    }
//    @Test
//    public void test6() {
//        int[] arr = {1, 4};
//        Assert.assertTrue(arrWithFourAndOne.isFourOrOne(arr));
//    }
//    @Test
//    public void test7() {
//        int[] arr = {1};
//        Assert.assertFalse(arrWithFourAndOne.isFourOrOne(arr));
//    }
//    @Test
//    public void test8() {
//        int[] arr = {4};
//        Assert.assertFalse(arrWithFourAndOne.isFourOrOne(arr));
//    }

