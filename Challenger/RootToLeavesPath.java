package Challenger;

public class RootToLeavesPath {

    public static int[] testCase1 = { 0, 1, 0, 1 };
    public static int[] testCase2 = { 0, 0, 1 };
    public static int[] testCase3 = { 0, 1, 1 };

    public static boolean isValidSequence(TreeNodePractice root, int[] arr) {

        if (root.left == null && root.right == null) {
            return true;
        }

        return isValidSequenceHelper(root, arr, 0);
    }

    public static boolean isValidSequenceHelper(TreeNodePractice root, int[] arr, int index) {
        if (root == null) {
            return false;
        }

        if (root.value != arr[index]) {
            return false;
        }

        if (index + 1 == arr.length) {
            return root.left == null && root.right == null;
        }

        return isValidSequenceHelper(root.left, arr, index + 1) || isValidSequenceHelper(root.right, arr, index + 1);
    }

    public static void main(String[] args) {
        TreeNodePractice root = new TreeNodePractice(0);
        TreeNodePractice rootL = new TreeNodePractice(1);
        TreeNodePractice rootR = new TreeNodePractice(0);
        TreeNodePractice rootLL = new TreeNodePractice(0);
        TreeNodePractice rootLR = new TreeNodePractice(1);
        TreeNodePractice rootLLR = new TreeNodePractice(1);
        TreeNodePractice rootLRR = new TreeNodePractice(0);
        TreeNodePractice rootLRL = new TreeNodePractice(0);
        TreeNodePractice rootRL = new TreeNodePractice(0);

        root.left = rootL;
        root.right = rootR;
        rootR.left = rootRL;

        rootL.left = rootLL;
        rootL.right = rootLR;

        rootLR.left = rootLRL;
        rootLR.right = rootLRR;

        rootLL.right = rootLLR;

        System.out.println("Expected: True :: Actual: " + isValidSequence(root, testCase1));
        System.out.println("Expected: False :: Actual: " + isValidSequence(root, testCase2));
        System.out.println("Expected: False :: Actual: " + isValidSequence(root, testCase3));
    }
}