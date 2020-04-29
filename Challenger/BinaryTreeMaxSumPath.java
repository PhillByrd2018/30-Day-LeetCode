package Challenger;

public class BinaryTreeMaxSumPath {

    public static int max_sum_path;

    public static int maxPathSum(TreeNodePractice root) {
        max_sum_path = Integer.MIN_VALUE;
        maxSumPathCalc(root);
        return max_sum_path;

    }

    public static int maxSumPathCalc(TreeNodePractice root) {
        if (root == null) {
            return 0;
        }

        int gainsFromTheLeft = Math.max(maxSumPathCalc(root.left), 0);
        int gainsFromTheRight = Math.max(maxSumPathCalc(root.right), 0);

        int newPathValue = root.value + gainsFromTheLeft + gainsFromTheRight;

        max_sum_path = Math.max(max_sum_path, newPathValue);

        return root.value + Math.max(gainsFromTheLeft, gainsFromTheRight);
    }

    public static void main(String[] args) {
        // TreeNodePractice testCaseRoot = new TreeNodePractice(-10);
        // TreeNodePractice testCaseL = new TreeNodePractice(9);
        // TreeNodePractice testCaseR = new TreeNodePractice(20);
        // TreeNodePractice testCase1RL = new TreeNodePractice(15);
        // TreeNodePractice testCase1RR = new TreeNodePractice(7);
        // testCaseRoot.left = testCaseL;
        // testCaseRoot.right = testCaseR;
        // testCaseR.left = testCase1RL;
        // testCaseR.right = testCase1RR;
    
        // System.out.println("Expected: 42 :: Actual: " + maxPathSum(testCaseRoot));


        TreeNodePractice testCaseRoot2 = new TreeNodePractice(1);
        TreeNodePractice testCaseL2 = new TreeNodePractice(2);
        TreeNodePractice testCaseR2 = new TreeNodePractice(3);

        testCaseRoot2.left = testCaseL2;
        testCaseRoot2.right = testCaseR2;
        System.out.println("Expected: 6 :: Actual: " + maxPathSum(testCaseRoot2));
    }
}