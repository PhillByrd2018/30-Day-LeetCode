package Challenger;

public class ConstructBinaryTreeFromPreordal {

    public static int[] testCase1 = { 8, 5, 1, 7, 10, 12 };

    public static TreeNodePractice bstFromPreorder(int[] preorder) {

        TreeNodePractice tnp = new TreeNodePractice(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            insertValue(tnp, preorder[i]);
        }

        printPreorderTree(tnp);

        return tnp;

    }

    public static void insertValue(TreeNodePractice root, int value) {
        root = insertNode(root, value);
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

    public static void printPreorderTree(TreeNodePractice tnp){
        if (tnp != null){
            System.out.println(tnp.value + " ");
            printPreorderTree(tnp.left);
            printPreorderTree(tnp.right);
        }

    }

    public static void main(String[] args) {
        TreeNodePractice test = bstFromPreorder(testCase1);
        System.out.println("Expected: [8,5,10,1,7,null,12] :: Actual: ");
        printPreorderTree(test);
    }
}