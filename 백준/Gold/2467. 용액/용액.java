import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N; // 2 ≤ N ≤ 100,000
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 0. input
        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        int lo = 0, hi = nums.length - 1, a = 0, b = 0;
        while (lo < hi) {
            int diff = nums[lo] + nums[hi];
            if (Math.abs(diff) < minDiff) {
                a = nums[lo];
                b = nums[hi];
                minDiff = Math.abs(diff);
            }

            if (diff > 0) hi--;
            else lo++;
        }

        System.out.println(a + " " + b);
    }
}
