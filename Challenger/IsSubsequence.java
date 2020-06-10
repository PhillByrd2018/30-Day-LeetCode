package Challenger;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {


        int fromIndex = 0;
        for (char c : s.toCharArray()) {
            fromIndex = t.indexOf(c, fromIndex);
            if (fromIndex++ < 0) {
                return false;
            }
        }
        return true;
    }

    
    public static void main(String[] args) {
        System.out.println("Expected: false :: Actual: " + isSubsequence("aaaaaa", "bbaaaa"));
        System.out.println("Expected: false :: Actual: " + isSubsequence("abc", ""));
        System.out.println("Expected: false :: Actual: " + isSubsequence("abc", "chbgd"));
        System.out.println("Expected: true :: Actual: " + isSubsequence("abc", "ahbgdc"));
        System.out.println("Expected: false :: Actual: " + isSubsequence("abc", "achbgd"));
    }
}