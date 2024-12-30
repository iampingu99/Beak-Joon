import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int MAX_SIZE = 20 + 2;

    static int R, C; // 1 ≤ R, C ≤ 20
    static char[][] matrix;
    static boolean[][] visited;
    static int answer;

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static void dfs(int x, int y, Set<Character> path) {
        visited[y][x] = true;
        path.add(matrix[y][x]);

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (matrix[ny][nx] != '\u0000' && !visited[ny][nx] && !path.contains(matrix[ny][nx])) {
                dfs(nx, ny, path);
            }
        }
        visited[y][x] = false;
        answer = Math.max(answer, path.size());
        path.remove(matrix[y][x]);
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        R = Integer.parseInt(param[0]);
        C = Integer.parseInt(param[1]);

        matrix = new char[MAX_SIZE][MAX_SIZE];
        visited = new boolean[MAX_SIZE][MAX_SIZE];

        // 1. 2차원 배열 정보 채우기
        for (int i = 1; i <= R; i++) {
            String str = br.readLine();
            for (int j = 1; j <= C; j++) {
                matrix[i][j] = str.charAt(j - 1);
            }
        }

        // 2. dfs
        dfs(1, 1, new HashSet<>());

        // 3. 출력
        System.out.println(answer);
    }
}
