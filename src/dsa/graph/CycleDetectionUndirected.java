package dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionUndirected {
    static boolean cycle = false;

    static void checkCycle(List<List<Integer>> adjacencyList,
                           int startNode, int parent, boolean[] visited) {
        visited[startNode] = true;
        List<Integer> neighbours = adjacencyList.get(startNode);
        for (Integer neighbour : neighbours) {
            if (visited[neighbour] && neighbour != parent) {
                cycle = true;
            }
            if (!visited[neighbour]) {
                checkCycle(adjacencyList, neighbour, startNode, visited);
            }
        }
        return;

    }

    public static boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        boolean[] visited = new boolean[V];

        // Initialize each node's adjacency list
        for (int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            adjacencyList.get(src).add(dest);
            adjacencyList.get(dest).add(src);
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                checkCycle(adjacencyList, i, -1, visited);
            }
        }
        return cycle;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        System.out.println(isCycle(4, edges));
    }
}
