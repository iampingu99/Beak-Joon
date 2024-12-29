import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static final char WOLF = 'v';
    static final char SHEEP = 'o';
    static final int MAX_SIZE = 250 + 2;

    static int R, C; // 3 ≤ R, C ≤ 250
    static char[][] matrix;
    static int sheepCnt, wolfCnt;

    // N E S W
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    // 4방향 dfs 순회 + 연결된 요소 개수
    static void dfs(int x, int y) {
        if (matrix[y][x] == SHEEP) {
            sheepCnt++;
        }
        if (matrix[y][x] == WOLF) {
            wolfCnt++;
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

        Map<Character, Integer> answer = new HashMap<>();
        answer.put(SHEEP, 0);
        answer.put(WOLF, 0);

        // 1. 2차원 배열 정보 채우기
        for (int i = 1; i <= R; i++) {
            String str = br.readLine();
            for (int j = 1; j <= C; j++) {
                matrix[i][j] = str.charAt(j - 1);
            }
        }

        // 2. dfs
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                char c = matrix[i][j];
                if (c == SHEEP || c == WOLF) {
                    dfs(j, i);
                    if (sheepCnt > wolfCnt) {
                        answer.put(SHEEP, answer.get(SHEEP) + sheepCnt);
                    } else {
                        answer.put(WOLF, answer.get(WOLF) + wolfCnt);
                    }
                    sheepCnt = 0;
                    wolfCnt = 0;
                }
            }
        }

        // 3. 출력
        System.out.println(answer.get(SHEEP) + " " + answer.get(WOLF));
    }
}
