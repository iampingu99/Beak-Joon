import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 2 ≤ N ≤ 10
    static int[][] graph; // 0 ≤ i ≤ 1,000,000
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    // 조건 경로 경우의 수: 순열 + 최소 비용
    static void permutation(int u, int k, int[] path, int price) {
        visited[u] = true;
        path[k] = u;
        if (k == N - 1) {
            if (graph[u][path[0]] > 0) {
                answer = Math.min(answer, price + graph[u][path[0]]);
            }
            visited[u] = false;
            return;
        }
        for (int v = 0; v < N; v++) {
            if (!visited[v] && graph[u][v] > 0) {
                permutation(v, k + 1, path, price + graph[u][v]);
            }
        }
        visited[u] = false;
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        // 0-1. 도시 및 비용 입력: 2차원 배열
        for (int i = 0; i < N; i++) {
            String[] param = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(param[j]);
            }
        }

        // 1. dfs graph traversal
        visited = new boolean[N];
        permutation(0, 0, new int[N], 0);

        System.out.println(answer);
    }
}
