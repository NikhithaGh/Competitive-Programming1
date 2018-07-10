import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;
import java.util.*;

public class RecursiveStringPermutations {
    public static HashSet<String> hs;

    public static Set<String> getPermutations(String inputString) {

        // generate all permutations of the input string
        hs=new HashSet<>();
       if(inputString.length() == 0) return new HashSet<>(Arrays.asList(""));
        permutations(inputString,0,inputString.length()-1);

        return hs;
    }
    
    public static void permutations(String s,int l,int r){
        if (l == r)
            hs.add(s);
        else
        {
            for (int i = l; i <= r; i++)
            {
                s = swap(s,l,i);
                permutations(s, l+1, r);
                s = swap(s,l,i);
            }
        }
    }
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

















    // tests

    @Test
    public void emptyStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList(""));
        final Set<String> actual = getPermutations("");
        assertEquals(expected, actual);
    }

    @Test
    public void oneCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("a"));
        final Set<String> actual = getPermutations("a");
        assertEquals(expected, actual);
    }

    @Test
    public void twoCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("ab", "ba"));
        final Set<String> actual = getPermutations("ab");
        assertEquals(expected, actual);
    }

    @Test
    public void threeCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("abc", "acb", "bac", "bca",
                                                                 "cab", "cba"));
        final Set<String> actual = getPermutations("abc");
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
