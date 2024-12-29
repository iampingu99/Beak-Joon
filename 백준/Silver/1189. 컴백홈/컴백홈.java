import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int START_C = 1; //시작 지점 : (r, 1)
    static final int END_R = 1; // 종료 지점 : (1, c)
    static final int MAX_SIZE = 5 + 2;

    static int R, C; // 1 ≤ R, C ≤ 5
    static int K; // 1 ≤ K ≤ R×C
    static boolean[][] matrix;
    static int answer;

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    // 4방향 dfs 순회
    static void dfs(int x, int y, int depth) {
        if (depth == K) {
            if (x == C && y == END_R) {
                answer++;
            }
            return;
        }
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (matrix[ny][nx]) {
                matrix[ny][nx] = false;
                dfs(nx, ny, depth + 1);
                matrix[ny][nx] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        R = Integer.parseInt(param[0]);
        C = Integer.parseInt(param[1]);
        K = Integer.parseInt(param[2]);

        // 1. 2차원 배열 정보 채우기
        matrix = new boolean[MAX_SIZE][MAX_SIZE];
        for (int i = 1; i <= R; i++) {
            String str = br.readLine();
            for (int j = 1; j <= C; j++) {
                matrix[i][j] = str.charAt(j - 1) != 'T';
            }
        }

        // 2. dfs
        matrix[R][1] = false;
        dfs(START_C, R, 1);

        // 3. 출력
        System.out.println(answer);
    }
}
