package Challenger;
// https://leetcode.com/problems/odd-even-linked-list/

import java.util.ArrayList;
import java.util.List;

public class OddEvenLinkedList {

    public static ListNode oddEvenListNotInPlace(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode currentNode;
        currentNode = head;

        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();

        int index = 1;

        while (currentNode != null) {
            if (index % 2 != 0) {
                oddList.add(currentNode.val);
                currentNode = currentNode.next;
                index++;
            } else {
                evenList.add(currentNode.val);
                currentNode = currentNode.next;
                index++;
            }
        }

        ListNode oddHead = new ListNode(oddList.remove(0));
        ListNode currentNodeO = oddHead;
        ListNode tempO;
        for (int num : oddList) {
            tempO = new ListNode(num);
            currentNodeO.next = tempO;
            currentNodeO = tempO;
        }

        ListNode evenHead = new ListNode(evenList.remove(0));
        ListNode currentNodeE = evenHead;
        ListNode tempE;
        for (int num : evenList) {
            tempE = new ListNode(num);
            currentNodeE.next = tempE;
            currentNodeE = tempE;
        }

        ListNode currentNodeAns = oddHead;
        while (currentNodeAns.next != null) {
            currentNodeAns = currentNodeAns.next;
        }

        currentNodeAns.next = evenHead;
        return oddHead;
    }

    // public static ListNode oddEvenListInPlace(ListNode head) {

    // }

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

        System.out.println("Expected:  1->3->5->2->4->6 :: Actual: " + oddEvenListNotInPlace(testCaseHeadNodeL));
    }
}