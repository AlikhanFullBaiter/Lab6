package src;

public class DijkstraSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;

    public void BreadthFirstSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    @Override
    public void search(Vertex<V> start) {
        graph.BFS(start);
    }
}
