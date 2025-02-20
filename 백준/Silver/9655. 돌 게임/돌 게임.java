import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_N = 1000 + 1;
    static int N; // 1 ≤ N ≤ 1000
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[MAX_N];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        for (int i = 4; i <= N; i++) {
            dp[i] = Math.min(dp[i - 3], dp[i - 1]) + 1;
        }
        
        System.out.println(dp[N] % 2 == 0 ? "CY" : "SK");
    }
}
