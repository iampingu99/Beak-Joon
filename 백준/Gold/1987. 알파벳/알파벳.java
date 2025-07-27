import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static final int MAX_PATH = 26; // 알파벳 최대 개수
    static int R, C; // 1 ≤ R,C ≤ 20
    static char[][] matrix;
    static int answer;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static void dfs(int x, int y, Set<Character> path, int count) {
        if (answer == MAX_PATH) return;
        path.add(matrix[y][x]);

        for (int d = 0; d < dx.length; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < C && ny < R &&
                    !path.contains(matrix[ny][nx])) {
                dfs(nx, ny, path, count + 1);

            }
        }

        answer = Math.max(answer, count);
        path.remove(matrix[y][x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        R = Integer.parseInt(param[0]);
        C = Integer.parseInt(param[1]);

        // 0. 2차원 배열 입력
        matrix = new char[R][C];
        for (int y = 0; y < R; y++) {
            matrix[y] = br.readLine().toCharArray();
        }

        // 1. dfs: O(N^2)
        dfs(0, 0, new HashSet<>(), 1);

        System.out.println(answer);
    }
}
