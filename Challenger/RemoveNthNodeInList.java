package Challenger;

public class RemoveNthNodeInList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode currentNode = head;
        int length = 0;
        while(currentNode != null){
            currentNode = currentNode.next;
            length++;
        }

        currentNode = dummy;
        length -= n;
        while(length > 0){
            currentNode = currentNode.next;
            length--;
        }
        currentNode.next =  currentNode.next.next;

        return dummy.next;
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

        System.out.println("Expected:  1->2->3->5:: Actual: " + removeNthFromEnd(testCaseHeadNodeL, 2));

        ListNode testCaseHeadNode2 = new ListNode(1);
        System.out.println("Expected:  '' :: Actual: " + removeNthFromEnd(testCaseHeadNode2, 1));
    }
}