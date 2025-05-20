import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int INF = 1_000 + 1; // 최대 점프 회수
    static int N; // 1 ≤ N(미로 길이) ≤ 1,000
    static int[] A; // 0 ≤ A[i](점프) ≤ 100
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);

        A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        dp = new int[N];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j <= Math.min(i + A[i], N - 1); j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }

        System.out.println(dp[N - 1] == INF ? -1 : dp[N - 1]);

    }
}
