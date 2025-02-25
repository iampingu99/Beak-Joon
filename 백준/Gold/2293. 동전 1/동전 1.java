import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 1 ≤ n ≤ 100
    static int K; // 1 ≤ k ≤ 10,000
    static int[] A;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        K = Integer.parseInt(param[1]);

        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        dp = new long[K + 1];
        dp[0] = 1;
        for (int n = 0; n < N; n++) {
            for (int k = A[n]; k <= K; k++) {
                dp[k] = dp[k] + dp[k - A[n]];
            }
        }

        System.out.println(dp[K]);
    }
}
