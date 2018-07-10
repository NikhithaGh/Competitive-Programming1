import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;
import java.util.*;

public class ParenthesisMatching {

    public static int getClosingParen(String sentence, int openingParenIndex) {

        // find the position of the matching closing parenthesis
        Stack<Integer> c=new Stack<>();
        int result=0;
        for(int i=0;i<sentence.length();i++){
            char p=sentence.charAt(i);
            if(p =='(') c.push(i);
            else if(c.empty()) throw new IllegalArgumentException("");
            else{
                int x=c.pop();
                if(x == openingParenIndex) result =i;
            }
            
        }
        if(!c.empty()) throw new IllegalArgumentException("");

        return result;
    }


















    // tests

    @Test
    public void allOpenersThenClosersTest() {
        final int expected = 7;
        final int actual = getClosingParen("((((()))))", 2);
        assertEquals(expected, actual);
    }

    @Test
    public void mixedOpenersAndClosersTest() {
        final int expected = 10;
        final int actual = getClosingParen("()()((()()))", 5);
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void noMatchingCloserTest() {
        getClosingParen("()(()", 2);
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
