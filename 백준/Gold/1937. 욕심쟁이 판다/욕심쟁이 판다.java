import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_SIZE = 500 + 2;

    static int N; // 1 ≤ N ≤ 500
    static int[][] matrix; // 1 ≤ matrix[i] ≤ 1,000,000
    static int[][] dp;

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    // matrix all-path: memoization + dfs
    static int allPath(int x, int y) {
        if (dp[y][x] != 0) return dp[y][x];

        dp[y][x] = 1;
        for (int d = 0; d < dx.length; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (matrix[y][x] < matrix[ny][nx]) {
                dp[y][x] = Math.max(dp[y][x], 1 + allPath(nx, ny));
            }
        }
        return dp[y][x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        matrix = new int[MAX_SIZE][MAX_SIZE];
        dp = new int[MAX_SIZE][MAX_SIZE];

        // 1. 대나무 입력: 1-based
        for (int y = 1; y <= N; y++) {
            String[] param = br.readLine().split(" ");
            for (int x = 1; x <= N; x++) {
                matrix[y][x] = Integer.parseInt(param[x - 1]);
            }
        }

        // 2. 모든 지점에서 탐색
        int answer = 0;
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                answer = Math.max(answer, allPath(x, y));
            }
        }
        System.out.println(answer);
    }
}
