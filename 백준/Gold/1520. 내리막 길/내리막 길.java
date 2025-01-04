import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_SIZE = 500 + 2;

    static int M, N; // 1 ≤ M, N ≤ 500
    static int[][] matrix; // 1 ≤ i ≤ 10,000
    static int[][] dp;

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    // memoization + dfs
    // dp[y][x] : (y, x) 에서 도착점까지의 경로 수
    static int dfs(int x, int y) {
        if (x == N && y == M) {
            return 1;
        }
        if (dp[y][x] != -1) {
            return dp[y][x];
        }
        dp[y][x] = 0;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (matrix[ny][nx] < matrix[y][x] && matrix[ny][nx] > 0) {
                dp[y][x] += dfs(nx, ny);
            }
        }
        return dp[y][x];
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        M = Integer.parseInt(param[0]);
        N = Integer.parseInt(param[1]);

        matrix = new int[MAX_SIZE][MAX_SIZE];
        dp = new int[MAX_SIZE][MAX_SIZE];

        // 0-1. 지도 입력: 2차원 배열
        // 0-2. memoization
        for (int i = 1; i <= M; i++) {
            param = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = Integer.parseInt(param[j - 1]);
                dp[i][j] = -1;
            }
        }

        // 1. matrix traversal dfs + memoization
        // 2. 출력
        System.out.println(dfs(1, 1));
    }
}
