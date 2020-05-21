package Challenger;

public class InvertBinaryTree {

    public static TreeNodePractice invertTree(TreeNodePractice root){

        if (root == null) {
            return root;
        }
        TreeNodePractice left = invertTree(root.left);
        TreeNodePractice right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
        
    }

    public static void main(String[] args) {

        TreeNodePractice testCaseRoot = new TreeNodePractice(4);

        TreeNodePractice testCaseL = new TreeNodePractice(2);
        TreeNodePractice testCaseR = new TreeNodePractice(7);
        testCaseRoot.left = testCaseL;
        testCaseRoot.right = testCaseR;

        TreeNodePractice testCaseLL = new TreeNodePractice(1);
        TreeNodePractice testCaseLR = new TreeNodePractice(3);
        testCaseL.left = testCaseLL;
        testCaseL.right = testCaseLR;

        TreeNodePractice testCaseRL = new TreeNodePractice(6);
        TreeNodePractice testCaseRR = new TreeNodePractice(9);
        testCaseR.left = testCaseRL;
        testCaseR.right =testCaseRR;
        
        invertTree(testCaseRoot);
    }

}
