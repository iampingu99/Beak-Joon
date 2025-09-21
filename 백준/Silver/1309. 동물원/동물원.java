import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_SIZE = 100_000 + 1;
    static final int DIV = 9901;
    static int N; // 1 ≤ N ≤ 100,000
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[MAX_SIZE];
        dp[1] = 3;
        dp[2] = 7;

        for (int i = 3; i <= N; i++) {
            dp[i] = ((dp[i - 1] * 2) + dp[i - 2]) % DIV;
        }

        System.out.println(dp[N]);
    }
}
