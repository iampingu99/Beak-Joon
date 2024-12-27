import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static final int MAX_SIZE = 25 + 2;
    static int N; // 5 ≤ N ≤ 25
    static boolean[][] matrix;
    static int count;
    static ArrayList<Integer> answer;

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    // 2차원 배열 dfs 순회(N E S W) + 연결 개수 찾기
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
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        matrix = new boolean[MAX_SIZE][MAX_SIZE];
        answer = new ArrayList<>();

        // 1. 정보 채우기
        for (int i = 1; i <= N; i++) {
            String param = br.readLine();
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = param.charAt(j - 1) == '1';
            }
        }

        // 2. dfs
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (matrix[i][j]) {
                    dfs(j, i);
                    answer.add(count);
                    count = 0;
                }
            }
        }

        // 3. 출력: 단지 수 + 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력
        sb.append(answer.size()).append("\n");

        Collections.sort(answer);
        for (int v : answer) {
            sb.append(v).append("\n");
        }
        System.out.println(sb);
    }
}
