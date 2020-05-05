package Challenger;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatingChar {

    public static String testCase1 = "leetcode";
    public static String testCase2 = "loveleetcode";
    public static String testCase3 = "";
    
    public static int firstUniqChar(String s) {
        
        if (s.isEmpty()){
            return -1;
        }

        if (s.length() == 1){
            return 0;
        }

        Map<Character, Integer> charMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0)+1);
        }

        for (char c : s.toCharArray()) {
           if (charMap.get(c) == 1) {
            return s.indexOf(c);
           }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Expected: 0 :: Actual: " + firstUniqChar(testCase1));
        System.out.println("Expected: 2 :: Actual: " + firstUniqChar(testCase2));
        System.out.println("Expected: -1 :: Actual: " + firstUniqChar(testCase3));
    }
}