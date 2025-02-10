import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 1 ≤ N ≤ 1,000
    static int[] A; // 1 ≤ i ≤ 1,000
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        dp = new int[N];
        A = new int[N];
        String[] param = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(param[i]);
            dp[i] = 1;
        }

        int answer = dp[0];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
                answer = Math.max(answer, dp[i]);
            }
        }

        System.out.println(answer);
    }
}
