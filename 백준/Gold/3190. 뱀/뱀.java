import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static class State {
        int x, y, d;

        public State(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static final int BLANK = 0;
    static final int APPLE = 1;
    static final int SNAKE = 2;

    static int N; // 2 ≤ N(보드 크기) ≤ 100;
    static int K; // 0 ≤ K(사과 개수) ≤ 100;
    static int[][] matrix;
    static final Deque<int[]> ops = new ArrayDeque<>();
    static final Deque<State> snake = new ArrayDeque<>();

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        // 1. 사과 정보 입력:
        matrix = new int[N][N];
        for (int k = 0; k < K; k++) {
            String[] param = br.readLine().split(" ");
            int y = Integer.parseInt(param[0]) - 1;
            int x = Integer.parseInt(param[1]) - 1;
            matrix[y][x] = 1;
        }

        // 2. 방향 전환 정보 입력: 나머지 연산을 사용한 방향 전환을 위한 파싱
        int L = Integer.parseInt(br.readLine());
        for (int l = 0; l < L; l++) {
            String[] param = br.readLine().split(" ");
            int x = Integer.parseInt(param[0]) + 1;
            int c = param[1].equals("D") ? 1 : 3;
            ops.offer(new int[]{x, c});
        }

        // 3. 뱀 게임 구현
        int time = 0;
        matrix[0][0] = SNAKE;
        snake.offer(new State(0, 0, 1));

        while (true) {
            time++;

            // 3-1. 머리 방향: 현재 머리와 같은 방향 / 전환된 방향
            State cHead = snake.peekLast();
            int d = cHead.d;
            if (!ops.isEmpty() && time == ops.peek()[0]) d = (d + ops.poll()[1]) % 4;

            // 3-2. 머리 이동: 벽이나 몸에 부딧히면 종료
            int nx = cHead.x + dx[d];
            int ny = cHead.y + dy[d];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || matrix[ny][nx] == SNAKE) break;
            snake.offer(new State(nx, ny, d));

            // 3-3. 꼬리 이동: 머리가 이동한 칸에 사과가 아닌 경우 현재 꼬리 제외
            if (matrix[ny][nx] == APPLE) continue;
            State pTail = snake.poll();
            
            matrix[ny][nx] = SNAKE; // 기존 머리는 몸통
            matrix[pTail.y][pTail.x] = BLANK; // 현재 꼬리 제외
        }

        // 4. 출력
        System.out.println(time);
    }
}
