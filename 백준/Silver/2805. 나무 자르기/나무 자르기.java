import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int MAX_HEIGHT = 1_000_000_000;
    static int N, M; // 1 ≤ N(나무 수) ≤ 1,000,000, 1 ≤ M(필요한 나무 길이) ≤ 2,000,000,000
    static int[] heights; // 0 ≤ heights[i] ≤ 1,000,000,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        heights = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int lo = 0, hi = MAX_HEIGHT;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long sum = 0;
            for (int height : heights) {
                if (height > mid) sum += height - mid;
            }
            if (sum < M) hi = mid - 1;
            else lo = mid + 1;
        }

        System.out.println(lo - 1);
    }
}
