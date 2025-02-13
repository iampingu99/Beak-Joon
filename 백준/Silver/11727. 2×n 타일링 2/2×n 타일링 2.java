import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int toggle = 1;
    static int N; // 1 ≤ n ≤ 1,000
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 1] * 2 + toggle) % 10007;
            toggle = -toggle;
        }

        System.out.println(dp[N]);
    }
}
