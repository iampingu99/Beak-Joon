import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N; // 1 ≤ N ≤ 1,000
    static int[] A; // 1 ≤ i ≤ 1,000
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        dp = new int[N];
        Arrays.fill(dp, 1);
        int answer = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
