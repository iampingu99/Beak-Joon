import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, K;
    static int[] w, v;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 0. 입력
        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        K = Integer.parseInt(param[1]);

        // 1-based
        w = new int[N + 1];
        v = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            param = br.readLine().split(" ");
            w[i] = Integer.parseInt(param[0]);
            v[i] = Integer.parseInt(param[1]);
        }

        dp = new int[N + 1][K + 1];
        for (int n = 1; n <= N; n++) {
            for (int k = 0; k <= K; k++) {
                if (w[n] <= k) dp[n][k] = Math.max(dp[n - 1][k], dp[n - 1][k - w[n]] + v[n]);
                else dp[n][k] = dp[n - 1][k];
            }
        }

        System.out.println(dp[N][K]);
    }
}
