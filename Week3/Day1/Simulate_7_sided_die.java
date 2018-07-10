import java.util.Random;

class Simulate_7_sided_die {

    private static final Random rnd = new Random();

    private static int rand5() {
        return rnd.nextInt(5) + 1;
    }

    public static int rand7() {

        // implement rand7() using rand5()
        while(true){
             int n = (rand5()-1)*5 + rand5();
            if(n <= 21)
                 return n % 7;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 14; i++) {
            System.out.printf("%d ", rand7());
        }
        System.out.println();
    }
}
