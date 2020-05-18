package Challenger;

public class Fibonacci {

    public static int fib(int N) {

        if (N <= 1) {
            return N;
        }

        return fib(N - 1) + fib(N - 2);
    }

    public static void main(String[] args) {
        // System.out.println("expected: 1 :: Actual: " + fib(2));
        System.out.println("expected: 1 :: Actual: " + fib(6));
    }
}