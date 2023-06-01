package src;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Vertex<V>>> adjacencyList;

    public WeightedGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex<V> vertex) {
        adjacencyList.put(vertex, new LinkedList<>());
    }

    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        validateVertex(source);
        validateVertex(destination);

        source.addAdjacentVertex(destination, weight);
        destination.addAdjacentVertex(source, weight);
    }

    private void validateVertex(Vertex<V> vertex) {
        if (!adjacencyList.containsKey(vertex))
            throw new IllegalArgumentException("Vertex " + vertex + " is not in the graph");
    }

    public void removeEdge(Vertex<V> source, Vertex<V> destination) {
        validateVertex(source);
        validateVertex(destination);

        source.getAdjacentVertices().remove(destination);
        destination.getAdjacentVertices().remove(source);
    }

    public boolean hasEdge(Vertex<V> source, Vertex<V> destination) {
        validateVertex(source);
        validateVertex(destination);

        return source.getAdjacentVertices().containsKey(destination);
    }
    public List<Vertex<V>> getNeighbors(Vertex<V> vertex) {
        validateVertex(vertex);
        return adjacencyList.get(vertex);
    }

    public void BFS(Vertex<V> start) {
        validateVertex(start);
        Map<Vertex<V>, Boolean> visited = new HashMap<>();
        for (Vertex<V> vertex : adjacencyList.keySet()) {
            visited.put(vertex, false);
        }

        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(start);
        visited.put(start, true);

        while (!queue.isEmpty()) {
            Vertex<V> currentVertex = queue.poll();
            System.out.println(currentVertex.getData() + " ");

            List<Vertex<V>> neighbors = adjacencyList.get(currentVertex);
            for (Vertex<V> neighbor : neighbors) {
                if (!visited.get(neighbor)) {
                    queue.add(neighbor);
                    visited.put(neighbor, true);
                }
            }
        }
        System.out.println();
    }

    public Map<Vertex<V>, Double> Dijkstra(Vertex<V> start) {
        validateVertex(start);

        Map<Vertex<V>, Double> distances = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> previous = new HashMap<>();

        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        for (Vertex<V> vertex : adjacencyList.keySet()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
            previous.put(vertex, null);
            queue.add(vertex);
        }

        distances.put(start, 0.0);

        while (!queue.isEmpty()) {
            Vertex<V> currentVertex = queue.poll();
            if (distances.get(currentVertex) == Double.POSITIVE_INFINITY) {
                break;
            }

            List<Vertex<V>> neighbors = adjacencyList.get(currentVertex);
            for (Vertex<V> neighbor : neighbors) {
                double newDistance = distances.get(currentVertex) + currentVertex.getAdjacentVertices().get(neighbor);
                if (newDistance < distances.get(neighbor)) {
                    queue.remove(neighbor);
                    distances.put(neighbor, newDistance);
                    previous.put(neighbor, currentVertex);
                    queue.add(neighbor);
                }
            }
        }
        return distances;
    }

    public void printGraph() {
        for (Map.Entry<Vertex<V>, List<Vertex<V>>> entry : adjacencyList.entrySet()) {
            Vertex<V> vertex = entry.getKey();
            List<Vertex<V>> neighbors = entry.getValue();
            System.out.print("Vertex " + vertex.getData() + " is connected to: ");
            for (Vertex<V> neighbor : neighbors) {
                System.out.print(neighbor.getData() + " ");
            }
            System.out.println();
        }
    }
}
