import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static final int MAX_SIZE = 27;
    static int N; // 5 ≤ N ≤ 25
    static int[][] matrix;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int count;
    static ArrayList<Integer> answer;

    static void dfs(int x, int y) {
        matrix[y][x] = 0;
        count++;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (matrix[ny][nx] == 1) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        matrix = new int[MAX_SIZE][MAX_SIZE];
        answer = new ArrayList<>();

        // 1. 정보 채우기
        for (int i = 1; i <= N; i++) {
            String[] param = br.readLine().split("");
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = Integer.parseInt(param[j - 1]);
            }
        }

        // 2. dfs
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (matrix[i][j] == 1) {
                    dfs(j, i);
                    answer.add(count);
                    count = 0;
                }
            }
        }

        // 3. 출력: 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력
        sb.append(answer.size()).append("\n");
        Collections.sort(answer);
        for (int v : answer) {
            sb.append(v).append("\n");
        }
        System.out.println(sb);
    }
}
