import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static int N; // 1 ≤ N ≤ 100,000
    static int[][] A;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            A = new int[3][N + 1];
            for (int i = 0; i < 2; i++) {
                String[] param = br.readLine().split(" ");
                for (int j = 0; j < param.length; j++) {
                    A[i + 1][j + 1] = Integer.parseInt(param[j]);
                }
            }
            
            dp = new int[3][N + 1];
            dp[1][1] = A[1][1];
            dp[2][1] = A[2][1];
            for (int j = 2; j <= N; j++) {
                for (int i = 1; i <= 2; i++) {
                    dp[i][j] = Math.max(dp[i + (int) Math.pow((-1), i - 1)][j - 1] + A[i][j],
                            dp[i + (int) Math.pow((-1), i - 1)][j - 2] + A[i][j - 1]);
                }
            }

            System.out.println(Math.max(dp[1][N], dp[2][N]));
        }
    }
}
