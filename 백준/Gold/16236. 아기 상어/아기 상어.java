import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static class Position {
        int x, y, dist;

        public Position(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static class Fish {
        Position position;
        int size;

        public Fish(Position position, int size) {
            this.position = position;
            this.size = size;
        }
    }

    static int N; // 2 ≤ N ≤ 20;
    static int[][] matrix; // 0(빈칸), 1~6(물고기), 9(아기상어)
    static boolean[][] visited;

    // "아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다."
    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int size = 2;
    static PriorityQueue<Fish> fishes;

    static void bfs(Position start) {
        fishes = new PriorityQueue<>(
                Comparator.comparingInt((Fish f) -> f.position.dist)
                        .thenComparingInt(f -> f.position.y)
                        .thenComparingInt(f -> f.position.x)
        );

        Queue<Position> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.y][start.x] = true;

        while (!queue.isEmpty()) {
            Position curr = queue.poll();
            for (int d = 0; d < dx.length; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[ny][nx] && matrix[ny][nx] <= size) {
                    Position position = new Position(nx, ny, curr.dist + 1);
                    queue.offer(position);
                    visited[ny][nx] = true;
                    if (matrix[ny][nx] > 0 && matrix[ny][nx] < size) fishes.offer(new Fish(position, matrix[ny][nx]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];

        Position start = null;
        for (int y = 0; y < N; y++) {
            String[] param = br.readLine().split(" ");
            for (int x = 0; x < N; x++) {
                int size = Integer.parseInt(param[x]);
                if (size == 9) {
                    start = new Position(x, y, 0);
                    size = 0;
                }
                matrix[y][x] = size;
            }
        }

        int count = 0;
        int answer = 0;
        while (true) {
            if (count == size) {
                size++;
                count = 0;
            }

            visited = new boolean[N][N];
            bfs(start);
            if (fishes.isEmpty()) break;

            Fish fish = fishes.poll();
            Position position = fish.position;
            matrix[position.y][position.x] = 0;

            start = new Position(position.x, position.y, 0);
            count++;
            answer += fish.position.dist;
        }

        System.out.println(answer);
    }
}
