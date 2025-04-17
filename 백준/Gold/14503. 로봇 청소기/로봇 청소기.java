import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Position {
        int x, y, d;

        public Position(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static int N, M; // 3 ≤ N(세로), M(가로) ≤ 50
    static int[][] matrix; // 0(미 청소), 1(벽), 2(청소)

    // "d가 0인 경우 북쪽, 1인 경우 동쪽, 2인 경우 남쪽,3인 경우 서쪽을 바라보고 있는 것이다."
    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        // 1. 청소기 상태 입력
        param = br.readLine().split(" ");
        int y = Integer.parseInt(param[0]);
        int x = Integer.parseInt(param[1]);
        int d = Integer.parseInt(param[2]);
        Position start = new Position(x, y, d);

        // 2. 장소의 상태 입력: 1-based
        matrix = new int[N][M];
        for (y = 0; y < N; y++) {
            param = br.readLine().split(" ");
            for (x = 0; x < M; x++) {
                matrix[y][x] = Integer.parseInt(param[x]);
            }
        }

        int count = 0;
        while (true) {
            // 1. (y, x) 청소 할 수 있는 경우: (y, x) 청소
            if (matrix[start.y][start.x] == 0) {
                matrix[start.y][start.x] = 2;
                count++;
            }

            // 2. N E S W 방향에 청소할 곳이 존재하지 않는 경우:
            // 2-1. 바라보는 방향으로 한칸 후진
            // 2-2. 벽이라 후진할 수 없는 경우 종료
            if (isClean(start.x, start.y)) {
                start.x -= dx[start.d];
                start.y -= dy[start.d];
                if (matrix[start.y][start.x] == 1) break;
            }

            // 3. N E S W 방향에 청소할 곳이 존재하는 경우:
            // 3-1. (1) 반시계 방향으로 90도 회전 (1-1) 바라보는 방향을 청소할 수 있는 경우 전진
            else {
                start.d = (start.d + dx.length - 1) % dx.length;
                if (matrix[start.y + dy[start.d]][start.x + dx[start.d]] == 0) {
                    start.x += dx[start.d];
                    start.y += dy[start.d];
                }
            }
        }
        System.out.println(count);
    }

    static boolean isClean(int x, int y) {
        for (int d = 0; d < dx.length; d++) {
            if (matrix[y + dy[d]][x + dx[d]] == 0) return false;
        }
        return true;
    }
}
