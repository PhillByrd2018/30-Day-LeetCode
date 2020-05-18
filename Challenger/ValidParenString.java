package Challenger;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

// https://leetcode.com/problems/valid-parenthesis-string/discuss/107570/JavaC%2B%2BPython-One-Pass-Count-the-Open-Parenthesis

public class ValidParenString {

    public static String testCase1 = "()";
    public static String testCase2 = "(*)";
    public static String testCase3 = "(*))";
    public static String testCase4 = "()()()()()((((()))))";
    public static String testCase5 = "(*))))))))";
    public static String testCase6 = "(*()";
    public static String testCase7 = "*(()";

    public static boolean checkValidString(String s) {

        int maxNumberOfConnections = 0;
        int minNumberOfConnections = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(') {
                maxNumberOfConnections++;
                minNumberOfConnections++;
            } else if (currentChar == ')') {
                maxNumberOfConnections--;
                minNumberOfConnections = Math.max(minNumberOfConnections - 1, 0);
            } else {
                maxNumberOfConnections++;
                minNumberOfConnections = Math.max(minNumberOfConnections - 1, 0);
            }

            if (maxNumberOfConnections < 0) {
                return false;
            }
        }

        return minNumberOfConnections == 0;
    }

    public static boolean checkValidStringSet(String s) {
        Stack<Map<Character, Integer>> stackOfParens = new Stack<>();
        Stack<Map<Character, Integer>> stackOfStars = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stackOfParens.push(Map.of(s.charAt(i), i));
            } else if (s.charAt(i) == ')') {
                if (!stackOfParens.isEmpty()) {
                    stackOfParens.pop();
                } else if (!stackOfStars.isEmpty()) {
                    stackOfStars.pop();
                } else {
                    return false;
                }
            } else if (s.charAt(i) == '*') {
                stackOfStars.push(Map.of(s.charAt(i), i));
            }
        }
        if (stackOfParens.isEmpty()) {
            return true;
        }

        while (!stackOfParens.isEmpty()) {
            if (stackOfStars.isEmpty()) {
                return false;
            } else {
                Map<Character, Integer> parenMap = stackOfParens.pop();
                Map<Character, Integer> starMap = stackOfStars.pop();
                Set<Character> currentParen = parenMap.keySet();

                if (currentParen.contains('(')) {
                    if (starMap.get('*') < parenMap.get('(')) {
                        return false;
                    }
                } else if (currentParen.contains(')')) {
                    if (starMap.get('*') > parenMap.get(')')) {
                        return false;
                    }
                }
            }
        }
        return stackOfParens.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("Expected: false :: Actual: " +
        checkValidString(testCase5));
        System.out.println("Expected: true :: Actual: " +
        checkValidString(testCase1));
        System.out.println("Expected: true :: Actual: " +
        checkValidString(testCase2));
        System.out.println("Expected: true :: Actual: " +
        checkValidString(testCase3));
        System.out.println("Expected: true :: Actual: " +
        checkValidString(testCase4));

        System.out.println("=========================================================");
        System.out.println("Expected: true :: Actual: " +
        checkValidStringSet(testCase1));
        System.out.println("Expected: true :: Actual: " +
        checkValidStringSet(testCase2));
        System.out.println("Expected: true :: Actual: " +
        checkValidStringSet(testCase3));
        System.out.println("Expected: true :: Actual: " +
        checkValidStringSet(testCase4));
        System.out.println("Expected: false :: Actual: " +
        checkValidStringSet(testCase5));
        System.out.println("Expected: true :: Actual: " + checkValidStringSet(testCase6));
        System.out.println("Expected: false :: Actual: " + checkValidStringSet(testCase7));
    }
}