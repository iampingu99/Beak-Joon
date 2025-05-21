import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int T; // T(테스트 수)
    static int N; // 1 ≤ N ≤ 100
    static long[] dp;

    static long fibonacci(int n) {
        if (dp[n] != 0) return dp[n];
        if (n == 1 || n == 2 || n == 3) return dp[n] = 1;
        return dp[n] = fibonacci(n - 2) + fibonacci(n - 3);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            dp = new long[N + 1];

            System.out.printf("#%d %d\n", t, fibonacci(N));
        }
    }
}
