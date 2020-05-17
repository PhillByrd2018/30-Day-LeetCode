package Challenger;

public class PlusOneArray {

    public static int[] plusOne(int[] digits) {

        int len = digits.length;

        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        int[] ans = new int[len + 1];
        ans[0] = 1;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Expected: :: Actual: ");
    }
}