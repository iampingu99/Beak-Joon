import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    static final int MAX_SIZE = 8 + 2;
    static final int BLACK = 1;
    static final int WHITE = -1;

    static int T; // T(테스트)
    static int N, M; // N(보드 길이 4, 6, 8), M(포석 회수)
    static int[][] matrix;

    // N NE E SE S SW W NW
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] param = br.readLine().split(" ");
            N = Integer.parseInt(param[0]);
            M = Integer.parseInt(param[1]);

            matrix = new int[N + 2][N + 2];
            matrix[N / 2][N / 2] = WHITE;
            matrix[N / 2 + 1][N / 2 + 1] = WHITE;
            matrix[N / 2][N / 2 + 1] = BLACK;
            matrix[N / 2 + 1][N / 2] = BLACK;

            for (int i = 0; i < M; i++) {
                param = br.readLine().split(" ");
                int x = Integer.parseInt(param[0]);
                int y = Integer.parseInt(param[1]);
                int c = param[2].equals("1") ? 1 : -1;

                matrix[y][x] = c;
                for (int d = 0; d < dx.length; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    List<int[]> list = new ArrayList<>();
                    while (matrix[ny][nx] == -c) {
                        list.add(new int[]{nx, ny});
                        nx += dx[d];
                        ny += dy[d];
                    }
                    if (matrix[ny][nx] == c) {
                        for (int[] pos : list) {
                            matrix[pos[1]][pos[0]] = c;
                        }
                    }
                }
            }

            int blackCnt = 0;
            int whiteCnt = 0;
            for (int y = 1; y <= N; y++) {
                for (int x = 1; x <= N; x++) {
                    if (matrix[y][x] == 1) blackCnt++;
                    if (matrix[y][x] == -1) whiteCnt++;
                }
            }

            System.out.printf("#%d %d %d\n", t, blackCnt, whiteCnt);
        }

    }
}
