import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static final int N = 100; // N(배열 가로/세로)
    static final int T = 10; // T(테스트)

    static int[][] matrix;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= T; t++) {
            br.readLine();

            matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                matrix[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            answer = 0;
            for (int i = 0; i < N; i++) {
                int row = 0, col = 0;
                for (int j = 0; j < N; j++) {
                    row += matrix[i][j];
                    col += matrix[j][i];
                }
                answer = Math.max(answer, Math.max(row, col));
            }

            int down = 0, up = 0;
            for (int i = 0; i < N; i++) {
                down += matrix[i][i];
                up += matrix[i][N - i - 1];
            }

            answer = Math.max(answer, Math.max(down, up));

            System.out.printf("#%d %d\n", t, answer);
        }
    }
}
