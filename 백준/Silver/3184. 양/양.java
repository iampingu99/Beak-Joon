import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static final int MAX_SIZE = 250 + 2;
    static int R;
    static int C;
    static char[][] matrix;
    static int o;
    static int v;

    // N E S W
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    // 4방향 dfs 순회
    static void dfs(int x, int y) {
        if (matrix[y][x] == 'o') {
            o++;
        }
        if (matrix[y][x] == 'v') {
            v++;
        }
        matrix[y][x] = '#';
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            char c = matrix[ny][nx];
            if (c != '#' && c != '\u0000') {
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

        // 1. 2차원 배열 정보 채우기
        for (int i = 1; i <= R; i++) {
            String str = br.readLine();
            for (int j = 1; j <= C; j++) {
                matrix[i][j] = str.charAt(j - 1);
            }
        }

        // 2. dfs
        Map<Character, Integer> answer = new HashMap<>();
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (matrix[i][j] != '#') {
                    dfs(j, i);
                    answer.putIfAbsent('o', 0);
                    answer.putIfAbsent('v', 0);
                    if (o > v) {
                        answer.put('o', answer.get('o') + o);
                    } else {
                        answer.put('v', answer.get('v') + v);
                    }
                    o = 0;
                    v = 0;
                }
            }
        }

        // 3. 출력
        System.out.println(answer.get('o') + " " + answer.get('v'));
    }
}
