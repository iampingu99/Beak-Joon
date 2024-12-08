import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <ul>
 *     <li>2중 반복문 O(M * N^2)</li>
 *     <li>각 행의 구간 합 O(M * N)</li>
 *     <li>2차원 배열 구간 합 O(N^2)</li>
 * </ul>
 */
public class Main {
    static int N; //1 ≤ N ≤ 1024
    static int M; //1 ≤ M ≤ 100,000
    static int[][] acc; //1 ≤ i ≤ 1,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);
        acc = new int[N + 1][N + 1];

        //1. 2차원 배열의 누적합 구하기 O(N^2)
        for (int i = 1; i < N + 1; i++) {
            String[] nums = br.readLine().split(" ");
            for (int j = 1; j < N + 1; j++) {
                acc[i][j] = acc[i][j - 1] + acc[i - 1][j] - acc[i - 1][j - 1] + Integer.parseInt(nums[j - 1]);
            }
        }

        //2. 2차원 배열의 구간합 구하기 O(M)
        while (M-- > 0) {
            param = br.readLine().split(" ");
            int x1 = Integer.parseInt(param[0]);
            int y1 = Integer.parseInt(param[1]);
            int x2 = Integer.parseInt(param[2]);
            int y2 = Integer.parseInt(param[3]);
            int result = acc[x2][y2] - acc[x2][y1 - 1] - acc[x1 - 1][y2] + acc[x1 - 1][y1 - 1];
            answer.append(result).append("\n");
        }
        System.out.println(answer);
    }
}
