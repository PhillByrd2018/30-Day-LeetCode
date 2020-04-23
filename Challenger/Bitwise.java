package Challenger;

public class Bitwise {


    public static int rangeBitwiseAnd(int m, int n) {
        int count = 0;

        while (m != n) {
            m>>=1;
            n>>=1;
            count++;
        }

        return m << count;
    }

    public static void main(String[] args) {
        
        System.out.println("Expected: 4 :: Actual: " + rangeBitwiseAnd(5, 7));
    }
}