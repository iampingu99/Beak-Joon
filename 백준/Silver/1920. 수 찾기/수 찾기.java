import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N; // 1 ≤ N(수열 길이) ≤ 100,000
    static int M; // 1 ≤ M(탐색 횟수) ≤ 100,000
    static int[] nums;

    // binary search
    static boolean isExists(int key) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < nums[mid]) hi = mid - 1;
            else if (key > nums[mid]) lo = mid + 1;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 0. input
        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        M = Integer.parseInt(br.readLine());

        Arrays.sort(nums);

        // 1. find
        Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .map(v -> isExists(v) ? 1 : 0)
                .forEach(v -> sb.append(v).append("\n"));

        System.out.println(sb);
    }
}
