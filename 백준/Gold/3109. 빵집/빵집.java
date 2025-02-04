import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_SIZE = 10000 + 2;

    static int R; // 1 ≤ R ≤ 10,000
    static int C; // 5 ≤ C ≤ 500
    static char[][] matrix;
    static boolean[][] visited;
    static boolean isFind;
    static int answer;

    // NE E SE
    static int[] dy = {-1, 0, 1};

    static void dfs(int x, int y) {
        if (x == C) {
            answer++;
            isFind = true;
            return;
        }

        visited[y][x] = true;
        for (int d = 0; d < dy.length && !isFind; d++) {
            int nx = x + 1;
            int ny = y + dy[d];
            if (!visited[ny][nx] && matrix[ny][nx] != '\u0000' && matrix[ny][nx] != 'x') {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        R = Integer.parseInt(param[0]);
        C = Integer.parseInt(param[1]);

        matrix = new char[MAX_SIZE][MAX_SIZE];
        for (int i = 1; i <= R; i++) {
            String str = br.readLine();
            for (int j = 1; j <= C; j++) {
                matrix[i][j] = str.charAt(j - 1);
            }
        }

        visited = new boolean[R+2][C+2];
        for (int y = 1; y <= R; y++) {
            isFind = false;
            dfs(1, y);
        }

        System.out.println(answer);
    }
}
