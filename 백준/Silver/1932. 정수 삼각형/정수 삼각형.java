import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N; // 1 ≤ n ≤ 500
    static int[][] triangle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        triangle = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] param = br.readLine().split(" ");
            for (int j = 0; j < param.length; j++) {
                triangle[i][j] = Integer.parseInt(param[j]);
            }
        }

        int[][] dp = new int[N][N];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < N; i++) {
            dp[i][0] += dp[i - 1][0] + triangle[i][0];
            for (int j = 1; j < i; j++) {
                dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
            dp[i][i] += dp[i - 1][i - 1] + triangle[i][i];
        }

        System.out.println(Arrays.stream(dp[N - 1]).max().getAsInt());
    }
}
