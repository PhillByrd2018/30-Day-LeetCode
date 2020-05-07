package Challenger;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidOpenAndClose {

    static Map<Character, Character> parenMap = new HashMap<>();

    static{
        parenMap.put('(', ')');
        parenMap.put('{', '}');
        parenMap.put('[', ']');
    }
    public static boolean isValid(String s) {
        
        //validation
        if (s.isEmpty()) {
            return true;
        }
        if (s.length() < 2) {
            return false;
        }


        Stack<Character> balanceStack = new Stack<>();
        //loop through the input
        for (char c : s.toCharArray()) {

            //if we see an opening, push the closer on the stack to show we need to close it
            if (parenMap.containsKey(c)) {
                balanceStack.push(parenMap.get(c));
                //else if we see a closer we need to check that there is a matching open to it
            } else if (parenMap.containsValue(c)) {
                //if the stack is empty or the value on the stack doesn't match then know the string is not valid.
                if (balanceStack.isEmpty() || balanceStack.pop() != c) {
                    return false;
                }
            }
        }

        return balanceStack.isEmpty();
    }

    public static void main(String[] args) {
        // System.out.println("Expected: true :: Actual: " + isValid("()[]{}"));
        System.out.println("Expected: false :: Actual: " + isValid("([)]"));
    }
}