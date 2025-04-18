import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Main {
    static class Camera {
        final Deque<Integer> dir = new ArrayDeque<>();
        int x, y;

        public Camera(int x, int y, int type) {
            switch (type) {
                case 1: {
                    this.dir.addAll(List.of(0, 1, 0, 0));
                    break;
                }
                case 2: {
                    this.dir.addAll(List.of(0, 1, 0, 1));
                    break;
                }
                case 3: {
                    this.dir.addAll(List.of(1, 1, 0, 0));
                    break;
                }
                case 4: {
                    this.dir.addAll(List.of(1, 1, 0, 1));
                    break;
                }
                case 5: {
                    this.dir.addAll(List.of(1, 1, 1, 1));
                    break;
                }
            }
            this.x = x;
            this.y = y;
        }

        public void rotate() {
            dir.offer(dir.poll());
        }

    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};


    static int N, M; // 1 ≤ N(세로), M(가로) ≤ 8
    static int[][] matrix; // 0(빈칸), 1~5(cctv), 6(벽)

    static List<Camera> cameras = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    static void dfs(int k) {
        if (k == cameras.size()) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (matrix[i][j] == 0) count++;
                }
            }
            answer = Math.min(count, answer);
            return;
        }

        Camera camera = cameras.get(k);
        for (int i = 0; i < camera.dir.size(); i++) {
            int[][] temp = new int[N][M];
            for (int y = 0; y < N; y++) {
                temp[y] = Arrays.copyOf(matrix[y], M);
            }

            int r = 0;
            for (int dir : camera.dir) {
                if (dir != 0) {
                    int nx = camera.x + dx[r];
                    int ny = camera.y + dy[r];

                    while (nx >= 0 && ny >= 0 && nx < M && ny < N && matrix[ny][nx] != 6) {
                        if (matrix[ny][nx] == 0) matrix[ny][nx] = 7;
                        nx += dx[r];
                        ny += dy[r];
                    }
                }
                r++;
            }

            dfs(k + 1);
            matrix = temp;
            camera.rotate();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        matrix = new int[N][M];
        for (int y = 0; y < N; y++) {
            param = br.readLine().split(" ");
            for (int x = 0; x < M; x++) {
                int type = Integer.parseInt(param[x]);
                matrix[y][x] = type;
                if (type == 0 || type == 6) continue;
                cameras.add(new Camera(x, y, type));
            }
        }

        dfs(0);
        System.out.println(answer);
    }
}
