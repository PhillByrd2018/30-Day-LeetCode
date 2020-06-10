package Challenger;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int index = 0;

        for (char c : s.toCharArray()) {
            index = isSubHelper(c, t, index);
            if (index < 0) {
                return false;
            }
        }
        return true;
    }

    public static int isSubHelper(char toSearch, String stringToSearch, int startingFrom) {

        for (int i = startingFrom; i < stringToSearch.length(); ++i) {
            if (toSearch == stringToSearch.charAt(i)) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println("Expected: false :: Actual: " + isSubsequence("aaaaaa", "bbaaaa"));
        System.out.println("Expected: false :: Actual: " + isSubsequence("abc", ""));
        System.out.println("Expected: false :: Actual: " + isSubsequence("abc", "chbgd"));
        System.out.println("Expected: true :: Actual: " + isSubsequence("abc", "ahbgdc"));
        System.out.println("Expected: false :: Actual: " + isSubsequence("abc", "achbgd"));
    }
}