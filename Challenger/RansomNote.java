package Challenger;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static String testCase1 = "a";
    public static String testCase2 = "b";
    public static String testCase3 = "aa";
    public static String testCase4 = "ab";
    public static String testCase5 = "aa";
    public static String testCase6 = "aab";

    public static boolean canConstruct(String ransomNote, String magazine) {
        
        if (ransomNote.isEmpty() || magazine.isEmpty() || ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> noteMap = new HashMap<>();
        Map<Character, Integer> magazineMap = new HashMap<>();

        for (char c : ransomNote.toCharArray()) {
            noteMap.put(c, noteMap.getOrDefault(c, 0) + 1);
        }

        for (char c : magazine.toCharArray()) {
            magazineMap.put(c, magazineMap.getOrDefault(c, 0) + 1);
        }

        for (char c : noteMap.keySet()) {
            if (magazineMap.get(c) == null || magazineMap.get(c) == 0) {
                return false;
            }

            if (noteMap.get(c) > magazineMap.get(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Expected: false :: Actual: " + canConstruct(testCase1, testCase2));
        System.out.println("Expected: false :: Actual: " + canConstruct(testCase3, testCase4));
        System.out.println("Expected: true :: Actual: " + canConstruct(testCase5, testCase6));
        
    }
}