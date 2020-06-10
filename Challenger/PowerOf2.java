package Challenger;

public class PowerOf2 {
    public static boolean isPowerOfTwo(int n) {
        
        if (n ==0) {
            return false;
        } 
        if (n == 1) {
            return true;
        }
        
        while(n%2==0) {
            n = n/2;
            if (n == 1) {
                return true;
            }
        }
        
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Expected: true :: Actual: " + isPowerOfTwo(16));
        System.out.println("Expected: false :: Actual: " + isPowerOfTwo(12));
        System.out.println("Expected: false :: Actual: " + isPowerOfTwo(9));
        System.out.println("Expected: true :: Actual: " + isPowerOfTwo(1));
    }
}