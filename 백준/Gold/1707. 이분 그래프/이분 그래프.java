import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static final int RED = 1;
    static final int BLUE = -1;

    static int K; // 2 ≤ K ≤ 5
    static int V; // 1 ≤ V ≤ 20,000
    static int E; //1 ≤ E ≤ 200,000
    static ArrayList<Integer>[] graph;
    static int[] colors;
    static boolean isBipartite;

    // 그래프 dfs 순회 + 이분 그래프 검사
    static void dfs(int u, int color) {
        colors[u] = color;
        for (Integer v : graph[u]) {
            if (colors[v] == colors[u]) {
                isBipartite = false;
            }
            if (colors[v] == 0) {
                dfs(v, -color);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            String[] param = br.readLine().split(" ");
            V = Integer.parseInt(param[0]);
            E = Integer.parseInt(param[1]);

            graph = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }
            colors = new int[V + 1];

            // 1. 양방향 그래프 정보 채우기(연결 리스트)
            for (int i = 1; i <= E; i++) {
                param = br.readLine().split(" ");
                int u = Integer.parseInt(param[0]);
                int v = Integer.parseInt(param[1]);
                graph[u].add(v);
                graph[v].add(u);
            }

            // 2. dfs
            isBipartite = true;
            for (int i = 1; i <= V; i++) {
                if (!isBipartite) {
                    break;
                }
                if (colors[i] == 0) {
                    dfs(i, RED);
                }
            }

            // 3. 출력
            answer.append(isBipartite ? "YES" : "NO").append("\n");
        }
        System.out.println(answer);
    }
}
