import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int INF = 1_000_000 * 10;

    static int N; // 2 ≤ N ≤ 10
    static int[][] graph; // 0 ≤ i ≤ 1,000,000
    static int[][] dp;

    // dp[u][travel]: u 도시에서 방문하지 않은 도시들을 방문해서 출발점(:0)으로 돌아가는 최소 비용
    static int TSP(int u, int travel) {
        // 모두 방문한 travel 인 경우
        if (travel == (1 << N) - 1) {
            if (graph[u][0] > 0) {
                return graph[u][0];
            } else {
                return INF;
            }
        }

        // 이미 방문한적이 있는 travel 인 경우
        if (dp[u][travel] != -1) {
            return dp[u][travel];
        }

        dp[u][travel] = INF;
        for (int v = 1; v < N; v++) {
            int next = travel | (1 << v);
            // 경로가 있으면서 방문하지 않은 v 도시의 경우 방문 가능하다
            if (graph[u][v] > 0 && (travel & (1 << v)) == 0) {
                dp[u][travel] = Math.min(dp[u][travel], TSP(v, next) + graph[u][v]);
            }
        }
        return dp[u][travel];
    }


    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        dp = new int[N][1 << N];

        // 0-1. memoization: 2차원 배열 -1로 초기화
        // 방문도시 N개: N비트 사용 = (1 << N) - 1
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < (1 << N); ++j) {
                dp[i][j] = -1;
            }
        }

        // 0-2. 도시 및 비용 입력: 2차원 배열
        for (int i = 0; i < N; i++) {
            String[] param = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(param[j]);
            }
        }

        // 1. graph traversal
        // 도시 0에서 시작 및 방문 처리: 순회 가능한 경우만 존재하므로 출발지를 바꾸더라도 최소비용은 동일하다.
        // 2. 출력
        System.out.println(TSP(0, 1));
    }
}
