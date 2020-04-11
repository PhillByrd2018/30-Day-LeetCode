
public class DiameterOfATree {

    public static int response;
    public static int findDiameter(TreeNodePractice root){

        response = 1;
        height(root);
        return response - 1;
    }

    public static int height(TreeNodePractice node) {
        if (node == null) return 0;
        int L = height(node.left);
        int R = height(node.right);
        response = Math.max(response, L+R+1);
        return Math.max(L, R) + 1;
    }


    public static void main(String[] args) {

        TreeNodePractice testCase1 = new TreeNodePractice(1);
        TreeNodePractice testCase2 = new TreeNodePractice(2);
        TreeNodePractice testCase3 = new TreeNodePractice(3);
        TreeNodePractice testCase4 = new TreeNodePractice(4);
        TreeNodePractice testCase5 = new TreeNodePractice(5);

        testCase1.left = testCase2;
        testCase1.right = testCase3;
        testCase2.left = testCase4;
        testCase2.right = testCase5;

        testCase1.showTree();

        System.out.println("Expected: 3 :: " + findDiameter(testCase1));
    }
 
}

