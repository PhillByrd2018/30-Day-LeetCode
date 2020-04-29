package Challenger;

public class ClosestBinarySearchTreeValue {

    public static long minDistance;
    public static int currentBestNode;

    public static int closestValue(TreeNodePractice root, double target) {
        int closest = (int) Math.round(target);
        if (root.left == null && root.right == null) {
            return root.value;
        }

        minDistance = (long) Math.abs((long)root.value - (long)target);
        return (int)closestValueHelper(root, closest, minDistance);
    }

    public static long closestValueHelper(TreeNodePractice root, int target, long minDistance) {

        if (root == null) {
            return 0;
        }

        long currentValue = (long) Math.abs((long)root.value - (long)target);

        if (currentValue <= minDistance) {
            currentBestNode = root.value;
            minDistance = currentValue;
        }

        closestValueHelper(root.left, target, minDistance);

        closestValueHelper(root.right, target, minDistance);

        return currentBestNode;
    }

    public static TreeNodePractice insertNode(TreeNodePractice root, int valueToInsert) {

        if (root == null) {
            root = new TreeNodePractice(valueToInsert);
            return root;
        }

        if (valueToInsert < root.value) {
            root.left = insertNode(root.left, valueToInsert);

        } else {
            root.right = insertNode(root.right, valueToInsert);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNodePractice root = new TreeNodePractice(4);
        insertNode(root, 2);
        insertNode(root, 5);
        insertNode(root, 1);
        insertNode(root, 3);

        System.out.println("Expected: 4 :: Actual: " + closestValue(root, 3.714));
        System.out.println("Expected: 3 :: Actual: " + closestValue(root, 3.124));

        TreeNodePractice root2 = new TreeNodePractice(2);
        insertNode(root2, 1);

        System.out.println("Expected: 2 :: Actual: " + closestValue(root2, 2147483647.0));


        TreeNodePractice root3 = new TreeNodePractice(1500000000);
        insertNode(root3, 1400000000);
        System.out.println("Expected: 1400000000 :: Actual: " + closestValue(root3, -1500000000));

    }
}