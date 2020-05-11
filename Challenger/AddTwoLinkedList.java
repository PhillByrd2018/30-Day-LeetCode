package Challenger;
// https://leetcode.com/problems/add-two-numbers/

import java.math.BigInteger;
import java.util.Stack;

public class AddTwoLinkedList {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // validations

        BigInteger leftNumber = listToIntHelper(l1);
        BigInteger rightNumber = listToIntHelper(l2);

        BigInteger ans = leftNumber.add(rightNumber);

        ListNode ansList = intToListHelper(ans);
        return ansList;
    }

    public static BigInteger listToIntHelper(ListNode head) {
        Stack<Integer> stackOfNums = new Stack<>();

        ListNode currentNode = head;
        while (currentNode != null) {
            stackOfNums.push(currentNode.val);
            currentNode = currentNode.next;
        }
        StringBuilder helperString = new StringBuilder();

        while (!stackOfNums.isEmpty()) {
            helperString.append(Integer.toString(stackOfNums.pop()));
        }

        return new BigInteger(helperString.toString());
    }

    public static ListNode intToListHelper(BigInteger numberToConvert) {

        Stack<Character> charStack = new Stack<>();

        for (char c : numberToConvert.toString().toCharArray()) {
            charStack.push(c);
        }
        ListNode head = new ListNode(Integer.parseInt(charStack.pop().toString()));
        ListNode currentNode = head;

        while (!charStack.isEmpty()) {
            ListNode newNode = new ListNode(Integer.parseInt(charStack.pop().toString()));
            currentNode.next = newNode;
            currentNode = currentNode.next;
        }
        return head;
    }

    public static ListNode addTwoNumbersSpeedy(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode leftSide = l1;
        ListNode rightSide = l2;
        ListNode currentNode = dummyHead;
        int carry = 0;

        while (leftSide != null || rightSide != null) {
            int x = (leftSide != null) ? leftSide.val : 0;
            int y = (rightSide != null) ? rightSide.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            currentNode.next = new ListNode(sum);
            currentNode = currentNode.next;

            if (leftSide != null)
                leftSide = leftSide.next;
            if (rightSide != null)
                rightSide = rightSide.next;
        }
        if (carry > 0) {
            currentNode.next = new ListNode(carry);
        }
        return dummyHead;
    }

    public static void main(String[] args) {

        ListNode testCaseHeadNodeL = new ListNode(2);

        ListNode testCaseL1 = new ListNode(4);
        testCaseHeadNodeL.next = testCaseL1;

        ListNode testCaseL2 = new ListNode(3);
        testCaseL1.next = testCaseL2;

        ListNode testCaseHeadNodeR = new ListNode(5);

        ListNode testCaseR1 = new ListNode(6);
        testCaseHeadNodeR.next = testCaseR1;

        ListNode testCaseR2 = new ListNode(4);
        testCaseR1.next = testCaseR2;

        System.out.println("Expected: 7 > 0 > 8 :: Actual: " + addTwoNumbers(testCaseHeadNodeL, testCaseHeadNodeR));

        System.out
                .println("Expected: 7 > 0 > 8 :: Actual: " + addTwoNumbersSpeedy(testCaseHeadNodeL, testCaseHeadNodeR));

        ListNode testCaseHeadNodeL2 = new ListNode(9);

        ListNode testCaseHeadNodeR2 = new ListNode(1);

        ListNode testCase2L2 = new ListNode(9);
        testCaseHeadNodeR2.next = testCase2L2;

        ListNode testCase2L3 = new ListNode(9);
        testCase2L2.next = testCase2L3;

        ListNode testCase2L4 = new ListNode(9);
        testCase2L3.next = testCase2L4;

        ListNode testCase2L5 = new ListNode(9);
        testCase2L4.next = testCase2L5;

        ListNode testCase2L6 = new ListNode(9);
        testCase2L5.next = testCase2L6;

        ListNode testCase2L7 = new ListNode(9);
        testCase2L6.next = testCase2L7;

        ListNode testCase2L8 = new ListNode(9);
        testCase2L7.next = testCase2L8;

        ListNode testCase2L9 = new ListNode(9);
        testCase2L8.next = testCase2L9;

        ListNode testCase2L10 = new ListNode(9);
        testCase2L9.next = testCase2L10;

        System.out.println("Expected: #### :: Actual: " + addTwoNumbers(testCaseHeadNodeL2, testCaseHeadNodeR2));
        System.out.println("Expected: #### :: Actual: " + addTwoNumbersSpeedy(testCaseHeadNodeL2, testCaseHeadNodeR2));

    }

}

// validations

// call the helper method passing the linkedlists
// get the int values back and add them
// pass the sum value to the packing helper
// return the head of that list

// helper method to unpack the list to an int
// use a stack
// loop through the list
// if element != null add to stack
// when we reach the end of list add to String builder and then parseint;

// helper method to turn number back into reversed linkedlist
// use a stack
// turn int into string
// loop through the string
// if element != empty
// push string onto stack
// pop stack adding int value to each node in linkedlist
