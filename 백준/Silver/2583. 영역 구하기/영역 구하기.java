import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static final int MAX_SIZE = 100 + 2;
    static int M, N, K; // 1 ≤ M, N, K ≤ 100
    static boolean[][] matrix;
    static int count;
    static ArrayList<Integer> answer;

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    // 2차원 배열 dfs 순회 + 연결 개수 찾기
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
        StringBuilder sb = new StringBuilder();

        String[] param = br.readLine().split(" ");
        int M = Integer.parseInt(param[0]);
        int N = Integer.parseInt(param[1]);
        int K = Integer.parseInt(param[2]);

        matrix = new boolean[MAX_SIZE][MAX_SIZE];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = true;
            }
        }
        answer = new ArrayList<>();

        // 1. 2차원 배열 정보 채우기
        while (K-- > 0) {
            param = br.readLine().split(" ");
            int x1 = Integer.parseInt(param[0]) + 1;
            int y1 = Integer.parseInt(param[1]) + 1;
            int x2 = Integer.parseInt(param[2]);
            int y2 = Integer.parseInt(param[3]);
            for (int i = y1; i <= y2; i++) {
                for (int j = x1; j <= x2; j++) {
                    matrix[i][j] = false;
                }
            }
        }

        // 2. dfs 순회
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (matrix[i][j]) {
                    dfs(j, i);
                    answer.add(count);
                    count = 0;
                }
            }
        }

        // 3. 출력
        sb.append(answer.size()).append("\n");

        Collections.sort(answer);
        for (int v : answer) {
            sb.append(v).append(" ");
        }
        System.out.println(sb);
    }
}
