import java.util.*;
public class bfs{
    private int vertices;
    private List<List<Integer>> adjlist;
    public bfs(int vertices){
        this.vertices=vertices;
        adjlist=new ArrayList<>(vertices);
        for(int i=0;i<vertices;i++){
            adjlist.add(new ArrayList<>());

        }
    }
    public void addEdge(int src,int dest){
        adjlist.get(src).add(dest);
        adjlist.get(dest).add(src);
    }
    public void bfsal(int start){
        boolean[] visited=new boolean[vertices];
        Queue<Integer> queue=new LinkedList<>();
        visited[start]=true;
        queue.add(start);
        while(!queue.isEmpty()){
            int node=queue.poll();
            System.out.print(node+" ");
            for(int neighbor:adjlist.get(node)){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    queue.add(neighbor);
                }
            }
        }
    }
    public static void main(String[] args){
        bfs b=new bfs(6);
        b.addEdge(0, 1);
        b.addEdge(0, 2);
        b.addEdge(1, 3);
        b.addEdge(1, 4);
        b.addEdge(2, 5);
       
        System.out.println("bfs using adjacency list:");
        b.bfsal(0);

    }
}
