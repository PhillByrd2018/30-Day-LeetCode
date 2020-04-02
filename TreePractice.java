package Practice;

import jdk.nashorn.api.tree.Tree;

public class TreePractice {

    public static void inOrderTraversal(TreeNode root){

        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.getValue() + " ");
            inOrderTraversal(root.right);
        }

    }

    public static void main(String[] args) {

        TreeNode testTree = new TreeNode(4);
        testTree.setLeft(9);
        testTree.setRight(7);


        testTree.showTree();

        inOrderTraversal(testTree);

        
    }
}