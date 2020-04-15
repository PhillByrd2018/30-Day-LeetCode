package Challenger;

import java.util.Stack;

public class BackSpaceString {

    public static String testCase1 = "ab#c";
    public static String testCase2 = "ad#c";
    public static String testCase3 = "ab##";
    public static String testCase4 = "c#d#";


    public static boolean backSpaceCompare(String S, String T) {

        if (processStringValue(S).equals(processStringValue(T))) {
            return true;
        }

        return false;
    }

    public static String processStringValue(String str) {
        StringBuilder strProcessed = new StringBuilder();

        for (char c: str.toCharArray()) {
            if (c == '#') {
                if ( strProcessed.length() != 0) {
                    strProcessed.deleteCharAt(strProcessed.length() - 1);
                }
            } else {
                strProcessed.append(c);
            }
        }
        return strProcessed.toString(); 
    }


    public static boolean backSpaceCompareStack(String S, String T) {

        return processStringValueStack(S).equals(processStringValueStack(T));
        
    }

    public static String processStringValueStack(String S) { 

        Stack<Character> ans = new Stack<>();

        for (char c: S.toCharArray()) {
            if (c != '#') {
                ans.push(c);
            } else {
                ans.pop();
            }
        }
        return ans.toString();

    }


    public static void main(String[] args) {
        
        System.out.println("Expected: true :: Actual: " + backSpaceCompare(testCase1, testCase2));
        System.out.println("Expected: true :: Actual: " + backSpaceCompare(testCase3, testCase4));
        System.out.println("Expected: false :: Actual: " + backSpaceCompare(testCase1, testCase4));

        System.out.println("====================================================================");

        System.out.println("Expected: true :: Actual: " + backSpaceCompareStack(testCase1, testCase2));
        System.out.println("Expected: true :: Actual: " + backSpaceCompareStack(testCase3, testCase4));
        System.out.println("Expected: false :: Actual: " + backSpaceCompareStack(testCase1, testCase4));
        
    }
}