import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M; // 1 ≤ N(세로), M(가로) ≤ 50
    static int[][] matrix; // 1 ≤ matrix[i] ≤ 9 , H(구멍)
    static boolean[][] visited;
    static int[][] dp;
    static boolean isCycle;

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    // cycle-detection + longest path
    static int dfs(int x, int y) {
        if (isCycle) return 0;
        if (visited[y][x]) {
            isCycle = true;
            return 0;
        }

        if (dp[y][x] != 0) return dp[y][x];

        visited[y][x] = true;
        dp[y][x] = 1;

        int move = matrix[y][x];
        for (int d = 0; d < dx.length; d++) {
            int nx = x + dx[d] * move;
            int ny = y + dy[d] * move;
            if (nx >= 0 && ny >= 0 && nx < M && ny < N && matrix[ny][nx] != 0) {
                dp[y][x] = Math.max(dp[y][x], 1 + dfs(nx, ny));
            }
        }

        visited[y][x] = false;
        return dp[y][x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        matrix = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];

        // 1. 보드 입력: 0-based
        for (int y = 0; y < N; y++) {
            String str = br.readLine();
            for (int x = 0; x < M; x++) {
                char ch = str.charAt(x);
                matrix[y][x] = ch == 'H' ? 0 : ch - '0';
            }
        }

        // 2. 최장 경로 탐색: dfs + memoization
        int answer = dfs(0, 0);

        // 3. 출력: cycle 유무 검사
        System.out.println(isCycle ? -1 : answer);
    }
}
