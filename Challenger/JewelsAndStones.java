package Challenger;

import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {

    public static String testCase1S = "aAAbbbb";
    public static String testCase1J = "aA";

    public static String testCase2S = "ZZ";
    public static String testCase2J = "z";

    public static int numJewelsInStones(String J, String S) {
        int ans = 0;
        if (J.length() == 0 || S.length() == 0 || S == null || J == null) {
            return ans;
        }

        Map<Character, Integer> stoneMap = new HashMap<>();
        for (char stone : S.toCharArray()) {
            stoneMap.put(stone, stoneMap.getOrDefault(stone, 0) + 1);
        }

        for (char jewels : J.toCharArray()) {
            ans += stoneMap.getOrDefault(jewels, 0);
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println("Expected: 3 :: Actual: " + numJewelsInStones(testCase1J, testCase1S));
        System.out.println("Expected: 0 :: Actual: " + numJewelsInStones(testCase2J, testCase2S));
    }
}