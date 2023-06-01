## Lab6

This program implements a weighted graph data structure in Java. It provides functionalities to ***add vertices***, ***add edges*** between ***vertices*** with weights, perform ***breadth-first search (BFS)***, and ***Dijkstra's algorithm*** for finding the shortest paths in the graph.


## Usage
To use this program, you can follow these steps:

Create an instance of the WeightedGraph class.

Create Vertex instances for each vertex in the graph.

Add vertices to the graph using the addVertex method.

Add edges between vertices using the addEdge method, specifying the source vertex, destination vertex, and weight of the edge.

Perform BFS or Dijkstra's algorithm using the provided search classes (BreadthFirstSearch or DijkstraSearch) and passing the graph and a start vertex.

Retrieve the results or perform other operations as needed.
Here's an example usage:

```
WeightedGraph<String> graph = new WeightedGraph<>();

        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");
        Vertex<String> vertexE = new Vertex<>("E");

        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);
        graph.addVertex(vertexD);
        graph.addVertex(vertexE);

        graph.addEdge(vertexA, vertexB, 1.0);
        graph.addEdge(vertexA, vertexC, 2.0);
        graph.addEdge(vertexB, vertexD, 3.0);
        graph.addEdge(vertexC, vertexD, 1.5);
        graph.addEdge(vertexC, vertexE, 2.5);
        graph.addEdge(vertexD, vertexE, 1.0);

        graph.printGraph();

        Search<String> bfs = new BreadthFirstSearch<>(graph);
        System.out.println("BFS:");
        bfs.search(vertexA);

        Search<String> dijkstra = new DijkstraSearch<>(graph);
        System.out.println("Dijkstra:");
        dijkstra.search(vertexA);
    }

```

