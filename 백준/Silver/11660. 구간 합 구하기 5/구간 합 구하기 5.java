import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int M;
    static int[][] acc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);
        acc = new int[N + 1][N + 1];

        //1. 각 행의 누적합 구하기
        for (int i = 1; i < N + 1; i++) {
            String[] nums = br.readLine().split(" ");
            for (int j = 1; j < N + 1; j++) {
                acc[i][j] = acc[i][j - 1] + Integer.parseInt(nums[j - 1]);
            }
        }

        //2. 각 행의 구간합 더하기
        while (M-- > 0) {
            int answer = 0;
            param = br.readLine().split(" ");
            int x1 = Integer.parseInt(param[0]);
            int y1 = Integer.parseInt(param[1]);
            int x2 = Integer.parseInt(param[2]);
            int y2 = Integer.parseInt(param[3]);
            for (int i = x1; i <= x2; i++) {
                answer += acc[i][y2] - acc[i][y1 - 1];
            }
            System.out.println(answer);
        }
    }
}
