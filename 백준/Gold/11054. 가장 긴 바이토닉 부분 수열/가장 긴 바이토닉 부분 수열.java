import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N; // 1 ≤ N ≤ 1,000
    static int[] A; // 1 ≤ Ai ≤ 1,000
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        dp = new int[2][N];
        for (int i = 0; i < N; i++) {
            dp[0][i] = 1;
            dp[1][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (A[i] > A[j]) dp[0][i] = Math.max(dp[0][i], dp[0][j] + 1);
            }
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                if (A[i] > A[j]) dp[1][i] = Math.max(dp[1][i], dp[1][j] + 1);
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[0][i] + dp[1][i]);
        }

        System.out.println(answer - 1);
    }
}
