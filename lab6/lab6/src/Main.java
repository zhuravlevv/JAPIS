import javafx.util.Pair;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(new Pair<>(0, 1));
        graph.addEdge(new Pair<>(1, 6));
        graph.addEdge(new Pair<>(6, 3));
        graph.addEdge(new Pair<>(6, 4));
        graph.addEdge(new Pair<>(6, 1));
        graph.addEdge(new Pair<>(3, 1));
        graph.addEdge(new Pair<>(7, 5));
        graph.addEdge(new Pair<>(7, 8));
        graph.addEdge(new Pair<>(2, 9));
        System.out.println("Количество связных компонент для вершины #" + 0 + ": " + graph.DFS(0));
        System.out.println("Количество связных компонент для вершины #" + 2 + ": " + graph.DFS(2));
        System.out.println("Количество связных компонент для вершины #" + 5 + ": " + graph.DFS(5));
    }
}
