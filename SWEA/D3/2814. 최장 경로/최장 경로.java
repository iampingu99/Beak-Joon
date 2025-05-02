import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    static int T; // T(테스트)
    static int N, M; // 1 ≤ N(정점) ≤ 10, 0 ≤ M(간선) ≤ 20
    static List<Integer>[] adj;
    static boolean[] visited;
    static int answer;

    static void dfs(int u, int distance) {
        visited[u] = true;
        answer = Math.max(answer, distance);

        for (int v : adj[u]) {
            if (!visited[v]) {
                dfs(v, distance + 1);
            }
        }
        visited[u] = false;
    }

    static int bfs(int u) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{u, 1});
        visited[u] = true;

        int maxDistance = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int v = curr[0];
            int d = curr[1];
            maxDistance = Math.max(maxDistance, d);

            for (int w : adj[v]) {
                if (!visited[w]) {
                    queue.add(new int[]{w, d + 1});
                    visited[w] = true;
                }
            }
        }
        return maxDistance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] param = br.readLine().split(" ");
            N = Integer.parseInt(param[0]);
            M = Integer.parseInt(param[1]);

            adj = new List[N + 1];
            for (int u = 1; u <= N; u++) {
                adj[u] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                param = br.readLine().split(" ");
                int u = Integer.parseInt(param[0]);
                int v = Integer.parseInt(param[1]);
                adj[u].add(v);
                adj[v].add(u);
            }

            answer = 0;

            for (int u = 1; u <= N; u++) {
                visited = new boolean[N + 1];
                dfs(u, 1);
            }

            System.out.printf("#%d %d\n", t, answer);
        }
    }
}
