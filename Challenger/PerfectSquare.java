package Challenger;
// https://leetcode.com/problems/valid-perfect-square/

public class PerfectSquare {

    public static boolean isPerfectSquare(int num) {

        if (num < 1) {
            return false;
        }
        for (int i = 1; i <= num; i++) {
            int currentSquare = i * i;
            if (currentSquare == num)
                return true;
        }
        return false;
    }

    public static boolean isPerfectSquareBinarySearch(int num) {
        if (num < 2) {
            return true;
        }
        long start = 2;
        long end = num / 2;
        long mid;
        long currentSquare;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            currentSquare = mid * mid;
            if (currentSquare == num) {
                return true;
            } else if (currentSquare > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static boolean isPerfectSquareNewton(int num) {
        if (num < 2) {
            return true;
        }

        long currentGuess = num / 2;
        while (currentGuess * currentGuess > num) {
            currentGuess = (currentGuess + num / currentGuess) / 2;
        }
        return (currentGuess * currentGuess == num);
    }

    public static void main(String[] args) {
        System.out.println("Expected: true :: Actual: " + isPerfectSquare(16));
        System.out.println("Expected: true :: Actual: " + isPerfectSquare(16));
        System.out.println("Expected: true :: Actual: " + isPerfectSquare(25));
        System.out.println("Expected: false :: Actual: " + isPerfectSquare(14));
        System.out.println("Expected: false :: Actual: " + isPerfectSquare(98));
        System.out.println("Expected: true :: Actual: " + isPerfectSquare(160000));

        System.out.println("===================================================");
        System.out.println("Expected: true :: Actual: " + isPerfectSquareBinarySearch(160000));
        System.out.println("Expected: false :: Actual: " + isPerfectSquareBinarySearch(14));
        System.out.println("Expected: true :: Actual: " + isPerfectSquareBinarySearch(16));

        System.out.println("===================================================");
        System.out.println("Expected: true :: Actual: " + isPerfectSquareNewton(160000));
        System.out.println("Expected: false :: Actual: " + isPerfectSquareNewton(14));
        System.out.println("Expected: true :: Actual: " + isPerfectSquareNewton(16));
    }
}