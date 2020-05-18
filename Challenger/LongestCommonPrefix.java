package Challenger;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }
        String longestPrefix = strs[0];

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() == 0) {
                return "";
            }

            while (strs[i].indexOf(longestPrefix) != 0) {

                longestPrefix = longestPrefix.substring(0, longestPrefix.length() - 1);
            }
            if (longestPrefix.isEmpty()) {
                return "";
            }

        }
        return longestPrefix;
    }

    public static String longestCommonPrefixBRUTE(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String longestPrefix = strs[0];

        for (String str : strs) {
            if (str.isEmpty() || longestPrefix.isEmpty()) {
                return "";
            }
            longestPrefix = longestCommonPrefixBRUTEHelper(str, longestPrefix);
        }

        return longestPrefix;
    }

    public static String longestCommonPrefixBRUTEHelper(String currentString, String longestPrefix) {
        if (currentString.isEmpty() || longestPrefix.isEmpty()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < currentString.length(); i++) {
            if (i >= currentString.length() || i >= longestPrefix.length()) {
                return builder.toString();
            }
            if (currentString.charAt(i) == longestPrefix.charAt(i)) {
                builder.append(longestPrefix.charAt(i));
            } else {
                break;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String[] testCase1 = { "flower", "flow", "flight" };
        System.out.println("Expected: fl :: Actual: " + longestCommonPrefix(testCase1));

        String[] testCase2 = { "flower", "plow", "tlight" };
        System.out.println("Expected: '' :: Actual: " + longestCommonPrefix(testCase2));

        System.out.println("======================================================");

        System.out.println("Expected: fl :: Actual: " + longestCommonPrefixBRUTE(testCase1));

        System.out.println("Expected: '' :: Actual: " + longestCommonPrefixBRUTE(testCase2));
        String[] testCase3 = { "aaa", "aa", "aaa" };
        System.out.println("Expected: aa :: Actual: " + longestCommonPrefixBRUTE(testCase3));

    }
}