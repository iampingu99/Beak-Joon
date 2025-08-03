import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M; // 1 ≤ N, M ≤ 100,000
    static int[] acc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        // preifx sum
        acc = new int[N + 1];
        param = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            acc[i] = acc[i - 1] + Integer.parseInt(param[i - 1]);
        }

        // range sum
        for (int m = 0; m < M; m++) {
            param = br.readLine().split(" ");
            int i = Integer.parseInt(param[0]);
            int j = Integer.parseInt(param[1]);

            sb.append(acc[j] - acc[i - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
