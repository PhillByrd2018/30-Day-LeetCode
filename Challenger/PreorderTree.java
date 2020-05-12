package Challenger;

//Preorder traversal is used to create a copy of the tree

import java.util.ArrayList;
import java.util.List;

public class PreorderTree {
    
    public static List<Integer> preorder(TreeNodePractice root) {
        List<Integer> ans = new ArrayList<>();

        preorderHelper(root, ans);
        return ans;
    }

    public static void preorderHelper(TreeNodePractice root, List<Integer> ansList) {

        if (root == null) {
            return;
        }

        ansList.add(root.value);
        preorderHelper(root.left, ansList);
        preorderHelper(root.right, ansList);
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
        System.out.println("Expected: [1, 2, 4, 5, 3] :: Actual: " + preorder(root));
    }
}

//validation

//recursive 
    //helper method that takes in the root node and the List for the ans
        //if the node = null return
        // add the value of the current node to the list
        //call the helper with node.left and the list
        //call the helper with node.right and the list;
    //solution method
        //returns the list