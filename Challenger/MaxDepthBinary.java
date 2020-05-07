package Challenger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxDepthBinary {
    public static int maxDepth(TreeNodePractice root) {
        List<Integer> heightList = new ArrayList<>();
        
        DFS(root, 1, heightList);
        return Collections.max(heightList);
    }

    public static void DFS(TreeNodePractice node, int height, List<Integer> heightList) {
        if (node == null) {
            return; 
        }
        heightList.add(height++);
        DFS(node.left, height, heightList);
        DFS(node.right, height, heightList);
    } 

    public static void main(String[] args) {
        TreeNodePractice root1 = new TreeNodePractice(3);

        TreeNodePractice rootL = new TreeNodePractice(9);
        TreeNodePractice rootR = new TreeNodePractice(20);

        TreeNodePractice rootRL = new TreeNodePractice(15);
        TreeNodePractice rootRR = new TreeNodePractice(7);

        TreeNodePractice rootRRR = new TreeNodePractice(7);

        TreeNodePractice rootRRRR = new TreeNodePractice(7);
       
        root1.left = rootL;
        root1.right = rootR;
        root1.right.left = rootRL;
        root1.right.right = rootRR;
        root1.right.right.right = rootRRR;
        root1.right.right.right.right = rootRRRR;
        System.out.println("Expected:  4 :: Actual: " + maxDepth(root1));

        TreeNodePractice root2 = new TreeNodePractice(1);
        TreeNodePractice root2L = new TreeNodePractice(2);
        TreeNodePractice root2R = new TreeNodePractice(3);


        root2.left = root2L;
        root2.right = root2R;
        
        System.out.println("Expected:  2 :: Actual: " + maxDepth(root2));
    }
}