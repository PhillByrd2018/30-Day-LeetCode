package Challenger;

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {

    public static int longestPalindromeSet(String s) {
        if (s.length() < 1) {
            return 0;
        }

        Set<Character> frequencySet = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (frequencySet.contains(c)) {
                frequencySet.remove(c);
            } else {
                frequencySet.add(c);
            }
        }

        if (frequencySet.size() <= 1) {
            return s.length();
        }

        return s.length() - frequencySet.size() + 1;
    }

    public static void main(String[] args) {
        System.out.println("Expected: 7 :: Actual: " + longestPalindromeSet("abccccdd"));
    }
}