import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final char RED = 'R';
    static final char GREEN = 'G';
    static final char BLUE = 'B';
    static final int MAX_SIZE = 100 + 2;

    static int N; // 1 ≤ N ≤ 100
    static char[][] matrix;
    static boolean[][] visited;

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static void dfs(int x, int y, char c) {
        if (matrix[y][x] == GREEN) {
            matrix[y][x] = RED;
        }
        visited[y][x] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (!visited[ny][nx] && matrix[ny][nx] == c) {
                dfs(nx, ny, c);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        matrix = new char[MAX_SIZE][MAX_SIZE];
        visited = new boolean[MAX_SIZE][MAX_SIZE];
        int rgbCount = 0;
        int rbCount = 0;

        // 1. 2차원 배열 정보 채우기
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = str.charAt(j - 1);
            }
        }

        // 2. 비 적록색약 dfs
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visited[i][j]) {
                    dfs(j, i, matrix[i][j]);
                    rgbCount++;
                }
            }
        }

        visited = new boolean[MAX_SIZE][MAX_SIZE];
        // 3. 적록색약 dfs
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visited[i][j]) {
                    dfs(j, i, matrix[i][j]);
                    rbCount++;
                }
            }
        }

        System.out.println(rgbCount + " " + rbCount);
    }
}
