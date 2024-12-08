import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; //1 ≤ N ≤ 1,000,000
    static int Q; //1 ≤ Q ≤ 3,000,000
    static int[] acc; //1 ≤ i ≤ 1,000,000,000
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        Q = Integer.parseInt(param[1]);
        acc = new int[N + 1];
        result = new int[Q];

        //prefix sum
        String[] nums = br.readLine().split(" ");
        for (int i = 1; i < N + 1; i++) {
            acc[i] = acc[i - 1] ^ Integer.parseInt(nums[i - 1]);
        }

        //range sum
        for (int i = 0; i < Q; i++) {
            param = br.readLine().split(" ");
            int left = Integer.parseInt(param[0]);
            int right = Integer.parseInt(param[1]);
            result[i] = acc[right] ^ acc[left - 1];
        }

        for (int i = 1; i < Q; i++) {
            result[i] ^= result[i - 1];
        }

        System.out.println(result[Q - 1]);
    }
}
