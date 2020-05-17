package Challenger;

import java.util.Arrays;

public class ReverseAString {

    public static void reverseString(char[] s) {

        // validations
        if (s.length == 0 || s.length == 1) {
            return;
        }
        int left = 0;
        int right = s.length - 1;

        while (left < right) {

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        char[] testCase1 = { 'h', 'e', 'l', 'l', 'o' };
        System.out.println("Expected: [o l l e h] :: Actual: ");
        reverseString(testCase1);
    }
}