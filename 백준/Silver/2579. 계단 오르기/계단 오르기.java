import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 1 ≤ N ≤ 300
    static int[] score; // 1 ≤ i ≤ 10,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        score = new int[N + 1];
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[N + 1][N + 1];
        dp[0] = new int[]{0, 0};
        dp[1] = new int[]{score[0], score[0]};
        for (int pos = 2; pos < dp.length; pos++) {
            dp[pos] = new int[]{dp[pos - 1][1] + score[pos - 1],
                    Math.max(dp[pos - 2][0], dp[pos - 2][1]) + score[pos - 1]};
        }

        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
}
