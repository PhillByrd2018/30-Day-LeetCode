package Challenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTree {

    public static List<Integer> inOrderTree(TreeNodePractice root) {
        List<Integer> ans = new ArrayList<>();

        inOrderTreeHelper(root, ans);
        return ans;
    }

    public static void inOrderTreeHelper(TreeNodePractice root, List<Integer> ansList) {

        if (root == null) {
            return;
        }

        inOrderTreeHelper(root.left, ansList);
        ansList.add(root.value);
        inOrderTreeHelper(root.right, ansList);

    }

    public static List<Integer> inOrderTreeIteratively(TreeNodePractice root) {
        
        List<Integer> res = new ArrayList<>();
        Stack<TreeNodePractice> stack = new Stack<>();

        TreeNodePractice curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.value);
            curr = curr.right;
        }

        return res;

    }

    public static void main(String[] args) {

        TreeNodePractice root = new TreeNodePractice(1);
        TreeNodePractice rootL = new TreeNodePractice(2);
        TreeNodePractice rootR = new TreeNodePractice(3);
        TreeNodePractice rootLL = new TreeNodePractice(4);
        TreeNodePractice rootLR = new TreeNodePractice(5);
        root.left = rootL;
        root.right = rootR;
        rootL.left = rootLL;
        rootL.right = rootLR;
        System.out.println("Expected: [4, 2, 5, 1, 3] :: Actual: " + inOrderTree(root));
    }
}