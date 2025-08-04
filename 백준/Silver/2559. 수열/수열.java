import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, K; // 2 ≤ N(수열 길이) ≤ 100,000, 1 ≤ K(구간 길이) ≤ N
    static int[] acc; // -10,000,000 ≤ acc[i] ≤ 10,000,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 0. input
        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        K = Integer.parseInt(param[1]);

        // 1. prefix sum
        acc = new int[N + 1];
        param = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            acc[i] = acc[i - 1] + Integer.parseInt(param[i - 1]);
        }

        // 2. range sum (i+1, i+K)
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i + K <= N; i++) {
            answer = Math.max(answer, acc[i + K] - acc[i]);
        }

        System.out.println(answer);
    }
}
