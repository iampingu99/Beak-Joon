import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_SIZE = 100 + 2;

    static int N, M; // 1 ≤ N, M ≤ 100
    static int K; // 1 ≤ K ≤ N×M
    static boolean[][] matrix;
    static int count;

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    // 4방향 dfs 순회 + 연결된 요소 개수
    static void dfs(int x, int y) {
        matrix[y][x] = false;
        count++;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (matrix[ny][nx]) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);
        K = Integer.parseInt(param[2]);
        
        matrix = new boolean[MAX_SIZE][MAX_SIZE];
        int answer = 0;

        // 1. 2차원 배열 정보 채우기
        while (K-- > 0) {
            param = br.readLine().split(" ");
            int r = Integer.parseInt(param[0]);
            int c = Integer.parseInt(param[1]);
            matrix[r][c] = true;
        }

        // 2. dfs
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (matrix[i][j]) {
                    dfs(j, i);
                    answer = Math.max(answer, count);
                    count = 0;
                }
            }
        }

        // 3. 출력
        System.out.println(answer);
    }
}
