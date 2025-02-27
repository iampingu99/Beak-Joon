import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int INF = 10_000 + 1;
    static int N; // 1 ≤ n ≤ 100
    static int K; // 1 ≤ k ≤ 10,000
    static int[] A;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        K = Integer.parseInt(param[1]);

        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[N + 1][K + 1];
        Arrays.fill(dp[0], INF);
        for (int n = 1; n <= N; n++) {
            for (int k = 1; k <= K; k++) {
                if (k < A[n]) dp[n][k] = dp[n - 1][k];
                else dp[n][k] = Math.min(dp[n][k - A[n]] + 1, dp[n - 1][k]);
            }
        }

        System.out.println(dp[N][K] < INF ? dp[N][K] : -1);
    }
}
