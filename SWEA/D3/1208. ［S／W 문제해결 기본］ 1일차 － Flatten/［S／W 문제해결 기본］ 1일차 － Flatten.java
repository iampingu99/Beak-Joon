import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static final int T = 10;
    static final int N = 100; // N(가로 길이)
    static int D; // 1 ≤ D(덤프 횟수) ≤ 1,000
    static int[] arr; // 1 ≤ arr[i] ≤ 100

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= T; t++) {
            D = Integer.parseInt(br.readLine());
            arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Arrays.sort(arr);

            while (D-- > 0) {
                if (arr[0] == arr[arr.length - 1]) break;
                arr[arr.length - 1]--;
                arr[0]++;
                Arrays.sort(arr);
            }
            System.out.printf("#%d %d\n", t, arr[arr.length - 1] - arr[0]);
        }
    }
}