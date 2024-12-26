import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static int N; // 5 ≤ N ≤ 100,000
    static int M; // 1 ≤ M ≤ 200,000
    static int R; // 1 ≤ R ≤ N
    static List<Integer>[] graph;
    static int[] visited;
    static int order = 1;

    static void dfs(int idx) {
        visited[idx] = order++;
        for (int v : graph[idx]) {
            if (visited[v] == 0) {
                dfs(v);
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
        R = Integer.parseInt(param[2]);

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new int[N + 1];

        // 1. 무방향 그래프 연결 정보 채우기(인접리스트)
        while (M-- > 0) {
            param = br.readLine().split(" ");
            int u = Integer.parseInt(param[0]);
            int v = Integer.parseInt(param[1]);
            graph[u].add(v);
            graph[v].add(u);
        }

        // 2. 내림차순 정렬
        for (int i = 1; i <= N; i++) {
            graph[i] = graph[i].stream()
                    .sorted(Collections.reverseOrder())
                    .collect(Collectors.toList());
        }

        // 3. dfs
        dfs(R);

        // 4. 출력
        for (int i = 1; i <= N; i++) {
            answer.append(visited[i]).append("\n");
        }
        System.out.println(answer);
    }
}
