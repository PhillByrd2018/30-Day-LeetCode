package Challenger;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MakeAValidParen {

    public static String minRemoveToMakeValid(String s) {

        Set<Integer> setOfIndexesToRemove = new HashSet<>();
        Stack<Integer> stackToTrack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stackToTrack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stackToTrack.isEmpty()) {
                    setOfIndexesToRemove.add(i);
                } else {
                    stackToTrack.pop();
                }

            }
        }

        while (!stackToTrack.isEmpty()) {
            setOfIndexesToRemove.add(stackToTrack.pop());

        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!setOfIndexesToRemove.contains(i)) {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println("Expected: lee(t(co)de) :: ACtual: " + minRemoveToMakeValid("lee(t(c)o)de)"));
    }
}