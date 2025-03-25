import java.util.*;

public class DFSList {
    private int vertices;
    private List<List<Integer>> adjList;

    // Constructor
    public DFSList(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add an edge (undirected graph)
    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
        adjList.get(dest).add(src); // Remove this line for a directed graph
    }

    // DFS Algorithm
    public void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        dfsRecursive(start, visited);
    }

    private void dfsRecursive(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFSList graph = new DFSList(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        System.out.println("DFS using adjacency list:");
        graph.dfs(0);
    }
}
