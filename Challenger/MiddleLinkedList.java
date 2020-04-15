package Challenger;

import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class MiddleLinkedList {

    public static int[] testCase1 = {1,2,3,4,5};
    public static int[] testCase2 = {1,2,3,4,5,6};

    public static ListNode middleNodeGreedy(LinkedList<Integer> head) {

        
        int numOfNodes = head.size();

        int middle = numOfNodes / 2;

        ListNode ans = new ListNode(head.get(middle));

        return ans;
        
    }

    public static LinkedList<Integer> makeListNodes(int[] nums){
       
        LinkedList<Integer> response = new LinkedList<>();
        for (int num : nums) {
            response.add(num);
        }
        return response;
    }

    public static void main(String[] args) {

        LinkedList<Integer> head = makeListNodes(testCase1);
        System.out.println("Expected: 3 :: Actual: " + middleNodeGreedy(head).val);

        LinkedList<Integer> head2 = makeListNodes(testCase2);
        System.out.println("Expected: 4 :: Actual: " + middleNodeGreedy(head2).val);
        
    }

}


