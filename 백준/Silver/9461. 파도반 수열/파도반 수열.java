import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_NUM = 100 + 1;
    static int T;
    static int N; // 1 ≤ N ≤ 100

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] dp = new long[MAX_NUM];
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;
        for (int i = 6; i < MAX_NUM; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}
