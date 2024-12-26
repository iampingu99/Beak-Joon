import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; //1 ≤ n ≤ 100
    static int M;
    static int u, v;
    static boolean[][] graph;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;

    //u, v 최소 거리 계산
    static void dfs(int u, int v, int count) {
        if (u == v) {
            answer = Math.min(answer, count);
            return;
        }
        visited[u] = true;
        count++;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[u][i]) {
                dfs(i, v, count);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] param = br.readLine().split(" ");
        u = Integer.parseInt(param[0]);
        v = Integer.parseInt(param[1]);
        M = Integer.parseInt(br.readLine());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        // 1. 무방향 그래프 연결 정보 채우기(행렬)
        while (M-- > 0) {
            param = br.readLine().split(" ");
            int x = Integer.parseInt(param[0]);
            int y = Integer.parseInt(param[1]);
            graph[x][y] = true;
            graph[y][x] = true;
        }

        // 2. dfs
        dfs(u, v, 0);

        // 3. 출력
        System.out.println(answer != Integer.MAX_VALUE ? answer : -1);
    }
}
