import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N; // 2 ≤ N ≤ 100,000
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;

    // dfs 순회 + 부모 노드 찾기
    static void dfs(int u) {
        visited[u] = true;
        for (int v : graph[u]) {
            if (!visited[v]) {
                answer[v] = u;
                dfs(v);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        answer = new int[N + 1];

        // 1. 트리 연결 정보 채우기(행렬)
        while (N-- > 1) {
            String[] param = br.readLine().split(" ");
            int x = Integer.parseInt(param[0]);
            int y = Integer.parseInt(param[1]);
            graph[x].add(y);
            graph[y].add(x);
        }

        // 2. dfs
        dfs(1);

        // 3. 출력
        for (int i = 2; i < answer.length; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }
}
