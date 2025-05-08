import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static final String SUCCESS = "YES";
    static final String FAIL = "NO";
    static final int MIN_CONNECT = 5;
    static final int MAX_SIZE = 20 + 2;

    static int T; // T(테스트)
    static int N; // 5 ≤ N(판 크기) ≤ 20
    static boolean[][] matrix;

    // E SE S SW
    static int[] dx = {1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1};

    static boolean isConnected(int x, int y) {
        for (int d = 0; d < dx.length; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            for (int i = 2; matrix[ny][nx]; i++) {
                if (i == MIN_CONNECT) return true;
                nx += dx[d];
                ny += dy[d];
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            matrix = new boolean[MAX_SIZE][MAX_SIZE];

            for (int i = 1; i <= N; i++) {
                String str = br.readLine();
                for (int j = 1; j <= str.length(); j++) {
                    matrix[i][j] = str.charAt(j - 1) != '.';
                }
            }

            String answer = FAIL;
            for (int y = 1; y <= N; y++) {
                for (int x = 1; x <= N; x++) {
                    if (matrix[y][x] && isConnected(x, y)) answer = SUCCESS;
                }
            }

            System.out.printf("#%d %s\n", t, answer);
        }
    }
}
