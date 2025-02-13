import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 1 ≤ n ≤ 100,000
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] param = br.readLine().split(" ");
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(param[i - 1]);
            dp[i] = dp[i - 1] + num;
        }

        int answer = Integer.MIN_VALUE;
        int min = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dp[i] - min);
            min = Math.min(dp[i], min);
        }

        System.out.println(answer);
    }
}
