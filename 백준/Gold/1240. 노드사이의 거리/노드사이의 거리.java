import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N; // 2 ≤ N ≤ 1,000
    static int M; // 1 ≤ M ≤ 1,000
    static List<Edge>[] adj;
    static boolean[] visited;
    static int answer;

    static class Edge {
        int to;
        int dist;

        public Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    static void dfs(int u, int v, int dist) {
        if (u == v) {
            answer = dist;
        }
        visited[u] = true;
        for (Edge edge : adj[u]) {
            if (!visited[edge.to]) {
                dfs(edge.to, v, dist + edge.dist);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        // 0-1. 인접 노드 목록: 연결 리스트
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        // 0-2. 간선 정보 입력: 무방향 그래프
        for (int i = 0; i < N - 1; i++) {
            param = br.readLine().split(" ");
            int u = Integer.parseInt(param[0]);
            int v = Integer.parseInt(param[1]);
            int dist = Integer.parseInt(param[2]);

            adj[u].add(new Edge(v, dist));
            adj[v].add(new Edge(u, dist));
        }

        // 1. 두 노드간의 거리 계산: dfs
        for (int i = 0; i < M; i++) {
            param = br.readLine().split(" ");
            int u = Integer.parseInt(param[0]);
            int v = Integer.parseInt(param[1]);

            visited = new boolean[N + 1];
            dfs(u, v, 0);
            System.out.println(answer);
        }
    }
}
