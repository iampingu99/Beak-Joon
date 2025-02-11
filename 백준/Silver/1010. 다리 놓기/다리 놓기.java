import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_SIZE = 30;
    static int T;
    static int N, M; // 0 < N ≤ M < 30
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        dp = new int[MAX_SIZE][MAX_SIZE];
        dp[1][0] = 1;
        dp[1][1] = 1;
        for (int n = 2; n < MAX_SIZE; n++) {
            dp[n][0] = 1;
            for (int r = 1; r <= n; r++) {
                dp[n][r] = dp[n - 1][r - 1] + dp[n - 1][r];
            }
        }

        while (T-- > 0) {
            String[] param = br.readLine().split(" ");
            N = Integer.parseInt(param[0]);
            M = Integer.parseInt(param[1]);
            System.out.println(dp[M][N]);
        }
    }
}
