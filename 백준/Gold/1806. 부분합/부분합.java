import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, S; // 10 ≤ N(수열 길이) < 100,000, 0 < S (구간 합 기준점) ≤ 100,000,000
    static int[] nums; // 1 ≤ nums[i] ≤ 10,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 0. input
        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        S = Integer.parseInt(param[1]);

        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 1. range sum
        int left = 0, right = 0, sum = 0, answer = N + 1;
        while (right < N) {
            sum += nums[right++];
            while (sum >= S) {
                answer = Math.min(answer, right - left);
                sum -= nums[left++];
            }
        }

        System.out.println(answer == N + 1 ? 0 : answer);
    }
}
