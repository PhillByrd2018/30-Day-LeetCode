package Challenger;

import java.util.Arrays;

public class SubStrings {

    public static boolean checkInclusionBRUTE(String s1, String s2) {
        // validations

        int left = 0;
        int right = s1.length();
        char[] s1Char = s1.toCharArray();
        Arrays.sort(s1Char);
        s1 = String.valueOf(s1Char);
        while (right <= s2.length()) {

            String subS2 = s2.substring(left, right);
            char[] s2Char = subS2.toCharArray();
            Arrays.sort(s2Char);
            subS2 = String.valueOf(s2Char);

            if (subS2.equals(s1)) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Expected: true :: Actual: " + checkInclusionBRUTE("ba", "eidbaooo"));
        System.out.println("Expected: true :: Actual: " + checkInclusionBRUTE("adc", "dcda"));
    }
}

// validations cases
// s1 empty
// both are empty
// s1 > s2