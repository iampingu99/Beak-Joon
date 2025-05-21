import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.stream.IntStream;

public class Main {
    static int N, M; // 2 ≤ N(도시 수) ≤ 300,000, 1 ≤ M(도로 수) ≤ 1,000,000,
    static int K, X; // 1 ≤ K(거리) ≤ 300,000, 1 ≤ X(출발 도시) ≤ N
    static ArrayList<Integer>[] adj;
    static int[] distTo;

    static void bfs(int u) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(u);
        distTo[u] = 0;
        visited[u] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : adj[v]) {
                if (!visited[w]) {
                    queue.offer(w);
                    distTo[w] = distTo[v] + 1;
                    visited[w] = true;
                }
            }
        }
    }

    static StringBuilder print() {
        StringBuilder sb = new StringBuilder();
        IntStream.rangeClosed(1, N)
                .filter(i -> distTo[i] == K)
                .forEach(i -> sb.append(i).append(" "));
        return sb.length() == 0 ? sb.append(-1) : sb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);
        K = Integer.parseInt(param[2]);
        X = Integer.parseInt(param[3]);

        adj = new ArrayList[N + 1];
        distTo = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            param = br.readLine().split(" ");
            int u = Integer.parseInt(param[0]);
            int v = Integer.parseInt(param[1]);
            adj[u].add(v);
        }

        bfs(X);
        System.out.println(print());
    }
}
