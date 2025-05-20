import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static int T; // T(테스트)
    static int N; // 1 ≤ N(수열 길이) ≤ 1,000
    static int[] A;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            A = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            dp = new int[N];

            int answer = 0;
            for (int i = 0; i < N; i++) {
                dp[i] = 1;
                for (int j = i; j >= 0; j--) {
                    if (A[i] > A[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                answer = Math.max(answer, dp[i]);
            }

            System.out.printf("#%d %d\n", t, answer);
        }
    }
}
