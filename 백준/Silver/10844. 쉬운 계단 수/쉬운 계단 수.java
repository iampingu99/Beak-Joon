import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1_000_000_000;
    static final int MAX_N = 100 + 1;
    static int N; // 1 ≤ N ≤ 100
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new long[MAX_N][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < MAX_N; i++) {
            dp[i][0] = dp[i - 1][1];
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
            }
            dp[i][9] = dp[i - 1][8];
        }

        long answer = 0;
        for (int i = 1; i <= 9; i++) {
            answer += dp[N][i];
        }
        System.out.println(answer % MOD);
    }
}
