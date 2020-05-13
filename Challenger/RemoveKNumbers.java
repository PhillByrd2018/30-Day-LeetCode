package Challenger;

import java.util.Stack;

// https://leetcode.com/problems/remove-k-digits/

public class RemoveKNumbers {

    public static String removeKdigits(String num, int k) {

        if (k == num.length()) {
            return "0";
        }

        Stack<Character> numStack = new Stack<>();

        int i = 0;
        // loop through the num
        while (i < num.length()) {
            // if we see a num that is less than the head of the stack and we still have k
            // elements to remove, pop the head and decrement k
            while (k > 0 && !numStack.isEmpty() && numStack.peek() > num.charAt(i)) {
                numStack.pop();
                k--;
            }

            numStack.push(num.charAt(i));
            i++;
        }

        // if we get a num that is all the same char then nothing will happen above so
        // if there is still k value here we just remove k elements
        while (k > 0) {
            numStack.pop();
            k--;
        }
        StringBuilder str = new StringBuilder();

        //add to builder the elements from the stack
        while (!numStack.isEmpty()) {
            str.append(numStack.pop());
        }
        //flip it to the correct order
        str.reverse();

        //if we see leading 0s remove them
        while (str.length() > 1 && str.charAt(0) == '0') {
            str.deleteCharAt(0);
        }

        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println("Expected: 1219 :: Actual: " + removeKdigits("1432219", 3));
        System.out.println("Expected: 0 :: Actual: " + removeKdigits("1111", 4));
        System.out.println("Expected: 200 :: Actual: " + removeKdigits("10200", 1));
    }
}

// validations

// create a stack
// step through the string with while loop
// have an inner while loop that runs while k>0 & the stack is not empty & the
// char i < stack.head
// decrement k and pop from the stack
// add to the stack the element at i

// make a stringbuilder
// reverse the stack and append to the string builder
// return that string