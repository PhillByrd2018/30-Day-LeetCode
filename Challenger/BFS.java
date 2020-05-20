package Challenger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    
    public static List<List<Integer>> BFS(TreeNodePractice root){
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNodePractice> levelHolder = new LinkedList<>();
        levelHolder.add(root);
        while (!levelHolder.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int numberOfNodesOnLevel = levelHolder.size();

            for (int i =0; i< numberOfNodesOnLevel; i++) {
                TreeNodePractice currentNode = levelHolder.poll();
                level.add(currentNode.value);

                if (currentNode.left != null) {
                    levelHolder.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    levelHolder.add(currentNode.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }


    public static void main(String[] args) {
        TreeNodePractice root = new TreeNodePractice(0);
        TreeNodePractice rootL = new TreeNodePractice(9);
        TreeNodePractice rootR = new TreeNodePractice(12);
        TreeNodePractice rootLL = new TreeNodePractice(8);
        TreeNodePractice rootLR = new TreeNodePractice(5);
        root.left = rootL;
        root.right = rootR;
        rootL.left = rootLL;
        rootL.right = rootLR;
        System.out.println("Expected:  [[0], [9, 12], [8, 5]] :: Actual: " + BFS(root));
    }
}