import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.lang.*;
import static org.junit.Assert.*;

public class Solution {

    public static int findRotationPoint(String[] words) {

        // find the rotation point in the array
       int length = words.length;
       int first = 0;
       int last = length-1;
       int mid = first + (last-first)/2;
       return binarySearch(words, first, last, mid);
    }
    
    public static int binarySearch(String [] words, int first, int last, int mid){
        if (first >= last)
            return mid;
        if (words[mid].compareTo(words[last]) > 0){
            first = mid+1;
            mid = first + (last-first)/2;
            return binarySearch(words, first, last, mid);
        }
        if (words[mid].compareTo(words[first]) < 0){
            last = mid;
            mid = first + (last-first)/2;
            return binarySearch(words, first, last, mid);
        }
        throw new IllegalArgumentException();
            
    }


















    // tests

    @Test
    public void smallArrayTest() {
        final int actual = findRotationPoint(new String[] {"cape", "cake"});
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int actual = findRotationPoint(new String[] {"grape", "orange", "plum",
            "radish", "apple"});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void largeArrayTest() {
        final int actual = findRotationPoint(
            new String[] {"ptolemaic", "retrograde", "supplant", "undulate", "xenoepist",
            "asymptote", "babka", "banoffee", "engender", "karpatka", "othellolagkage"});
        final int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void possiblyMissingEdgeCaseTest() {
        // are we missing any edge cases?
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