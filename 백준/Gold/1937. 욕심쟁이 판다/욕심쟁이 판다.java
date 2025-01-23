import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int MAX_SIZE = 500 + 2;
    static int N; // 1 ≤ n ≤ 500
    static int[][] matrix;
    static int[][] dp;

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    // dfs matrix traversal: 이전 지역보다 더 많은 대나무가 있는 곳으로 상하좌우 이동
    // dp[y][x]: (y, x)에서 부터 시작해 자리를 옮길 수 있는 최대 칸의 수
    static int dfs(int x, int y) {
        if (dp[y][x] != 0) return dp[y][x];
        dp[y][x] = 1;
        for (int d = 0; d < dx.length; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (matrix[y][x] < matrix[ny][nx]) {
                dp[y][x] = Math.max(dp[y][x], 1 + dfs(nx, ny));
            }
        }
        return dp[y][x];
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 0-1. 대나무 정보 입력: 2차원 배열
        matrix = new int[MAX_SIZE][MAX_SIZE];
        for (int i = 1; i <= N; i++) {
            String[] param = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = Integer.parseInt(param[j - 1]);
            }
        }
        dp = new int[MAX_SIZE][MAX_SIZE];

        // 1. 모든 위치를 시작점으로 dfs 탐색
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                answer = Math.max(answer, dfs(j, i));
            }
        }

        // 2. 출력
        System.out.println(answer);
    }
}
