import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_SIZE = 8 + 2;
    static int N, M; // 3 ≤ N, M ≤ 8
    static int[][] matrix;
    static boolean[][] visited;

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int wallCnt;
    //    static int virusCnt;
    static int answer;

    // matrix connect-component: dfs
    static int spreadVirus(int x, int y) {
        visited[y][x] = true;
        int count = 1;

        for (int d = 0; d < dx.length; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (!visited[ny][nx] && (matrix[ny][nx] == 1 || matrix[ny][nx] == 3)) {
                count += spreadVirus(nx, ny);
            }
        }
        return count;
    }

    // matrix coordinate combination: back-tracking
    static void selectWall(int[][] wall, int x, int y, int k) {
        if (k == 3) {
            for (int i = 0; i < 3; i++) {
                matrix[wall[i][0]][wall[i][1]] = 2;
            }

            visited = new boolean[MAX_SIZE][MAX_SIZE];
            int virusCnt = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (!visited[i][j] && matrix[i][j] == 3) {
                        virusCnt += spreadVirus(j, i);
                    }
                }
            }
            answer = Math.max(answer, (N * M - 3) - (virusCnt + wallCnt));
            virusCnt = 0;

            for (int i = 0; i < 3; i++) {
                matrix[wall[i][0]][wall[i][1]] = 1;
            }

            return;
        }

        for (int ny = y; ny <= N; ny++) {
            for (int nx = (ny == y ? x : 0); nx <= M; nx++) {
                if (matrix[ny][nx] == 1) {
                    wall[k] = new int[]{ny, nx};
                    selectWall(wall, nx + 1, ny, k + 1);
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

        // 0-1. 지도 정보 입력: 2차원 배열
        // (1: 빈칸) (2: 벽) (3: 바이러스)
        matrix = new int[MAX_SIZE][MAX_SIZE];
        for (int i = 0; i < N; i++) {
            param = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int mark = Integer.parseInt(param[j]) + 1;
                if (mark == 2) wallCnt++;
                matrix[i + 1][j + 1] = mark;
            }
        }

        selectWall(new int[3][2], 1, 1, 0);

        System.out.println(answer);
    }
}
