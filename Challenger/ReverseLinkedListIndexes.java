package Challenger;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLinkedListIndexes {

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) {
            return head;
        }

        Stack<Integer> flipStack = new Stack<>();
        Queue<Integer> numQue = new LinkedList<Integer>();
        ListNode node = head;

        int i = 1;
        while (node != null) {
            if (i >= m && i <= n) {
                flipStack.push(node.val);
            } else {
                numQue.add(node.val);
            }
            node = node.next;
            i++;
        }
        ListNode ansHead;
       
        if (m < 2) {
            ansHead = new ListNode(flipStack.pop());
        } else {
            ansHead = new ListNode(numQue.poll());
        }
        ListNode currentNode = ansHead;
        int j = 2;
        while (!flipStack.isEmpty() || !numQue.isEmpty()) {
            ListNode temp;
            if (j >= m && j <= n) {
                temp = new ListNode(flipStack.pop());
            } else {
                temp = new ListNode(numQue.poll());
            }
            currentNode.next = temp;
            currentNode = temp;
            j++;
        }

        return ansHead;

    }

    public static void main(String[] args) {
        ListNode testCaseHeadNodeL = new ListNode(1);

        ListNode testCaseL1 = new ListNode(2);
        testCaseHeadNodeL.next = testCaseL1;

        ListNode testCaseL2 = new ListNode(3);
        testCaseL1.next = testCaseL2;

        ListNode testCaseL3 = new ListNode(4);
        testCaseL2.next = testCaseL3;

        ListNode testCaseL4 = new ListNode(5);
        testCaseL3.next = testCaseL4;

        ListNode testCaseL5 = new ListNode(6);
        testCaseL4.next = testCaseL5;

        System.out.println("Expected:  5->4->3->2->1 :: Actual: " + reverseBetween(testCaseHeadNodeL, 2, 4));
    }
}

// create a stack of int for slipped elements
// create a que for unflipped elements
// create a int to keep track of the index positions
// step through the list nodes
// if index > m && index < n add it to the stack
// else add it to the que

// create a head node response object
// create a current node
// set current node = head
// while the stack and que are not empty
// if index > m && index < n pull value from the stack to make new temp node
// else pull value from the que to make new temp node
// return the head