package Challenger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {

        // HashSet used as adjacencySet dataStructure for Graph. If duplicate nodes are
        // allowed then use List.
        Set<Integer>[] graph = new HashSet[N + 1];
        // Vertex 0 has no data in this graph as per problem statement. So, start at 1.
        for (int i = 1; i <= N; ++i) {
            // Initialize HashSet
            graph[i] = new HashSet<>();
        }

        for (int i = 0; i < dislikes.length; ++i) {
            int source = dislikes[i][0], target = dislikes[i][1];
            // Add edges in both direction to create undirected graph
            graph[source].add(target);
            graph[target].add(source);
        }

        int colors[] = new int[N + 1];
        // Initially no one belongs to any group. So, initialize every node to -1.
        Arrays.fill(colors, -1);
        for (int v = 1; v < graph.length; ++v) {
            // Start dfs only if current node is not part of any group. If node is not
            // assigned to group and dfs returns false then it's not possible to
            // bi-partition this graph. So, answer is false.
            if (colors[v] == -1 && !dfs(graph, v, colors, 0))
                return false;
        }
        // if we are able to visit all nodes then answer is yes. We are able to split
        // the nodes into 2 different groups.
        return true;
    }

    // DFS returns true only 2 conditions.
    // 1. We reached all nodes from the current source vertex - s
    // 2. We reached the already visited and that belongs the the same team we
    // expect.
    boolean dfs(Set<Integer>[] graph, int s, int[] colors, int color) {
        if (colors[s] != -1) {
            return colors[s] == color;
        }
        colors[s] = color;
        for (int w : graph[s]) {
            if (!dfs(graph, w, colors, 1 - color))
                return false;
        }
        return true;
    }
}