import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static int T; // T ≤ 10
    static char[] nums; // nums.length ≤ 6
    static int C; // C ≤ 10
    static int answer;

    static void dfs(char[] nums, int d, int k) {
        if (k == C) {
            int result = Integer.parseInt(new String(nums));
            answer = Math.max(answer, result);
            return;
        }
        for (int i = d; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                char[] copy = Arrays.copyOf(nums, nums.length);
                char temp = copy[i];
                copy[i] = copy[j];
                copy[j] = temp;
                dfs(copy, i, k + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] param = br.readLine().split(" ");
            nums = param[0].toCharArray();
            C = Integer.parseInt(param[1]);

            answer = 0;
            dfs(nums, 0, 0);
            System.out.printf("#%d %d\n", t, answer);
        }
    }
}
