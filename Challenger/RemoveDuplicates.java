package Challenger;

import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        

        if (head == null) {
            return null;
        }

        Set<Integer> numSet = new TreeSet<>();
        ListNode node = head;
        while (node != null) {
            if (!numSet.contains(node.val)) {
                numSet.add(node.val);
            }
            node = node.next;
        }

        int startNum = numSet.stream().findFirst().get();
        numSet.remove(startNum);
        ListNode ansHead = new ListNode(startNum);

        ListNode currentNode = ansHead;

        while (!numSet.isEmpty()) {
            int tempStartNum = numSet.stream().findFirst().get();
            numSet.remove(tempStartNum);
            ListNode temp = new ListNode(tempStartNum);
            currentNode.next = temp;
            currentNode = temp;
        }

        return ansHead;
    }

    public static ListNode deleteDuplicatesInOrder(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode testCaseHeadNodeL = new ListNode(1);

        ListNode testCaseL1 = new ListNode(2);
        testCaseHeadNodeL.next = testCaseL1;

        ListNode testCaseL2 = new ListNode(2);
        testCaseL1.next = testCaseL2;

        ListNode testCaseL3 = new ListNode(3);
        testCaseL2.next = testCaseL3;

        ListNode testCaseL4 = new ListNode(3);
        testCaseL3.next = testCaseL4;

        ListNode testCaseL5 = new ListNode(4);
        testCaseL4.next = testCaseL5;

        System.out.println("Expected:  1->2->3->4 :: Actual: " + deleteDuplicates(testCaseHeadNodeL));
        System.out.println("Expected:  1->2->3->4 :: Actual: " + deleteDuplicatesInOrder(testCaseHeadNodeL));

    }
}

//make a set of ints
//step through the list
//if the value of that node is not in the set add it to the set
//create head response object with first element in the set
//create a current node = head
//while the set is not empty 
    //pull nodes from the set
    //create a temp node with the value of that node
    //current.next = temp;
    //current = temp;
//return head