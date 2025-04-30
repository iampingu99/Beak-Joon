import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static final int T = 10; // T(테스트)
    static int N = 100; // N(테이블 가로, 세로)
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                matrix[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            int answer = 0;
            for (int i = 0; i < N; i++) {
                int prev = 0;
                for (int j = 0; j < N; j++) {
                    int curr = matrix[j][i];
                    if (prev == 1 && curr == 2) answer++;
                    if (curr != 0) prev = curr;
                }
            }

            System.out.printf("#%d %d\n", t, answer);
        }
    }
}