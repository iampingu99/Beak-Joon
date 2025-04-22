import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N; // 1 ≤ N ≤ 50
    static int L, R; // 1 ≤ L ≤ R ≤ 100
    static int[][] matrix;
    static boolean[][] visited;
    static List<Position> unions;
    static int sum;
    static boolean isOpen;

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static void dfs(int x, int y) {
        visited[y][x] = true;
        unions.add(new Position(x, y));
        sum += matrix[y][x];

        for (int d = 0; d < dx.length; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[ny][nx]) {
                int diff = Math.abs(matrix[y][x] - matrix[ny][nx]);
                if (L <= diff && diff <= R) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        L = Integer.parseInt(param[1]);
        R = Integer.parseInt(param[2]);

        // 1. 땅 정보(각 나라의 인구수) 입력:
        matrix = new int[N][N];
        for (int y = 0; y < N; y++) {
            matrix[y] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // 2. dfs 탐색:
        int day = 0;
        while (true) {
            isOpen = false;
            visited = new boolean[N][N];

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (!visited[y][x]) {
                        unions = new ArrayList<>();
                        sum = 0;
                        dfs(x, y);
                        // 연합 국가가 1개 이상인 경우 인구 이동
                        if (unions.size() > 1) {
                            int avg = sum / unions.size();
                            for (Position position : unions) {
                                matrix[position.y][position.x] = avg;
                            }
                            isOpen = true;
                        }
                    }
                }
            }
            // 인구 이동이 발생하지 않는 경우 종료
            if (!isOpen) break;
            day++;
        }
        System.out.println(day);
    }
}
