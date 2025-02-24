import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_N = 100 + 1;
    static int N; // 1 ≤ N ≤ 100
    static int K; // 1 ≤ K ≤ 100,000
    static int[] W; // 1 ≤ W ≤ 100,000
    static int[] V; // 0 ≤ V ≤ 1,000
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        K = Integer.parseInt(param[1]);

        W = new int[MAX_N];
        V = new int[MAX_N];
        for (int i = 1; i <= N; i++) {
            param = br.readLine().split(" ");
            W[i] = Integer.parseInt(param[0]);
            V[i] = Integer.parseInt(param[1]);
        }

        dp = new int[N + 1][K + 1];
        for (int k = 1; k <= K; k++) {
            for (int i = 1; i <= N; i++) {
                if (W[i] > k) dp[i][k] = dp[i - 1][k];
                else {
                    dp[i][k] = Math.max(dp[i - 1][k - W[i]] + V[i], dp[i - 1][k]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
