import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static int T = 10;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (T-- > 0) {
            StringBuilder answer = new StringBuilder();
            int t = Integer.parseInt(br.readLine());

            nums = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int d = 1;
            for (int i = 0; i < 8; i = (i + 1) % 8) {
                if (nums[i] > d) nums[i] -= d--;
                else {
                    nums[i] = 0;
                    for (int j = i + 1; j != i; j = (j + 1) % 8) {
                        answer.append(nums[j]).append(" ");
                    }
                    answer.append("0");
                    break;
                }
                d = ((d + 1) % 5) + 1;
            }
            System.out.printf("#%d %s\n", t, answer);
        }
    }
}
/**
 * #1 6 2 2 9 4 1 3 0
 * #2 9 7 9 5 4 3 8 0
 * #3 8 7 1 6 4 3 5 0
 * #4 7 5 8 4 8 1 3 0
 * #5 3 8 7 4 4 7 4 0
 * #6 6 7 5 9 6 8 5 0
 * #7 7 6 8 3 2 5 6 0
 * #8 9 2 1 7 3 6 3 0
 * #9 4 7 8 1 2 8 4 0
 * #10 6 8 9 5 8 5 2 0
 */
