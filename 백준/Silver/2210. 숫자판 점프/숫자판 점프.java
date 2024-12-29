import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static final int N = 5;
    static final int MAX_SIZE = 5 + 2;
    static int[][] matrix;
    static Set<String> answer;

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    // 2차원 배열 dfs 순회 + 순열
    static void dfs(int x, int y, int depth, int[] arr) {
        arr[depth] = matrix[y][x];

        if (depth == N) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]);
            }
            answer.add(sb.toString());
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (matrix[ny][nx] != -1) {
                dfs(nx, ny, depth + 1, arr);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        matrix = new int[MAX_SIZE][MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                matrix[i][j] = -1;
            }
        }
        answer = new HashSet<>();

        // 1. 2차원 배열 정보 채우기
        for (int i = 1; i <= N; i++) {
            String[] param = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = Integer.parseInt(param[j - 1]);
            }
        }

        // 2. dfs
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dfs(j, i, 0, new int[N + 1]);
            }
        }

        // 3. 출력
        System.out.println(answer.size());
    }
}
