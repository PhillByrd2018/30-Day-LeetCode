package Challenger;

import java.util.Stack;

public class ReverseLinkedList {

    public static ListNode reverseListIterative(ListNode head) {

        // validations
        if (head == null) {
            return new ListNode((Integer) null);
        }

        Stack<Integer> numStack = new Stack<>();
        ListNode node = head;

        while (node != null) {
            numStack.push(node.val);
            node = node.next;
        }

        ListNode headResponse = new ListNode(numStack.pop());
        ListNode currentNode = headResponse;

        while (!numStack.isEmpty()) {
            ListNode temp = new ListNode(numStack.pop());
            currentNode.next = temp;
            currentNode = temp;
        }

        return headResponse;

    }

    public static ListNode reverseListRecursive(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return node;
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

        System.out.println("Expected:  5->4->3->2->1 :: Actual: " + reverseListIterative(testCaseHeadNodeL));
        System.out.println("Expected:  5->4->3->2->1 :: Actual: " + reverseListIterative(testCaseHeadNodeL));
    }
}

// validations

// create a stack
// traverse the list
// add every value that is not null to the stack
// create a head node return object
// create current node object
// set current = head
// loop through the rest of the stack and create new nodes with those values
// set current.next = to new node
// set current node to new node