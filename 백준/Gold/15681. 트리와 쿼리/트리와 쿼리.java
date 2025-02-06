import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N; // 2 ≤ N ≤ 105
    static int R; // 1 ≤ R ≤ N
    static int Q; // 1 ≤ Q ≤ 105
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] counts;

    // dfs + memoization
    static int countConnectedComponent(int u) {
        visited[u] = true;
        counts[u] = 1;
        for (int v : graph[u]) {
            if (!visited[v]) {
                counts[u] += countConnectedComponent(v);
            }
        }
        return counts[u];
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        R = Integer.parseInt(param[1]);
        Q = Integer.parseInt(param[2]);

        graph = new ArrayList[N + 1];
        for (int u = 1; u <= N; u++) {
            graph[u] = new ArrayList<>();
        }

        // 0-1. 트리 간선 정보 입력: 양방향 그래프
        for (int i = 0; i < N - 1; i++) {
            param = br.readLine().split(" ");
            int u = Integer.parseInt(param[0]);
            int v = Integer.parseInt(param[1]);
            graph[u].add(v);
            graph[v].add(u);
        }

        // 1. 각 노드를 루트로 하는 서브트리의 개수 구하기 - dfs
        visited = new boolean[N + 1];
        counts = new int[N + 1];
        countConnectedComponent(R);

        // 2. 쿼리를 루트로 하는 서브 트리의 개수
        for (int i = 0; i < Q; i++) {
            int p = Integer.parseInt(br.readLine());
            answer.append(counts[p]).append("\n");
        }

        // 4. 출력
        System.out.println(answer);
    }
}
