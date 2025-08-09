import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    static int N;
    static int[] nums, seq, dp;

    static int binarySearch(int[] arr, int lo, int hi, int key) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key > arr[mid]) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int peek = 0;
        seq = new int[N];
        dp = new int[N];
        seq[0] = nums[0];
        for (int i = 1; i < N; i++) {
            if (nums[i] > seq[peek]) {
                dp[i] = ++peek;
                seq[peek] = nums[i];
            } else {
                int lo = binarySearch(seq, 0, peek, nums[i]);
                seq[lo] = nums[i];
                dp[i] = lo;
            }
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = N - 1; peek >= 0 && i >= 0; i--) {
            if (dp[i] == peek) {
                deque.offerFirst(nums[i]);
                peek--;
            }
        }

        StringBuilder sb = new StringBuilder();
        deque.forEach(v -> sb.append(v).append(" "));

        System.out.println(deque.size());
        System.out.println(sb);
    }
}
