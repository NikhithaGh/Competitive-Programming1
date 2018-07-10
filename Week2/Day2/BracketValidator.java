import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;
import java.util.*;

public class BracketValidator {

    public static boolean isValid(String code) {

        // determine if the input code is valid
        Stack<Character> s=new Stack<>();
        for(int i=0;i<code.length();i++){
            char p=code.charAt(i);
            if(p == '(' || p=='{' || p=='[') s.push(p);
            else if(s.empty()) return false;
            else{
                char x=s.pop();
                if(x== '(' && (p==']' || p=='}')) return false;
                else if(x== '[' && (p==')' || p=='}')) return false;
                else if(x== '{' && (p==')' || p==']')) return false;
            }
        }
        if(!s.empty()) return false;

        return true;
    }


















    // tests

    @Test
    public void validShortCodeTest() {
        final boolean result = isValid("()");
        assertTrue(result);
    }

    @Test
    public void validLongerCodeTest() {
        final boolean result = isValid("([]{[]})[]{{}()}");
        assertTrue(result);
    }

    @Test
    public void mismatchedOpenerAndCloserTest() {
        final boolean result = isValid("([][]}");
        assertFalse(result);
    }

    @Test
    public void missingCloserTest() {
        final boolean result = isValid("[[]()");
        assertFalse(result);
    }

    @Test
    public void extraCloserTest() {
        final boolean result = isValid("[[]]())");
        assertFalse(result);
    }

    @Test
    public void emptyStringTest() {
        final boolean result = isValid("");
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
