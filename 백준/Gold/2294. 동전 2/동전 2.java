import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int INF = 10_000 + 1;
    static int N; // 1 ≤ n ≤ 100
    static int K; // 1 ≤ k ≤ 10,000
    static int[] A;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        K = Integer.parseInt(param[1]);

        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            dp[i] = INF;
        }
        
        for (int n : A) {
            for (int k = n; k <= K; k++) {
                dp[k] = Math.min(dp[k - n] + 1, dp[k]);
            }
        }

        System.out.println(dp[K] < INF ? dp[K] : -1);
    }
}
