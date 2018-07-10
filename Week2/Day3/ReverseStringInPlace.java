import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class ReverseStringInPlace {

    public static void reverse(char[] arrayOfChars) {

        // reverse input array of characters in place
        if(arrayOfChars.length <=1) return;
        else{
            for(int i=0,j=arrayOfChars.length-1;i<j;i++,j--){
                char c=arrayOfChars[i];
                arrayOfChars[i]=arrayOfChars[j];
                arrayOfChars[j]=c;
            }
        }

    }


















    // tests

    @Test
    public void emptyStringTest() {
        final char[] expected = "".toCharArray();
        final char[] actual = "".toCharArray();
        reverse(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void singleCharacterStringTest() {
        final char[] expected = "A".toCharArray();
        final char[] actual = "A".toCharArray();
        reverse(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void longerStringTest() {
        final char[] expected = "EDCBA".toCharArray();
        final char[] actual = "ABCDE".toCharArray();
        reverse(actual);
        assertArrayEquals(expected, actual);
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
