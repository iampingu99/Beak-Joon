import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M; // 3 ≤ M, N ≤ 300
    static int[][] matrix; // 0 ≤ i ≤ 10
    static boolean[][] visited;

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    // matrix traversal dfs
    // 연결된 칸이 0이 아닌 경우 dfs
    // 연결된 칸이 0인 경우 1 녹임
    static void dfs(int x, int y) {
        visited[y][x] = true;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (!visited[ny][nx]) {
                if (matrix[ny][nx] > 0) {
                    dfs(nx, ny);
                } else {
                    matrix[y][x]--;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        // 0-1. 빙산 입력: 2차원 배열
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            param = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(param[j]);
            }
        }

        // 1. dfs + 연결된 묶음의 개수
        for (int year = 0; ; year++) {
            visited = new boolean[N][M];
            int iceberg = 0;
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (!visited[i][j] && matrix[i][j] > 0) {
                        dfs(j, i);
                        iceberg++;
                    }
                }
            }
            if (iceberg >= 2) {
                System.out.println(year);
                break;
            }
            if (iceberg == 0) {
                System.out.println(0);
                break;
            }
        }
    }
}
