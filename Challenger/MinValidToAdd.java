package Challenger;

import java.util.Stack;

public class MinValidToAdd {
    
    public static int minAddToMakeValid(String S) {
        
        Stack<Character> parenStack = new Stack<>();
        int count = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                parenStack.add(c);
            } else {
                if (parenStack.isEmpty()) {
                    count++;
                } else {
                    parenStack.pop();
                }
            }
        }
        
        while (!parenStack.isEmpty()) {
            count++;
            parenStack.pop();
        }
        return count;
    }
    public static void main(String[] args) {
        minAddToMakeValid("())");
    }
}