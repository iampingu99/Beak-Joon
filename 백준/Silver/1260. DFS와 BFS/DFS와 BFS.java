import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
    static int N; // 1 ≤ N ≤ 1,000
    static int M; // 1 ≤ M ≤ 10,000
    static int V;
    static boolean[][] graph;
    static boolean[] visited;
    static List<Integer> dfsOrder;
    static List<Integer> bfsOrder;

    static void dfs(int u) {
        visited[u] = true;
        dfsOrder.add(u);
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[u][i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int u) {
        Deque<Integer> queue = new ArrayDeque<>();
        visited[u] = true;
        queue.add(u);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            bfsOrder.add(v);
            for (int i = 1; i <= N; i++) {
                if (graph[v][i] && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);
        V = Integer.parseInt(param[2]);

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        dfsOrder = new ArrayList<>();
        bfsOrder = new ArrayList<>();

        // 1. 무방향 그래프 연결 정보 채우기(행렬): 입력으로 주어지는 간선은 양방향이다.
        while (M-- > 0) {
            param = br.readLine().split(" ");
            int x = Integer.parseInt(param[0]);
            int y = Integer.parseInt(param[1]);
            graph[x][y] = true;
            graph[y][x] = true;
        }

        // 2. dfs / bfs
        dfs(V);
        visited = new boolean[N + 1];
        bfs(V);

        // 3. 출력
        for (int u : dfsOrder) {
            answer.append(u).append(" ");
        }
        answer.append("\n");
        for (int u : bfsOrder) {
            answer.append(u).append(" ");
        }

        System.out.println(answer);
    }
}
