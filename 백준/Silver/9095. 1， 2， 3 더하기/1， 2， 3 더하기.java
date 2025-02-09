import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static int N; // 1 ≤ N ≤ 10

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1. 모든 n의 1, 2, 3의 합으로 나타내는 방법의 수 계산
        // dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
        int[] dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int n = 4; n <= 10; n++) {
            dp[n] = dp[n - 1] + dp[n - 2] + dp[n - 3];
        }

        // 2. n 을 1, 2, 3의 합으로 나타내는 방법의 수
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }

        // 3. 출력
        System.out.println(sb);
    }
}
