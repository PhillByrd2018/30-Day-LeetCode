package Challenger;

//https://leetcode.com/problems/valid-parenthesis-string/discuss/107570/JavaC%2B%2BPython-One-Pass-Count-the-Open-Parenthesis

public class ValidParenString {

    public static String testCase1 = "()";
    public static String testCase2 = "(*)";
    public static String testCase3 = "(*))";
    public static String testCase4 = "()()()()()((((()))))";
    public static String testCase5 = "(*))))))))";


    public static boolean checkValidString(String s) {
        
        int maxNumberOfConnections = 0;
        int minNumberOfConnections = 0;

        for (int i = 0; i< s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(') {
                maxNumberOfConnections++;
                minNumberOfConnections++;
            } else if (currentChar ==')') {
                maxNumberOfConnections--;
                minNumberOfConnections = Math.max(minNumberOfConnections-1, 0);
            } else {
                maxNumberOfConnections++;
                minNumberOfConnections = Math.max(minNumberOfConnections-1, 0);
            }

            if (maxNumberOfConnections < 0) {
                return false;
            }
        }

        return minNumberOfConnections == 0;
    }
    public static void main(String[] args) {
        System.out.println("Expected: false :: Actual: " + checkValidString(testCase5));
        System.out.println("Expected: true :: Actual: " + checkValidString(testCase1));
        System.out.println("Expected: true :: Actual: " + checkValidString(testCase2));
        System.out.println("Expected: true :: Actual: " + checkValidString(testCase3));
        System.out.println("Expected: true :: Actual: " + checkValidString(testCase4));
        
    }
}