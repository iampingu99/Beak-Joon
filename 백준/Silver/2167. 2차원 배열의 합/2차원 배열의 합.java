import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M; // 1 ≤ N(세로), M(가로) ≤ 300
    static int K; // 1 ≤ K(구간 합 횟수) ≤ 10,000
    static int[][] dp; // -3,000,000 ≤ dp[i] ≤ 3,000,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        // 1. matrix prefix sum
        dp = new int[N + 1][M + 1];
        for (int row = 1; row <= N; row++) {
            param = br.readLine().split(" ");
            for (int col = 1; col <= M; col++) {
                dp[row][col] =
                        dp[row][col - 1] + dp[row - 1][col] - dp[row - 1][col - 1] + Integer.parseInt(param[col - 1]);
            }
        }

        K = Integer.parseInt(br.readLine());

        // 2. matrix range sum
        while (K-- > 0) {
            param = br.readLine().split(" ");
            int i = Integer.parseInt(param[0]);
            int j = Integer.parseInt(param[1]);
            int x = Integer.parseInt(param[2]);
            int y = Integer.parseInt(param[3]);
            int sum = dp[x][y] - dp[i - 1][y] - dp[x][j - 1] + dp[i - 1][j - 1];
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
