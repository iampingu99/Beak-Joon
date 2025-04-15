import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_SIZE = 50 + 2;
    
    static int T;
    static int M; // 1 ≤ M(가로 길이) ≤ 50
    static int N; // 1 ≤ N(세로 길이) ≤ 50
    static int K; // 1 ≤ K(배추 개수) ≤ 2500
    static boolean[][] matrix;

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

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
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] param = br.readLine().split(" ");
            M = Integer.parseInt(param[0]);
            N = Integer.parseInt(param[1]);
            K = Integer.parseInt(param[2]);

            // 1. 배추 입력: 1-based
            matrix = new boolean[MAX_SIZE][MAX_SIZE];
            for (int k = 0; k < K; k++) {
                param = br.readLine().split(" ");
                int x = Integer.parseInt(param[0]) + 1;
                int y = Integer.parseInt(param[1]) + 1;
                matrix[y][x] = true;
            }

            // 2. dfs
            int answer = 0;
            for (int y = 1; y <= N; y++) {
                for (int x = 1; x <= M; x++) {
                    if (!matrix[y][x]) continue;
                    connectedComponent(x, y);
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }
}
