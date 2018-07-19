import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class MergeSortedArrays {

    public static int[] mergeArrays(int[] marr, int[] aarr) {

        // combine the sorted arrays into one large sorted array
        int i=0,j=0,k=0,l1=marr.length,l2=aarr.length;
        if(l1 ==0 && l2 == 0) return new int[] {};
        else if(l1==0) return aarr;
        else if(l2==0) return marr;
        else{
            int a[]=new int[l1+l2];
            while(i<l1 && j<l2){
                if(marr[i]<=aarr[j]){
                    a[k++]=marr[i++];
                }
                else a[k++]=aarr[j++];
            }
            if(i<l1){
                while(i<l1){
                     a[k++]=marr[i++];
                }
            }
            else if(j<l2){
                while(j<l2) a[k++]=aarr[j++];
            }
            return a;
        }
    }


















    // tests

    @Test
    public void bothArraysAreEmptyTest() {
        final int[] marr = {};
        final int[] aarr = {};
        final int[] expected = {};
        final int[] actual = mergeArrays(marr, aarr);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void firstArrayIsEmptyTest() {
        final int[] marr = {};
        final int[] aarr = {1, 2, 3};
        final int[] expected = {1, 2, 3};
        final int[] actual = mergeArrays(marr, aarr);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void secondArrayIsEmptyTest() {
        final int[] marr = {5, 6, 7};
        final int[] aarr = {};
        final int[] expected = {5, 6, 7};
        final int[] actual = mergeArrays(marr, aarr);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void bothArraysHaveSomeNumbersTest() {
        final int[] marr = {2, 4, 6};
        final int[] aarr = {1, 3, 7};
        final int[] expected = {1, 2, 3, 4, 6, 7};
        final int[] actual = mergeArrays(marr, aarr);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void arraysAreDifferentLengthsTest() {
        final int[] marr = {2, 4, 6, 8};
        final int[] aarr = {1, 7};
        final int[] expected = {1, 2, 4, 6, 7, 8};
        final int[] actual = mergeArrays(marr, aarr);
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
