package Challenger;

public class MergeLinkedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // validations
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode l1Current = l1;
        ListNode l2Current = l2;
        ListNode ansHeadHolder = new ListNode(0);
        ListNode ansHead = ansHeadHolder;
        ListNode temp;

        while (l1Current != null && l2Current != null) {

            if (l1Current.val <= l2Current.val) {
                temp = new ListNode(l1Current.val);
                ansHead.next = temp;
                ansHead = ansHead.next;
                l1Current = l1Current.next;
            } else {
                temp = new ListNode(l2Current.val);
                ansHead.next = temp;
                ansHead = ansHead.next;
                l2Current = l2Current.next;
            }
        }

        if (l1Current != null) {
            while (l1Current != null) {
                temp = new ListNode(l1Current.val);
                ansHead.next = temp;
                ansHead = ansHead.next;
                l1Current = l1Current.next;
            }
        } else if (l2Current != null) {
            while (l2Current != null) {
                temp = new ListNode(l2Current.val);
                ansHead.next = temp;
                ansHead = ansHead.next;
                l2Current = l2Current.next;
            }
        }

        return ansHeadHolder.next;
    }

    public static ListNode mergeTwoListsOptomized(ListNode l1, ListNode l2) {

        // validations
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode preHeadAns = new ListNode(0);
        ListNode currentIndex = preHeadAns;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                currentIndex.next = l1;
                l1 = l1.next;
            } else {
                currentIndex.next = l2;
                l2 = l2.next;
            }
            currentIndex = currentIndex.next;
        }

        currentIndex.next = (l1 == null) ? l2 : l1;

        return currentIndex.next;
    }

    public static void main(String[] args) {

        ListNode testCaseHeadNodeL = new ListNode(1);

        ListNode testCaseL1 = new ListNode(2);
        testCaseHeadNodeL.next = testCaseL1;

        ListNode testCaseL2 = new ListNode(4);
        testCaseL1.next = testCaseL2;

        ListNode testCaseR = new ListNode(1);

        ListNode testCaseR1 = new ListNode(3);
        testCaseR.next = testCaseR1;

        ListNode testCaseR2 = new ListNode(4);
        testCaseR1.next = testCaseR2;

        mergeTwoLists(testCaseHeadNodeL, testCaseR);

    }
}