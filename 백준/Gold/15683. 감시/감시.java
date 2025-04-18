import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

    static class Camera {
        final Queue<Integer> dirs = new ArrayDeque<>(); // 감시 가능한 방향
        int x, y;

        public Camera(int x, int y, int type) {
            switch (type) {
                case 1: {
                    this.dirs.addAll(List.of(0, 1, 0, 0));
                    break;
                }
                case 2: {
                    this.dirs.addAll(List.of(0, 1, 0, 1));
                    break;
                }
                case 3: {
                    this.dirs.addAll(List.of(1, 1, 0, 0));
                    break;
                }
                case 4: {
                    this.dirs.addAll(List.of(1, 1, 0, 1));
                    break;
                }
                case 5: {
                    this.dirs.addAll(List.of(1, 1, 1, 1));
                    break;
                }
            }
            this.x = x;
            this.y = y;
        }


        public void rotate() {
            dirs.offer(dirs.poll());
        }
    }

    static int answer = Integer.MAX_VALUE;
    static int N, M; // 1 ≤ N(세로), M(가로) ≤ 8
    static int[][] matrix; // 0(빈칸), 1~5(cctv), 6(벽)
    static List<Camera> cameras = new ArrayList<>();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    // 모든 cctv 방향 경우의 수
    static void permutation(int k, int[][] result) {
        if (k == cameras.size()) {
            answer = Math.min(answer, countUnWatch(result));
            return;
        }

        // 각 cctv 방향 결정 및 감시 범위 탐색
        Camera camera = cameras.get(k);
        for (int i = 0; i < camera.dirs.size(); i++) {
            int[][] copy = new int[N][M];
            for (int y = 0; y < N; y++) {
                copy[y] = result[y].clone();
            }

            int dirIdx = 0;
            for (int dir : camera.dirs) {
                if (dir != 0) watch(camera.x, camera.y, dirIdx, copy);
                dirIdx++;
            }

            permutation(k + 1, copy);
            camera.rotate();
        }
    }
    
    static void watch(int x, int y, int d, int[][] matrix) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        while (nx >= 0 && ny >= 0 && nx < M && ny < N && matrix[ny][nx] != 6) {
            if (matrix[ny][nx] == 0) matrix[ny][nx] = 7;
            nx += dx[d];
            ny += dy[d];
        }
    }

    static int countUnWatch(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 0) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        // 1. 사무실 및 cctv 정보 입력
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

        // 2. cctv 방향 경우의 수
        permutation(0, matrix);
        
        // 3. 출력
        System.out.println(answer);
    }
}
