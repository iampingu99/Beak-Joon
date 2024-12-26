import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; //1 ≤ N ≤ 100
    static int M;
    static boolean[][] graph;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        while (M-- > 0) {
            String[] param = br.readLine().split(" ");
            int u = Integer.parseInt(param[0]);
            int v = Integer.parseInt(param[1]);
            graph[u][v] = true;
            graph[v][u] = true;
        }
        visited[1] = true;
        dfs(1);
        System.out.println(answer);
    }

    static void dfs(int depth) {
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[depth][i]) {
                visited[i] = true;
                answer++;
                dfs(i);
            }
        }
    }
}
