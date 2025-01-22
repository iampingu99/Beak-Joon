import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int AIR = 1;
    static final int CHEESE = 2;
    static final int MAX_SIZE = 100 + 2;
    static int N, M; // 5 ≤ N, M ≤ 100
    static int[][] matrix;
    static boolean[][] visited;

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static void dfs(int x, int y) {
        visited[y][x] = true;
        for (int d = 0; d < dx.length; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (!visited[ny][nx] && matrix[ny][nx] == AIR) {
                dfs(nx, ny);
            }
        }
    }

    static void dfs2(int x, int y) {
        int count = 0;
        visited[y][x] = true;
        for (int d = 0; d < dx.length; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (visited[ny][nx] && matrix[ny][nx] == AIR) {
                count++;
            }
            if (!visited[ny][nx] && matrix[ny][nx] == CHEESE) {
                dfs2(nx, ny);
            }
        }
        if (count >= 2) {
            matrix[y][x] = AIR;
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        // 0-1. 모눈종이 입력: 2차원 배열
        matrix = new int[MAX_SIZE][MAX_SIZE];
        for (int i = 1; i <= N; i++) {
            param = br.readLine().split(" ");
            for (int j = 1; j <= M; j++) {
                matrix[i][j] = Integer.parseInt(param[j - 1]) + 1;
            }
        }

        int hour;
        for (hour = 1; ; hour++) {
            int cheeseCnt = 0;
            visited = new boolean[MAX_SIZE][MAX_SIZE];
            // 1인 부분을 모두 찾음: 외부 공간
            dfs(1, 1);
            // 1인 부분을 모두 찾음: 내부 공간
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (!visited[i][j] && matrix[i][j] == CHEESE) {
                        dfs2(j, i);
                        cheeseCnt++;
                    }
                }
            }
            if (cheeseCnt == 0) break;
        }

        System.out.println(hour - 1);
    }
}
