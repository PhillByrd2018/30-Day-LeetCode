package Challenger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthSmallestInTree {

    public static int kthSmallest(TreeNodePractice root, int k) {

        // validations
        if (root == null) {
            return 0;
        }
        List<Integer> ans = new ArrayList<>();
        ans = helper(root, ans);

        //We don't need this part. An in order traversal will automatically sort a BST.
        // Collections.sort(ans);
        return ans.get(k - 1);
    }

    public static List<Integer> helper(TreeNodePractice root, List<Integer> list) {

        if (root == null) {
            return list;
        }
        helper(root.left, list);
        list.add(root.value);
        helper(root.right, list);

        return list;
    }

    public static void main(String[] args) {

        TreeNodePractice root = new TreeNodePractice(3);
        TreeNodePractice rootL = new TreeNodePractice(1);
        TreeNodePractice rootR = new TreeNodePractice(4);
        TreeNodePractice rootLR = new TreeNodePractice(2);
        root.left = rootL;
        root.right = rootR;
        rootL.right = rootLR;
        System.out.println("Expected: 1 :: Actual: " + kthSmallest(root, 1));

        TreeNodePractice root2 = new TreeNodePractice(3);
        root.left = rootL;
        root.right = rootR;
        rootL.right = rootLR;
    }
}