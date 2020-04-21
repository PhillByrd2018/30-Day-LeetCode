package Challenger;

public class SumOfLeftLeaves {



    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public static int sumOfLeftLeaves(TreeNodePractice root) {
    if (root == null) {
      return 0;
    }
    return processSubtree(root, false);
  }
    
  private static int processSubtree(TreeNodePractice subtree, boolean isLeft) {
        
    // Base case: This is a leaf node.
    if (subtree.left == null && subtree.right == null) {
      return isLeft ? subtree.value : 0;
    }
        
    // Recursive case: We need to add and return the results of the
    // left and right subtrees.
    int total = 0;
    if (subtree.left != null) {
      total += processSubtree(subtree.left, true);
    }
    if (subtree.right != null) {
      total += processSubtree(subtree.right, false);
    }
    return total;
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

        System.out.println("Expected: 24:: Actual: " + sumOfLeftLeaves(root));
    }
      
    
}