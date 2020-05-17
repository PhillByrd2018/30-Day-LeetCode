package Challenger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramIndex {

    public static List<Integer> findAnagrams(String s, String p) {
        // validations

        List<Integer> ans = new ArrayList<>();

        int length = p.length();
        int left = 0;
        int right = left + length;

        char[] c = p.toCharArray();
        Arrays.sort(c);
        String sortedP = String.valueOf(c);

        while (right <= s.length()) {

            String sliceOfS = s.substring(left, right);
            char[] sliceOfSChar = sliceOfS.toCharArray();
            Arrays.sort(sliceOfSChar);
            String sortedS = String.valueOf(sliceOfSChar);

            if (sortedP.equals(sortedS)) {
                ans.add(left);
            }
            left++;
            right++;
        }
        return ans;
    }

    public static List<Integer> findAnagramsASCI(String s, String p) {
        // validations

        List<Integer> ans = new ArrayList<>();

        int length = p.length();
        int left = 0;
        int right = left + length;
        int valueOfP = 0;
        int valueOfS = 0;
        for (char charP : p.toCharArray()) {
            valueOfP += (int) (charP - 'a');
        }

        while (right <= s.length()) {
            valueOfS = 0;
            String sliceOfS = s.substring(left, right);
            for (char Schar : sliceOfS.toCharArray()) {
                valueOfS += (int) (Schar - 'a');
            }

            if (valueOfS == valueOfP) {
                ans.add(left);
            }
            left++;
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println("Expected: [] :: Actual: " + findAnagramsASCI("af", "be"));
    }
}