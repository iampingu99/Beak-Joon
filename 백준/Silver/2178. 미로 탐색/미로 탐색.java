import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static final int MAX_SIZE = 100 + 2;
    static int N, M; // 2 ≤ N(세로 길이), M(가로 길이) ≤ 100
    static boolean[][] matrix;

    static class Node {
        int x, y, dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int bfs(Node u) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[MAX_SIZE][MAX_SIZE];
        queue.offer(u);
        visited[u.y][u.x] = true;

        while (!queue.isEmpty()) {
            Node v = queue.poll();
            if (v.y == N && v.x == M) return v.dist;
            for (int d = 0; d < dx.length; d++) {
                int nx = v.x + dx[d];
                int ny = v.y + dy[d];
                if (!visited[ny][nx] && matrix[ny][nx]) {
                    queue.offer(new Node(nx, ny, v.dist + 1));
                    visited[ny][nx] = true;
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

        matrix = new boolean[MAX_SIZE][MAX_SIZE];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                matrix[i][j] = str.charAt(j - 1) == '1';
            }
        }

        System.out.println(bfs(new Node(1, 1, 1)));
    }

}
