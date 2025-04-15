import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_SIZE = 5 + 2;

    static int R, C; // 1 ≤ R(세로), C(가로) ≤ 5
    static int K; // K(거리)
    static boolean[][] matrix;
    static int answer;

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static void allPath(int x, int y, int distance) {
        if (distance == K) {
            if (x == C && y == 1) {
                answer++;
            }
        }

        for (int d = 0; d < dx.length; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (matrix[ny][nx]) {
                matrix[ny][nx] = false;
                allPath(nx, ny, distance + 1);
                matrix[ny][nx] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        R = Integer.parseInt(param[0]);
        C = Integer.parseInt(param[1]);
        K = Integer.parseInt(param[2]);

        matrix = new boolean[MAX_SIZE][MAX_SIZE];
        for (int y = 1; y <= R; y++) {
            String str = br.readLine();
            for (int x = 1; x <= C; x++) {
                matrix[y][x] = str.charAt(x - 1) == '.';
            }
        }

        matrix[R][1] = false;
        allPath(1, R, 1);
        System.out.println(answer);
    }
}
