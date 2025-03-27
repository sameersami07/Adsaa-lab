import java.util.*;
public class Graph{
    static class edge{
        int dest, weight;
        public edge(int dest,int weight){
            this.dest=dest;
            this.weight=weight;
        }
    }
    private int vertices;
    private List<List<edge>> adjlist;
    public Graph(int vertices) {
        this.vertices = vertices;
        adjlist = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjlist.add(new ArrayList<>());
        }
    }
    public void addedge(int src,int dest,int weight){
        adjlist.get(src).add(new edge(dest, weight));
        adjlist.get(dest).add(new edge(src,weight));
    }
    public void shortestpath(int source){
        int[] dist=new int [vertices];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source]=0;
        PriorityQueue<edge> pq=new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
     
        pq.add(new edge(source,0));
        while(!pq.isEmpty()){
            edge current=pq.poll();
            int u=current.dest;
            for(edge neigbor:adjlist.get(u)){
                int v=neigbor.dest;
                int weight=neigbor.weight;
                if(dist[u]+weight<dist[v]){
                    dist[v]=weight+dist[u];
                    pq.add(new edge(v, dist[v]));
                }

            }
        }
        System.out.println("vertex \t distence fromthe source"+source);
        for(int i=0;i<vertices;i++){
            System.out.println(i+"\t"+dist[i]);
        }    


    }
    public static void main(String[] args){
        Graph graph = new Graph(5);
        graph.addedge(0, 1, 2);
        graph.addedge(0, 3, 6);
        graph.addedge(1, 2, 3);
        graph.addedge(1, 3, 8);
        graph.addedge(1, 4, 5);
        graph.addedge(2, 4, 7);
        graph.addedge(3, 4, 9);

        System.out.println("Shortest Paths from Source 0:");
        graph.shortestpath(0);
    }
}
