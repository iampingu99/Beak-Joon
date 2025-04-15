import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_SIZE = 50 + 2;

    static int W, H; // 1 ≤ W, H ≤ 50;
    static boolean[][] matrix;

    // N NE E SE S SW W NW
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    // matrix connected-component: dfs
    static void connectedComponent(int x, int y) {
        matrix[y][x] = false;
        for (int d = 0; d < dx.length; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (matrix[ny][nx]) {
                connectedComponent(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] param = br.readLine().split(" ");
            W = Integer.parseInt(param[0]);
            H = Integer.parseInt(param[1]);
            if (W == 0 && H == 0) break;

            // 1. 땅, 바다 입력: 1-based
            matrix = new boolean[MAX_SIZE][MAX_SIZE];
            for (int i = 1; i <= H; i++) {
                String str = br.readLine().replace(" ", "");
                for (int j = 1; j <= W; j++) {
                    matrix[i][j] = str.charAt(j - 1) == '1';
                }
            }

            // 2. dfs
            int answer = 0;
            for (int y = 1; y <= H; y++) {
                for (int x = 1; x <= W; x++) {
                    if (matrix[y][x]) {
                        connectedComponent(x, y);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }
}
