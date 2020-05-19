package Challenger;

public class ValidBST {

    public static boolean isValidBST(TreeNodePractice root) {
        if (root == null) {
            return true;
        }

        return isValidHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidHelper(TreeNodePractice node, long minValue, long maxValue) {

        if (node == null) {
            return true;
        }

        if (node.value <= minValue || node.value >= maxValue) {
            return false;
        }
        return isValidHelper(node.left, minValue, node.value) && isValidHelper(node.right, node.value, maxValue);
    }

    public static void main(String[] args) {

        TreeNodePractice root = new TreeNodePractice(1);
        TreeNodePractice rootL = new TreeNodePractice(2);
        TreeNodePractice rootR = new TreeNodePractice(3);
        TreeNodePractice rootRL = new TreeNodePractice(4);
        TreeNodePractice rootRR = new TreeNodePractice(5);
        root.left = rootL;
        root.right = rootR;
        rootR.left = rootRL;
        rootR.right = rootRR;
        System.out.println("Expected: false :: Actual: " + isValidBST(root));

        root.left = null;
        rootR.left = null;
        System.out.println("Expected: true :: Actual: " + isValidBST(root));
    }
}