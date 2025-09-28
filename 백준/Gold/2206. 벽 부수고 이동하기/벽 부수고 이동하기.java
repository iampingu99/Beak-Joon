import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    static class Node {
        int x, y, dist, isBreak;

        public Node(int x, int y, int dist, int isBreak) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.isBreak = isBreak;
        }
    }

    static int N, M;
    static int[][] matrix;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][2];
        queue.offer(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.x == M - 1 && curr.y == N - 1) {
                return curr.dist;
            }

            for (int d = 0; d < dx.length; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

                if (matrix[ny][nx] == 0 && !visited[ny][nx][curr.isBreak]) {
                    queue.offer(new Node(nx, ny, curr.dist + 1, curr.isBreak));
                    visited[ny][nx][curr.isBreak] = true;
                }

                if (matrix[ny][nx] == 1 && curr.isBreak == 0) {
                    queue.offer(new Node(nx, ny, curr.dist + 1, 1));
                    visited[ny][nx][1] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        matrix = new int[N][M];
        for (int y = 0; y < N; y++) {
            matrix[y] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        System.out.println(bfs());
    }
}
