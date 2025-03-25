import java.util.*;

public class BFSMatrix {
    private int vertices;
    private int[][] adjMatrix; // Adjacency Matrix

    // Constructor
    public BFSMatrix(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices]; // Initialize matrix with 0s
    }

    // Add an edge (undirected graph)
    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1; // Remove this for a directed graph
    }

    // BFS Algorithm
    public void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            // Check all possible neighbors (matrix row)
            for (int i = 0; i < vertices; i++) {
                if (adjMatrix[node][i] == 1 && !visited[i]) { // If connected and not visited
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSMatrix graph = new BFSMatrix(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        System.out.println("BFS using adjacency matrix:");
        graph.bfs(0);
    }
}
