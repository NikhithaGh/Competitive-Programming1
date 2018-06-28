/*import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;*/
import java.util.*;

public class Solution {

 public static int[] getProductsOfAllIntsExceptAtIndex(int[] iArray) {

    if (iArray.length < 2) {
        throw new IllegalArgumentException("minimum length of the array should be 2");
    }

    int[] arr2 = new int[iArray.length];

    int psf = 1;// psf = product sofar
    for (int i = 0; i < iArray.length; i++) {
        arr2[i] = psf;
        psf *= iArray[i];
    }

    psf = 1;
    for (int i = iArray.length - 1; i >= 0; i--) {
        arr2[i] *= psf;
        psf *= iArray[i];
    }

    return arr2;
    
 }
 public static void main(String[] args) {
  System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(new int[] {1, 2, 3})));
  System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(new int[] {8, 2, 4, 3, 1, 5})));
  System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(new int[] {6, 2, 0, 3})));
  System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(new int[] {4, 0, 9, 1, 0})));
  System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(new int[] {-7, -1, -4, -2})));

 }
}




    

    /*@Test
    public void TesingWithSmallArray() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {1, 2, 3});
        final int[] expected = new int[] {6, 3, 2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void TestingWithLargeArray() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {8, 2, 4, 3, 1, 5});
        final int[] expected = new int[] {120, 480, 240, 320, 960, 192};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void arrayHasOneZeroTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {6, 2, 0, 3});
        final int[] expected = new int[] {0, 0, 36, 0};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void arrayHasTwoZerosTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {4, 0, 9, 1, 0});
        final int[] expected = new int[] {0, 0, 0, 0, 0};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneNegativeNumberTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {-3, 8, 4});
        final int[] expected = new int[] {32, -12, -24};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void allNegativeNumbersTest() {
        final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {-7, -1, -4, -2});
        final int[] expected = new int[] {-8, -56, -14, -28};
        assertArrayEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyArrayTest() {
        getProductsOfAllIntsExceptAtIndex(new int[] {});
    }

    @Test(expected = Exception.class)
    public void exceptionWithOneNumberTest() {
        getProductsOfAllIntsExceptAtIndex(new int[] {1});
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}*/