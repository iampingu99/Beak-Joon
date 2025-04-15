import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M; // 1 ≤ N(세로), M(가로) ≤ 50
    static int[][] matrix; // 1 ≤ matrix[i] ≤ 9 , H(구멍)
    static boolean[][] visited;
    static int[][] dp;
    static boolean isInf;

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int allPath(int x, int y) {
        if (dp[y][x] != 0) return dp[y][x];

        int distance = matrix[y][x];
        dp[y][x] = 1;

        for (int d = 0; d < dx.length; d++) {
            int nx = x + (dx[d] * distance);
            int ny = y + (dy[d] * distance);
            if (nx >= 0 && ny >= 0 && nx < M && ny < N && matrix[ny][nx] > 0) {
                if (visited[ny][nx]) isInf = true;
                visited[ny][nx] = true;
                dp[y][x] = Math.max(dp[y][x], 1 + allPath(nx, ny));
                visited[ny][nx] = false;
            }
        }
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

        for (int y = 0; y < N; y++) {
            param = br.readLine().split("");
            for (int x = 0; x < M; x++) {
                matrix[y][x] = Integer.parseInt(param[x].equals("H") ? "0" : param[x]);
            }
        }

        visited[0][0] = true;
        int answer = allPath(0, 0);

        System.out.println(isInf ? -1 : answer);
    }
}
