import java.util.Random;

class Simulate_5_Sided_Die {

    private static final Random rnd = new Random();

    private static int rand7() {
        return rnd.nextInt(7) + 1;
    }

    public static int rand5() {

        // implement rand5() using rand7()
        int n=rand7();
        if(n<=5) return n;
        else if(n==6) return 1;
        else if(n==7) return 2;
        else return 3;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d ", rand5());
        }
        System.out.println();
    }
}
