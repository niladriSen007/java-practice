package dsa.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {
    public static void main(String[] args) {
        int vertices = 5;
        List<List<Integer>> adjacencyList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}, {2, 4}, {3, 4}};

        for(int[] edge:edges){
            int src = edge[0];
            int dest = edge[1];
            adjacencyList.get(src).add(dest);
            adjacencyList.get(dest).add(src);
        }

        for(int i=0;i<vertices;i++){
            System.out.println(i + " -> " + adjacencyList.get(i));
        }
    }
}
