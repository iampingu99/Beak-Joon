import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final long MOD = 1_000_000_000;
    static int N; // 1 ≤ N ≤ 200
    static int K; // 1 ≤ K ≤ 200
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        K = Integer.parseInt(param[1]);

        dp = new long[N + 1];
        Arrays.fill(dp, 1);

        for (int k = 2; k <= K; k++) {
            dp[0] = 1;
            for (int n = 1; n <= N; n++) {
                dp[n] = (dp[n] + dp[n - 1]) % MOD;
            }
        }

        System.out.println(dp[N]);
    }
}
