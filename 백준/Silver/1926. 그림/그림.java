import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_SIZE = 500 + 2;
    static int N; // 1 ≤ N ≤ 500
    static int M; // 1 ≤ M ≤ 500
    static boolean[][] matrix;
    static int count;

    //N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    // dfs 순회 + 연결된 요소 개수
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

        matrix = new boolean[MAX_SIZE][MAX_SIZE];
        for (int i = 1; i <= N; i++) {
            param = br.readLine().split(" ");
            for (int j = 1; j <= M; j++) {
                matrix[i][j] = param[j - 1].equals("1");
            }
        }

        // 1. dfs 순회 + 묶음 개수
        int[] answer = new int[2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (matrix[i][j]) {
                    dfs(j, i);
                    answer[0]++;
                    answer[1] = Math.max(answer[1], count);
                    count = 0;
                }
            }
        }

        // 2. 출력
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}
