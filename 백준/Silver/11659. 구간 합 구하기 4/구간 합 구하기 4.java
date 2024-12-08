import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; //1 ≤ N ≤ 100,000
    static int M; //1 ≤ M ≤ 100,000
    static int[] acc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);
        acc = new int[N + 1];

        //prefix sum
        String[] nums = br.readLine().split(" ");
        for (int i = 1; i < N + 1; i++) {
            acc[i] = acc[i - 1] + Integer.parseInt(nums[i - 1]);
        }

        //range sum
        for (int i = 0; i < M; i++) {
            param = br.readLine().split(" ");
            int left = Integer.parseInt(param[0]);
            int right = Integer.parseInt(param[1]);
            answer.append(acc[right] - acc[left - 1]).append("\n");
        }
        System.out.println(answer);
    }
}
