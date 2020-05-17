package Challenger;

public class ReverseInteger {
    public static int reverse(int x) {

        // validations
        if (x == 0 || x > Integer.MAX_VALUE) {
            return 0;
        }
        boolean isNeg = false;
        if (x < 0) {
            isNeg = true;
        }

        String num = Integer.toString(x);
        if (isNeg == true) {
            num = num.replace("-", "");
        }
        StringBuilder ans = new StringBuilder();
        ans.append(num);
        num = ans.reverse().toString();

        if (Long.valueOf(num) < Integer.MIN_VALUE || Long.valueOf(num) > Integer.MAX_VALUE) {
            return 0;
        }

        long ansNums = isNeg ? -1 * Long.parseLong(num) : Long.parseLong(num);
        return (int) ansNums;
    }

    public static void main(String[] args) {
        // System.out.println("Expected: 123 :: Actual: " + reverse(321));
        // System.out.println("Expected: -123 :: Actual: " + reverse(-321));
        System.out.println("Expected: 0 :: Actual: " + reverse(1534236469));

    }
}