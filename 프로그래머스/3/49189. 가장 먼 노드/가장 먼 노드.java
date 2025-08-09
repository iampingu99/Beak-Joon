import java.util.*;

class Solution {
    
    // bfs: 1-based
    public int[] bfs(int start, int n, List<Integer>[] adj){
        Queue<Integer> deque = new ArrayDeque<>();
        int[] dist = new int[n + 1];
        deque.offer(start);
        dist[start] = 1;
        
        while(!deque.isEmpty()){
            int u = deque.poll();
            System.out.println();
            for(int v: adj[u]){
                if(dist[v] == 0){
                    deque.offer(v);
                    dist[v] = dist[u] + 1;
                }
            }
        }
        return dist;
    }
    
    public int solution(int n, int[][] edge) {
        
        // 0. 무방향 그래프
        List<Integer>[] adj = new ArrayList[n + 1];
        for(int i = 0; i<adj.length; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<edge.length; i++){
            adj[edge[i][0]].add(edge[i][1]);
            adj[edge[i][1]].add(edge[i][0]);
        }
        
        // 1. 탐색
        int[] dist = bfs(1, n, adj);
        
        // 2. 최대값 개수
        int max = 0, answer = 0;
        for(int i = 0; i<dist.length; i++){
            if(max == dist[i]) answer++;
            if(max < dist[i]) { 
                max = dist[i];
                answer = 1;
            }
        }
        
        return answer;
    }
}