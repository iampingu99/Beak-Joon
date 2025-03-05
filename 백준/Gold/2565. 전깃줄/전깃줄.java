import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    static class Line {
        int from; // 1 ≤ from ≤ 500
        int to; // 1 ≤ to ≤ 500

        public Line(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    static int N; // 1 ≤ N ≤ 100;
    static int[] dp;
    static List<Line> lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        lines = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] param = br.readLine().split(" ");
            int u = Integer.parseInt(param[0]);
            int v = Integer.parseInt(param[1]);
            lines.add(new Line(u, v));
        }

        lines.sort(Comparator.comparingInt(l -> l.from));

        // backward longest increasing subsequence
        dp = new int[N];
        int max = 0;
        for (int i = N - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i; j < N; j++) {
                if (lines.get(i).to < lines.get(j).to) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(N - max);
    }
}
