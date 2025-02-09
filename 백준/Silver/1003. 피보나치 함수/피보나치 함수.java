import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_NUM = 40;
    static int T;
    static int N; // 1 ≤ N ≤ 40

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. fibonacci 에서 호출되는 0과 1: dynamic-programming
        // 1-1. 점화식: f(n): fibonacci 에서 호출되는 0과 1 = f(n-1) + f(n-2)
        // 1-2. f(0) = {1, 0}, f(1) = {0, 1}
        int[][] dp = new int[MAX_NUM + 1][MAX_NUM + 1];
        dp[0] = new int[]{1, 0};
        dp[1] = new int[]{0, 1};
        for (int n = 2; n < dp.length; n++) {
            dp[n] = new int[]{dp[n - 1][0] + dp[n - 2][0], dp[n - 1][1] + dp[n - 2][1]};
        }

        // 2. 테스트 숫자 별 f(n) 출력
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            System.out.printf("%d %d\n", dp[N][0], dp[N][1]);
        }
    }
}
