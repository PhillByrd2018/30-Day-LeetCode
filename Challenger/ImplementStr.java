package Challenger;

public class ImplementStr {

    public static int strStr(String haystack, String needle) {
        // validations
        if (haystack.length() == 0 || needle.length() == 0) {
            return -1;
        }

        int left = 0;
        int right = needle.length();
        while (right <= haystack.length()) {
            if (haystack.substring(left, right).equals(needle)) {
                return left;
            }
            left++;
            right++;
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println("Expected: 2 :: Actual: " + strStr("hello","ll"));
        System.out.println("Expected: 4 :: Actual: " + strStr("hello","o"));
        System.out.println("Expected: 4 :: Actual: " + strStr("hello","tim"));
    }
}