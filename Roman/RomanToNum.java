package Roman;

import java.util.HashMap;
import java.util.Map;

public class RomanToNum {

    static String testCase1 = "III";
    static String testCase2 = "IX";
    static String testCase3 = "MCMXCIV";
    static String testCase4 = "LVII";
    static String testCase5 = "M";

    public static int RomanToNumsForwards(String S) {
        int ans = 0;

        Map<Character, Integer> romans = new HashMap<>();
        
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);

        char[] romanChars = S.toCharArray();
        int length = romanChars.length;
       

        for (int i = 0; i < length; i++) {
            
            if (i+1 >= length || romans.get(romanChars[i]) >= romans.get(romanChars[i+1])) {
                ans += romans.get(romanChars[i]);
            } else {
                ans += (romans.get(romanChars[i+1]) - romans.get(romanChars[i]));
                ++i;
            }
        }

        return ans;
    }


    public static int RomanToNumsBackwards(String S){

        Map<Character, Integer> romans = new HashMap<>();
        
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);

        char[] romanChars = S.toCharArray();
        int length = romanChars.length-1;
        int ans = romans.get(romanChars[length]);

        for (int i = length-1; i >= 0; i--) {
            if (romans.get(romanChars[i]) < romans.get(romanChars[i+1])) {
                ans -= romans.get(romanChars[i]);
            } else {
                ans += romans.get(romanChars[i]);
            }

        }
       return ans;

    }

    public static void main(String[] args) {

        System.out.println(RomanToNumsForwards(testCase1));
        System.out.println(RomanToNumsForwards(testCase2));
        System.out.println(RomanToNumsForwards(testCase3));
        System.out.println(RomanToNumsForwards(testCase4));

        System.out.println(RomanToNumsBackwards(testCase1));
        System.out.println(RomanToNumsBackwards(testCase2));
        System.out.println(RomanToNumsBackwards(testCase3));
        System.out.println(RomanToNumsBackwards(testCase4));
        System.out.println(RomanToNumsBackwards(testCase5));



    }

}