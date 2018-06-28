import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

  public static int highestProduct3(int[] iArray) {

    if (iArray.length < 3) {
        throw new IllegalArgumentException("Array length cannot be less than 3");
    }

    
    int big = Math.max(iArray[0], iArray[1]);
    int small  = Math.min(iArray[0], iArray[1]);

    int highestP2 = iArray[0] * iArray[1];
    int lowestP2  = iArray[0] * iArray[1];

    int highestP3 = iArray[0] * iArray[1] * iArray[2];

    
    for (int i = 2; i < iArray.length; i++) {
        int current = iArray[i];

       
        highestP3 = Math.max(Math.max(highestP3,current * highestP2),current * lowestP2);
        highestP2 = Math.max(Math.max(highestP2,current * big),current * small);

        lowestP2 = Math.min(Math.min(lowestP2,
            current * big),
            current * small);

        big = Math.max(big, current);
        small = Math.min(small, current);
    }

    return highestP3;
}



















    // tests

    @Test
    public void shortArrayTest() {
        final int actual = highestProductOf3(new int[] {1, 2, 3, 4});
        final int expected = 24;
        assertEquals(expected, actual);
    }

    @Test
    public void longerArrayTest() {
        final int actual = highestProductOf3(new int[] {6, 1, 3, 5, 7, 8, 2});
        final int expected = 336;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasOneNegativeTest() {
        final int actual = highestProductOf3(new int[] {-5, 4, 8, 2, 3});
        final int expected = 96;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasTwoNegativesTest() {
        final int actual = highestProductOf3(new int[] {-10, 1, 3, 2, -10});
        final int expected = 300;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayIsAllNegativesTest() {
        final int actual = highestProductOf3(new int[] {-5, -1, -3, -2});
        final int expected = -6;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyArrayTest() {
        highestProductOf3(new int[] {});
    }

    @Test(expected = Exception.class)
    public void exceptionWithOneNumberTest() {
        highestProductOf3(new int[] {1});
    }

    @Test(expected = Exception.class)
    public void exceptionWithTwoNumbersTest() {
        highestProductOf3(new int[] {1, 1});
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
}