package Challenger;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class deleteDuplicatesII {
    public static ListNode deleteDuplicates(ListNode head) {

        // validations
        if (head == null) {
            return head;
        }

        TreeMap<Integer, Integer> listMap = new TreeMap<>();
        ListNode node = head;
        while (node != null) {
            listMap.put(node.val, listMap.getOrDefault(node.val, 0) + 1);
            node = node.next;
        }

        Queue<Integer> goodNodes = new LinkedList<>();
        for (Map.Entry<Integer, Integer> num : listMap.entrySet()) {
            if (num.getValue() == 1) {
                goodNodes.add(num.getKey());
            }
        }
        if (goodNodes.isEmpty()) {
            return node;
        }

        ListNode headNodeAns = new ListNode(goodNodes.poll());
        ListNode currentNode = headNodeAns;

        while (!goodNodes.isEmpty()) {
            ListNode temp = new ListNode(goodNodes.poll());
            currentNode.next = temp;
            currentNode = temp;
        }
        return headNodeAns;

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
    }
}