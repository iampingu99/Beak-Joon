import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    static int N;
    static int[] A;
    static int[] dp;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = i; j >= 0; j--) {
                if (A[i] > A[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            answer = Math.max(answer, dp[i]);
        }

        Deque<Integer> lis = new ArrayDeque<>();
        for (int i = N - 1, j = answer; i >= 0; i--) {
            if (dp[i] == j) {
                lis.offerFirst(A[i]);
                j--;
            }
        }

        StringBuilder sb = new StringBuilder();
        lis.forEach(i -> sb.append(i).append(" "));

        System.out.println(answer);
        System.out.println(sb);
    }
}
