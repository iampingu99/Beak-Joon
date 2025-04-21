import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
    static int N; // 2 ≤ N(보드 크기) ≤ 100;
    static int K; // 0 ≤ K(사과 개수) ≤ 100;
    static int[][] matrix;
    static List<int[]> apples;
    static Deque<int[]> ops;

    static class State {
        int x, y, d;

        public State(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static final List<State> snake = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        matrix = new int[N][N];
        for (int k = 0; k < K; k++) {
            String[] param = br.readLine().split(" ");
            int y = Integer.parseInt(param[0]) - 1;
            int x = Integer.parseInt(param[1]) - 1;
            matrix[y][x] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        ops = new ArrayDeque<>();
        for (int l = 0; l < L; l++) {
            String[] param = br.readLine().split(" ");
            int x = Integer.parseInt(param[0]) + 1;
            int c;
            if (param[1].equals("D")) c = 1;
            else c = 3;
            ops.offer(new int[]{x, c});
        }

        int time = 0;
        matrix[0][0] = 2;
        snake.add(new State(0, 0, 1));
        while (true) {
            time++;
            // 머리
            State head = snake.get(snake.size() - 1);
            int d = head.d;
            if (!ops.isEmpty() && time == ops.peek()[0]) {
                d = (d + ops.peek()[1]) % 4;
                ops.poll();
            }

            int nx = head.x + dx[d];
            int ny = head.y + dy[d];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || matrix[ny][nx] == 2) break;

            snake.add(new State(nx, ny, d));
            // 꼬리
            if (matrix[ny][nx] == 1) continue;
            matrix[ny][nx] = 2;

            State tail = snake.remove(0);
            matrix[tail.y][tail.x] = 0;
        }

        System.out.println(time);
    }
}
