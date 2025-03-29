public class dijkstra_algorithm_am{
    static final int INF=999;
    private static int chooseminvertex(int[] dist,boolean[] visited,int n){
        int min_index=-1;int min=INF;
        for(int i=0;i<n;i++){
            if(!visited[i]&&dist[i]<min){
                min=dist[i];
                min_index=i;
            }
            
        }
        return min_index;
        
    }
    private static void shortestpath(int v,int[][] cost,int[] dist,int n ){
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            dist[i]=cost[v][i];
        }
        dist[v]=0;
        visited[v]=true;
        for(int rep=1;rep<n;rep++){
            int u=chooseminvertex(dist,visited,n);
            if(u==-1)
                break;
            visited[u]=true;
            for(int w=0;w<n;w++){
                if(!visited[w]&&cost[u][w]!=INF && dist[u]+cost[u][w]<dist[w]){
                    dist[w]=cost[u][w]+dist[u];
                    
                }
            }
        }
    }
    public static void main(String[] args){
        int n=3;
        int[][] cost={
            {0,4,10},{999,0,3},{999,999,0}
        };
        int source=0;
        int [] dist=new int[n];
        shortestpath(source,cost,dist,n);
        for(int i=0;i<n;i++){
            System.out.println("vertex\t "+i+":"+dist[i]);
        }
    }
}
