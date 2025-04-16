import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static class Node {
        int x, y, dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static final int MAX_SIZE = 100 + 2;

    static int N, M; // 2 ≤ N(세로), M(가로) ≤ 100
    static boolean[][] matrix;

    // "한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다"
    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    // "(1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수"
    // shortest-path
    static int bfs(Node start) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        matrix[start.y][start.x] = false;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (int d = 0; d < dx.length; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];
                if (matrix[ny][nx]) {
                    if (ny == N && nx == M) return curr.dist + 1;
                    queue.offer(new Node(nx, ny, curr.dist + 1));
                    matrix[ny][nx] = false;
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

        // 1. 미로 입력
        matrix = new boolean[MAX_SIZE][MAX_SIZE];
        for (int y = 1; y <= N; y++) {
            String str = br.readLine();
            for (int x = 1; x <= M; x++) {
                matrix[y][x] = str.charAt(x - 1) == '1';
            }
        }

        // 2. 최단 거리 탐색: bfs
        // 3. 출력
        System.out.println(bfs(new Node(1, 1, 1)));
    }
}
