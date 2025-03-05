import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    static int N; // 1 ≤ N ≤ 100;
    static int[] A; // 1 ≤ Ai ≤ 500
    static int[] B; // 1 ≤ Bi ≤ 500
    static int[] dp;

    static class Line {
        int from;
        int to;

        public Line(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] param = br.readLine().split(" ");
            int u = Integer.parseInt(param[0]);
            int v = Integer.parseInt(param[1]);
            lines.add(new Line(u, v));
        }

        lines.sort(Comparator.comparingInt(l -> l.from));

        dp = new int[N];
        Arrays.fill(dp, 1);

        int answer = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                if (lines.get(i).to < lines.get(j).to) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(N - answer);
    }
}
