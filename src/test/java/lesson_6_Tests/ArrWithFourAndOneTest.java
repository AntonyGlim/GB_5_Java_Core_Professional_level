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

//@RunWith(Parameterized.class)
public class ArrWithFourAndOneTest {
//
//    @Parameterized.Parameters
//    public static Collection<Object[]> data() {
//        return Arrays.asList(new Object[][]{
//                {0, 0, 0},
//                {1, 1, 2},
//                {2, 2, 4},
//                {5, 5, 10},
//                {4, 2, 6},
//                {1, 3, 4},
//                {6, -2, 4},
//                {-1, 5, 4},
//        });
//    }

    private int[] a;
    private int[] b;

    public ArrWithFourAndOneTest(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }

    ArrWithFourAndOne arrWithFourAndOne;

    @Before
    public void init() {
        arrWithFourAndOne = new ArrWithFourAndOne();
    }

    @Test
    @Ignore
    public void test1() {
        int[] arr = {};
        Assert.assertFalse(arrWithFourAndOne.isFourOrOne(arr));
    }
    @Test
    @Ignore
    public void test2() {
        int[] arr = {1, 1, 1, 1, 1, 1, 1};
        Assert.assertFalse(arrWithFourAndOne.isFourOrOne(arr));
    }
    @Test
    @Ignore
    public void test3() {
        int[] arr = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        Assert.assertFalse(arrWithFourAndOne.isFourOrOne(arr));
    }
    @Test
    @Ignore
    public void test4() {
        int[] arr = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        Assert.assertFalse(arrWithFourAndOne.isFourOrOne(arr));
    }
    @Test
    @Ignore
    public void test5() {
        int[] arr = {1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        Assert.assertTrue(arrWithFourAndOne.isFourOrOne(arr));
    }
    @Test
    @Ignore
    public void test6() {
        int[] arr = {1, 4};
        Assert.assertTrue(arrWithFourAndOne.isFourOrOne(arr));
    }
    @Test
    @Ignore
    public void test7() {
        int[] arr = {1};
        Assert.assertFalse(arrWithFourAndOne.isFourOrOne(arr));
    }
    @Test
    @Ignore
    public void test8() {
        int[] arr = {4};
        Assert.assertFalse(arrWithFourAndOne.isFourOrOne(arr));
    }
}
