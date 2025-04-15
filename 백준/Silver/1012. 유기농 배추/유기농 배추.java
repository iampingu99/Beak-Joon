import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static int M; //배추밭 가로길이 1 ≤ M ≤ 50
    static int N; //배추밭 세로길이 1 ≤ N ≤ 50
    static int K; //배추 개수 1 ≤ K ≤ 2500
    static final int MAX = 52;
    static boolean[][] matrix; //배추밭
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            String[] token = br.readLine().split(" ");
            M = Integer.parseInt(token[0]);
            N = Integer.parseInt(token[1]);
            K = Integer.parseInt(token[2]);
            matrix = new boolean[MAX][MAX];
            result = 0;

            for (int i = 0; i < K; i++) {
                String[] position = br.readLine().split(" ");
                int x = Integer.parseInt(position[0]);
                int y = Integer.parseInt(position[1]);
                matrix[y + 1][x + 1] = true;
            }

            for (int row = 1; row <= N; row++) {
                for (int col = 1; col <= M; col++) {
                    if (matrix[row][col]) {
                        result++;
                        dfs(col, row);
                    }
                }
            }

            System.out.println(result);
        }

    }

    //E S W N
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int x, int y) {
        matrix[y][x] = false;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (matrix[ny][nx]) {
                dfs(nx, ny);
            }
        }
    }
}
