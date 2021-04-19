import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class Graph {

    private Set<Integer>[] edges;

    public Graph(int size) {
        edges = new HashSet[size];
        for (int i = 0; i < size; i++) {
            edges[i] = new HashSet<>();
        }
    }

    public void addEdge(Pair<Integer, Integer> edge) {
        edges[edge.getKey()].add(edge.getValue());
        edges[edge.getValue()].add(edge.getKey());
    }

    public int DFS(int startVertex) {
        boolean[] visited = new boolean[edges.length];
        return DFS(startVertex, visited);
    }

    private int DFS(int vertex, boolean[] visited) {
        visited[vertex] = true;
        Set<Integer> edge = edges[vertex];
        return edge.stream()
                .filter(edgeVertex -> !visited[edgeVertex])
                .map(edgeVertex -> DFS(edgeVertex, visited))
                .reduce((x, y) -> x + y)
                .orElse(0) + 1;
    }

}
