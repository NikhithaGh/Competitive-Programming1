import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;
import java.util.*;

public class PermutationPalindrome {

    public static boolean hasPalindromePermutation(String theString) {

        // check if any permutation of the input is a palindrome
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<theString.length();i++){
            if(hm.containsKey(theString.charAt(i))) hm.put(theString.charAt(i),hm.get(theString.charAt(i))+1);
            else hm.put(theString.charAt(i),1);
        }
        int sum=0;
        for(int x:hm.values()){
           sum+=x%2; 
        }
        //System.out.println(sum);
        if(theString.length() % 2 ==0 && sum==0) return true;
        else if(theString.length()%2 ==1 && sum==1) return true;
        return false;
    }


















    // tests

    @Test
    public void permutationWithOddNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabcbcd");
        assertTrue(result);
    }

    @Test
    public void permutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabccbdd");
        assertTrue(result);
    }

    @Test
    public void noPermutationWithOddNumberOfChars() {
        final boolean result = hasPalindromePermutation("aabcd");
        assertFalse(result);
    }

    @Test
    public void noPermutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabbcd");
        assertFalse(result);
    }

    @Test
    public void emptyStringTest() {
        final boolean result = hasPalindromePermutation("");
        assertTrue(result);
    }

    @Test
    public void oneCharacterStringTest() {
        final boolean result = hasPalindromePermutation("a");
        assertTrue(result);
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
