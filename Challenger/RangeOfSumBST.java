package Challenger;
// https://leetcode.com/problems/range-sum-of-bst/

public class RangeOfSumBST {
    
    public static int rangeSumBST(TreeNodePractice root, int L, int R) {

        int returnSum = 0;

        if (root == null) {
            return 0;
        }
        if (root.value >= L && root.value <= R) {
            returnSum += root.value;
        }

        returnSum += rangeSumBST(root.left, L, R);
        returnSum += rangeSumBST(root.right, L, R);

        return returnSum;
    }
    public static void main(String[] args) {
        TreeNodePractice root = new TreeNodePractice(3);
        TreeNodePractice rootL = new TreeNodePractice(9);
        TreeNodePractice rootR = new TreeNodePractice(20);
        TreeNodePractice rootRL = new TreeNodePractice(15);
        TreeNodePractice rootRR = new TreeNodePractice(7);
       
        root.left = rootL;
        root.right = rootR;
        root.right.left = rootRL;
        root.right.right = rootRR;

        System.out.println("Expected: 32 :: Actual: " + rangeSumBST(root, 7, 15));
    }
}

//validations

// recursively step through the tree
    //check if the root is null
    // then check if the val is between L & R
        //add that value to the running sum
        //return that sum
