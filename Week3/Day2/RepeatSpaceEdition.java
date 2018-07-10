import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class RepeatSpaceEdition {

    public static int findRepeat(int[] theArray) {

        // find a number that appears more than once
        int low=1,high=theArray.length-1;
        while(low<high){
            int mid,leftlow,lefthigh,rightlow,righthigh;
            mid=low+((high-low)/2);
            leftlow=low;
            lefthigh=mid;
            rightlow=mid+1;
            righthigh=high;
            int itemsleftrange=0;
            for(int x: theArray){
                if(x<=lefthigh && x>=leftlow) itemsleftrange+=1;
            }
            int distinctleftpossibilities=lefthigh-leftlow+1;
            if(itemsleftrange>distinctleftpossibilities){
                low=leftlow;
                high=lefthigh;
            }
            else{
                low=rightlow;
                high=righthigh;
            }
        }

        return low;
    }


















    // tests

    @Test
    public void justTheRepeatedNumberTest() {
        final int[] numbers = {1, 1};
        final int expected = 1;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void shortArrayTest() {
        final int[] numbers = {1, 2, 3, 2};
        final int expected = 2;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int[] numbers = {1, 2, 5, 5, 5, 5};
        final int expected = 5;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void longArrayTest() {
        final int[] numbers = {4, 1, 4, 8, 3, 2, 7, 6, 5};
        final int expected = 4;
        final int actual = findRepeat(numbers);
        assertEquals(expected, actual);
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
