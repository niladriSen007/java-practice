package dsa.graph;

import java.util.ArrayList;
import java.util.List;

class Graph {
    private final int vertices;
    private final List<List<Integer>> adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
    }

    public int getVertices() {
        return vertices;
    }

    public List<List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public void dfs(int startVertex, List<List<Integer>> adjList, boolean[] visited) {
        System.out.println(startVertex);
        visited[startVertex] = true;

        for (int vertex : adjList.get(startVertex)) {
            if (!visited[vertex]) {
                dfs(vertex, adjList, visited);
            }
        }
    }
}

public class Dfs {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);

        graph.dfs(0, graph.getAdjacencyList(), new boolean[graph.getVertices()]);

    }
}
