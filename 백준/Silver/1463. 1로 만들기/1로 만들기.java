import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 1 ≤ N ≤ 10^6

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[1] = 0;
        for (int n = 2; n <= N; n++) {
            dp[n] = dp[n - 1] + 1;
            if (n % 3 == 0) dp[n] = Math.min(dp[n], dp[n / 3] + 1);
            if (n % 2 == 0) dp[n] = Math.min(dp[n], dp[n / 2] + 1);
        }
        System.out.println(dp[N]);
    }
}
