import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, K;
    static int[] acc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 0. 입력
        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        K = Integer.parseInt(param[1]);

        // 1. prefix/accumulate sum
        acc = new int[N + 1];
        param = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            acc[i] = acc[i - 1] + Integer.parseInt(param[i - 1]);
        }

        // 2. range sum
        int answer = Integer.MIN_VALUE;
        for (int i = K; i <= N; i++) {
            answer = Math.max(answer, acc[i] - acc[i - K]);
        }
        
        System.out.println(answer);
    }
}
