import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_SIZE = 100 + 2;
    static int N; //  2 ≤ N ≤ 100
    static int[][] matrix; // 1 ≤ ≤ 100
    static boolean[][] visited;
    static int height = 100;
    static int answer = 1; //비가 안오는 경우

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    // 2차원 배열 dfs 순회(N E S W)
    static void dfs(int x, int y) {
        visited[y][x] = true;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (matrix[ny][nx] > height && !visited[ny][nx]) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        matrix = new int[MAX_SIZE][MAX_SIZE];

        // 1. 2차원 배열 정보 채우기
        for (int i = 1; i <= N; i++) {
            String[] param = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = Integer.parseInt(param[j - 1]);
            }
        }

        // 2. dfs 순회 + 묶음 개수 찾기
        while (height-- > 0) {
            int count = 0;
            visited = new boolean[MAX_SIZE][MAX_SIZE];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (matrix[i][j] > height && !visited[i][j]) {
                        dfs(j, i);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }

        // 3. 출력
        System.out.println(answer);
    }
}
