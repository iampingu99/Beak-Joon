import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_N = 1000;
    static int N; // 1 ≤ n ≤ 1,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 1. 2×n 크기의 직사각형을 채우는 방법의 수: dynamic-programming
        // 1-1. 점화식: f(n): 2×n 크기의 직사각형을 채우는 방법의 수 = f(n-1) + f(n-2)
        // 1-2. f(1) = 1, f(2) = 2
        int[] dp = new int[MAX_N + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int n = 3; n < dp.length; n++) {
            dp[n] = ((dp[n - 1] % 10007) + (dp[n - 2] % 10007)) % 10007;
        }

        // 2. 출력: 10,007로 나눈 나머지
        System.out.println(dp[N]);
    }
}
