import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static final int MAX_SIZE = 100 + 2;
    static int N;
    static int M;
    static char[][] matrix;
    static int count;

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    // 4방향 dfs 순회 + 연결된 요소 개수
    static void dfs(int x, int y, char c) {
        matrix[y][x] = '.';
        count++;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (matrix[ny][nx] == c) {
                dfs(nx, ny, c);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        // 1. 2차원 배열 정보 채우기
        matrix = new char[MAX_SIZE][MAX_SIZE];
        for (int i = 1; i <= M; i++) {
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = str.charAt(j - 1);
            }
        }

        // 2. dfs
        Map<Character, Integer> answer = new HashMap<>();
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                char c = matrix[i][j];
                if (c != '.') {
                    dfs(j, i, c);
                    answer.putIfAbsent(c, 0);
                    answer.put(c, answer.get(c) + count * count);
                    count = 0;
                }
            }
        }

        System.out.println(answer.get('W') + " " + answer.get('B'));
    }
}
