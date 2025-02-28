import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N; // 5 ≤ N ≤ 100
    static int M; // 0 ≤ M ≤ 2,000
    static List<Integer>[] forward;
    static List<Integer>[] backward;
    static boolean[] visited;
    static int count;

    // graph traversal
    static void dfs(int u, List<Integer>[] graph) {
        visited[u] = true;
        for (int v : graph[u]) {
            if (!visited[v]) {
                dfs(v, graph);
                count++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        forward = new ArrayList[N + 1];
        backward = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            forward[i] = new ArrayList<>();
            backward[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] param = br.readLine().split(" ");
            int u = Integer.parseInt(param[0]);
            int v = Integer.parseInt(param[1]);
            forward[u].add(v);
            backward[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            count = 1;
            dfs(i, forward);
            dfs(i, backward);
            System.out.println(N - count);
        }
    }
}
