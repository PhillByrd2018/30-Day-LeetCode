package Challenger;

import java.util.HashMap;
import java.util.Map;

public class Cousins {

    static Map<Integer, Integer> depthMap;
    static Map<Integer, TreeNodePractice> parentMap;

    public static boolean isCousins(TreeNodePractice root, int x, int y) {

        depthMap = new HashMap<>();
        parentMap = new HashMap<>();

        DFS(root, null);
        return depthMap.get(x) == depthMap.get(y) && parentMap.get(x) != parentMap.get(y);
    }

    public static void DFS(TreeNodePractice node, TreeNodePractice parentNode) {
        if (node != null) {
            parentMap.put(node.value, parentNode);
            depthMap.put(node.value, depthMap.getOrDefault(node.value, 0)+1);
            DFS(node.left, node);
            DFS(node.right, node);
        }
    }

    public static void main(String[] args) {
        TreeNodePractice root = new TreeNodePractice(1);
        TreeNodePractice rootL = new TreeNodePractice(2);
        TreeNodePractice rootR = new TreeNodePractice(3);
        TreeNodePractice rootLL = new TreeNodePractice(4);
        TreeNodePractice rootRR = new TreeNodePractice(5);
        root.left = rootL;
        root.right = rootR;
        rootR.right = rootRR;
        rootL.left = rootLL;

        System.out.println("Expected: true :: Actual: " + isCousins(root, 5, 4));

    }
}