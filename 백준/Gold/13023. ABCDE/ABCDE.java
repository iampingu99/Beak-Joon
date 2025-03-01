import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static final int MAX_DEPTH = 4;
    static int N; // 5 ≤ N ≤ 2000
    static int M; // 1 ≤ M ≤ 2000
    static List<Integer>[] adj;
    static boolean[] visited;
    static boolean answer;

    static void dfs(int u, int depth) {
        if (depth == MAX_DEPTH) {
            answer = true;
            return;
        }

        visited[u] = true;
        for (int v : adj[u]) {
            if (!visited[v]) {
                dfs(v, depth + 1);
                visited[v] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            param = br.readLine().split(" ");
            int u = Integer.parseInt(param[0]);
            int v = Integer.parseInt(param[1]);
            adj[u].add(v);
            adj[v].add(u);
        }

        for (int v = 0; v < N; v++) {
            visited = new boolean[N];
            dfs(v, 0);
            if (answer) break;
        }

        System.out.println(answer ? 1 : 0);
    }
}
