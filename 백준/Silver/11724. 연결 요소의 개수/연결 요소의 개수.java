import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] edge = new int[m][1];
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edge[i] = new int[]{u, v};
        }
        System.out.println(solution(n, m, edge));
    }

    public static int solution(int n, int m, int[][] edge){
        boolean[][] graph = new boolean[n+1][n+1];
        for(int[] e : edge){
            int u = e[0];
            int v = e[1];
            graph[u][v] = true;
            graph[v][u] = true;
        }
        boolean[] isVisited = new boolean[n+1];
        int answer = 0;
        for(int u = 1; u<graph.length; u++){
            if(!isVisited[u]) {
                bfs(u, graph, isVisited);
                answer++;
            }
        }
        return answer;
    }

    public static void bfs(int u, boolean[][] graph, boolean[] isVisited){
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        isVisited[u] = true;
        while(!q.isEmpty()){
            int start = q.poll();
            for(int v = 1; v < graph.length; v++){
                if(graph[start][v] && !isVisited[v]) {
                    isVisited[v] = true;
                    q.add(v);
                }
            }
        }
    }
}