package Challenger;
import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */

public class MinStack {
    
    Stack<int[]> stack = new Stack<>();


    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        /* If the stack is empty, then the min value
         * must just be the first value we add. */
        if (stack.isEmpty()) {
            stack.push(new int[]{x, x});
            return;
        }

        int currentMin = stack.peek()[1];
        stack.push(new int[]{x, Math.min(x, currentMin)});
        
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Returns -3 :: Actual: " + minStack.getMin());
        minStack.pop();
        System.out.println("Returns 0 :: Actual: " + minStack.top());
        System.out.println("Returns -2 :: Actual: " + minStack.getMin());
    }
}