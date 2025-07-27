import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_SIZE = 500 + 2;

    static int M, N; // 1 ≤ M(세로), N(가로) ≤ 500
    static int[][] matrix; // 1 ≤ matrix[i] ≤ 10,000
    static boolean[][] visited;
    static int[][] dp;
    static long count; // 0 ≤ H ≤ 1,000,000,000

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    // matrix all-path: memoization + dfs
    static int allPath(int x, int y) {
        // 종료 지점
        if (x == N && y == M) return 1;

        // 탐색한 경우
        if (dp[y][x] != -1) return dp[y][x];

        // 탐색하지 않은 경우
        dp[y][x] = 0;
        for (int d = 0; d < dx.length; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (matrix[ny][nx] > 0 && matrix[y][x] > matrix[ny][nx]) {
                // 반환된 결과 누적
                dp[y][x] += allPath(nx, ny);
            }
        }
        // 상위 호출로 반환
        return dp[y][x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] param = br.readLine().split(" ");
        M = Integer.parseInt(param[0]);
        N = Integer.parseInt(param[1]);

        matrix = new int[MAX_SIZE][MAX_SIZE];
        dp = new int[MAX_SIZE][MAX_SIZE];

        // 1. 미로 입력
        // 2. 메모이제이션 초기화
        for (int y = 1; y <= M; y++) {
            param = br.readLine().split(" ");
            for (int x = 1; x <= N; x++) {
                matrix[y][x] = Integer.parseInt(param[x - 1]);
                dp[y][x] = -1;
            }
        }

        System.out.println(allPath(1, 1));
    }
}
