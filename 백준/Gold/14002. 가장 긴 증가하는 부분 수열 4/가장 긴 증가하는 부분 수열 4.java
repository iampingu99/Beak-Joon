import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    static int N;
    static int[] nums, seq, dp;

    // lower bound
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
        StringBuilder sb = new StringBuilder();

        // 0. 입력
        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 1. LIS
        seq = new int[N];
        dp = new int[N];
        int peek = 0;
        seq[0] = nums[0];
        for (int i = 1; i < N; i++) {
            if (nums[i] > seq[peek]) { // LIS 증가
                dp[i] = ++peek;
                seq[peek] = nums[i];
            } else { // LIS 대치
                int lo = binarySearch(seq, 0, peek, nums[i]);
                dp[i] = lo;
                seq[lo] = nums[i];
            }
        }
 
        // 2. 역추적
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = N - 1, j = peek; i >= 0 && j >= 0; i--) {
            if (dp[i] == j) {
                deque.offerFirst(nums[i]);
                j--;
            }
        }

        deque.forEach(v -> sb.append(v).append(" "));

        System.out.println(peek + 1);
        System.out.println(sb);
    }
}
