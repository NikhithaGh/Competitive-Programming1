import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static class Rectangle {

        // coordinates of bottom left corner
        private int leftX;
        private int bottomY;
    
        // dimensions
        private int width;
        private int height;
    
        public Rectangle() {}

        public Rectangle(int leftX, int bottomY, int width, int height) {
            this.leftX = leftX;
            this.bottomY = bottomY;
            this.width  = width;
            this.height = height;
        }

        public int getLeftX() {
            return leftX;
        }

        public int getBottomY() {
            return bottomY;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public String toString() {
            return String.format("(left: %d, bottom: %d, width: %d, height: %d)",
                leftX, bottomY, leftX + width, bottomY + height);
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Rectangle)) {
                return false;
            }
            final Rectangle r = (Rectangle) o;
            return leftX == r.leftX && bottomY == r.bottomY
                   && width == r.width && height == r.height;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result * 31 + leftX;
            result = result * 31 + bottomY;
            result = result * 31 + width;
            result = result * 31 + height;
            return result;
        }
    }

    public static Rectangle findRectangularOverlap(Rectangle rect1, Rectangle rect2) {

        int p1 = rect1.getLeftX();
        int p2 = rect2.getLeftX();
        int q1 = rect1.getBottomY();
        int q2 = rect2.getBottomY();
        int len1 = rect1.getHeight();
        int len2 = rect2.getHeight();
        int wide1 = rect1.getWidth();
        int wide2 = rect2.getWidth();
        int pi1, pi2,qi1,qi2,pf,qf,lenf,widef;
        pi1 = Math.max(p1, p2);
        pi2 = Math.min(p1+wide1, p2+wide2);
        if (pi1 >= pi2){
            pf = 0;
            widef = 0;
        }
        else{
            pf = pi1;
            widef = pi2-pi1;
        }
        qi1 = Math.max(q1, q2);
        qi2 = Math.min(q1+len1, q2+len2);
        if (qi1 >= qi2){
            qf = 0;
            lenf = 0;
        }
        else{
            qf = qi1;
            lenf = qi2-qi1;
        }
        if (lenf == 0 || widef == 0)
            return new Rectangle();
        return new Rectangle(pf,qf,widef,lenf);
    }


















    // tests

    @Test
    public void overlapAlongBothAxesTest() {
        final Rectangle actual = findRectangularOverlap(
            new Rectangle(1, 1, 6, 3), new Rectangle(5, 2, 3, 6));
        final Rectangle expected = new Rectangle (5, 2, 2, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void oneRectangleInsideAnotherTest() {
        final Rectangle actual = findRectangularOverlap(
            new Rectangle(1, 1, 6, 6), new Rectangle(3, 3, 2, 2));
        final Rectangle expected = new Rectangle(3, 3, 2, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void bothRectanglesTheSameTest() {
        final Rectangle actual = findRectangularOverlap(
            new Rectangle(2, 2, 4, 4), new Rectangle(2, 2, 4, 4));
        final Rectangle expected = new Rectangle(2, 2, 4, 4);
        assertEquals(expected, actual);
    }

    @Test
    public void touchOnHorizontalEdgeTest() {
        final Rectangle actual = findRectangularOverlap(
            new Rectangle(1, 2, 3, 4), new Rectangle(2, 6, 2, 2));
        final Rectangle expected = new Rectangle();
        assertEquals(expected, actual);
    }

    @Test
    public void touchOnVerticalEdgeTest() {
        final Rectangle actual = findRectangularOverlap(
            new Rectangle(1, 2, 3, 4), new Rectangle(4, 3, 2, 2));
        final Rectangle expected = new Rectangle();
        assertEquals(expected, actual);
    }

    @Test
    public void touchAtCornerTest() {
        final Rectangle actual = findRectangularOverlap(
            new Rectangle(1, 1, 2, 2), new Rectangle(3, 3, 2, 2));
        final Rectangle expected = new Rectangle();
        assertEquals(expected, actual);
    }

    @Test
    public void noOverlapTest() {
        final Rectangle actual = findRectangularOverlap(
            new Rectangle(1, 1, 2, 2), new Rectangle(4, 6, 3, 6));
        final Rectangle expected = new Rectangle();
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