package Challenger;

import java.util.ArrayList;
import java.util.List;

public class PostorderTree {
    
    public static List<Integer> postOrderTree(TreeNodePractice root) {
        List<Integer> ans = new ArrayList<>();

        postOrderTreeHelper(root, ans);
        return ans;
    }

    public static void postOrderTreeHelper(TreeNodePractice root, List<Integer> ansList) {

        if (root == null) {
            return;
        }
        
        postOrderTreeHelper(root.left, ansList);
        postOrderTreeHelper(root.right, ansList);
        ansList.add(root.value);
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
        System.out.println("Expected: [4, 5, 2, 3, 1] :: Actual: " + postOrderTree(root));
    }
    
}