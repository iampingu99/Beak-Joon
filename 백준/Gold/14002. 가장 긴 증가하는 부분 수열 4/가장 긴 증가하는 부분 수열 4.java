import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] A;
    static ArrayList<Integer>[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        dp = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            dp[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int target = i;
            for (int j = i; j >= 0; j--) {
                if (A[i] > A[j]) {
                    if (dp[target].size() < dp[j].size()) target = j;
                }
            }
            dp[i].addAll(dp[target]);
            dp[i].add(A[i]);
        }

        int maxIdx = 0;
        for (int i = 0; i < N; i++) {
            if (dp[maxIdx].size() < dp[i].size()) maxIdx = i;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[maxIdx].size()).append("\n");
        dp[maxIdx].forEach(i -> sb.append(i).append(" "));
        System.out.println(sb);
    }

}
