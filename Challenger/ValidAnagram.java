package Challenger;

import java.util.Arrays;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        if (s.length() == 0 || t.length() == 0) {
            return false;
        }

        char[] charS, charT;

        charS = s.toCharArray();
        charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);

        int i = 0;
        for (char c : charS) {
            if (c != charT[i++]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}