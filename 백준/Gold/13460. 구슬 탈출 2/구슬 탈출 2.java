import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class State {
        Coordinate red, blue;
        int move;

        public State() {
        }

        public State(Coordinate red, Coordinate blue, int move) {
            this.red = red;
            this.blue = blue;
            this.move = move;
        }
    }

    static int N, M; // 3 ≤ N(세로), M(가로) ≤ 10
    static char[][] matrix; // #, ., R, B, O
    static boolean[][][][] visited;

    // "왼쪽으로 기울이기, 오른쪽으로 기울이기, 위쪽으로 기울이기, 아래쪽으로 기울이기와 같은 네 가지 동작이 가능하다."
    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int bfs(State start) {
        Queue<State> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.red.y][start.red.x][start.blue.y][start.blue.x] = true;

        while (!queue.isEmpty()) {
            State curr = queue.poll();
            // "만약, 10번 이하로 움직여서 빨간 구슬을 구멍을 통해 빼낼 수 없으면 -1을 출력한다."
            // 10번 움직인 상태에서 더 움직인 상태는 탐색하지 않도록 한다.
            if (curr.move >= 10) continue;

            for (int d = 0; d < dx.length; d++) {
                int distR = 0, distB = 0;
                int nRx = curr.red.x;
                int nRy = curr.red.y;
                int nBx = curr.blue.x;
                int nBy = curr.blue.y;

                // 빨간 구슬 이동
                while (matrix[nRy + dy[d]][nRx + dx[d]] != '#') {
                    nRx += dx[d];
                    nRy += dy[d];
                    distR++;
                    if (matrix[nRy][nRx] == 'O') break;
                }

                // 파란 구슬 이동
                while (matrix[nBy + dy[d]][nBx + dx[d]] != '#') {
                    nBx += dx[d];
                    nBy += dy[d];
                    distB++;
                    if (matrix[nBy][nBx] == 'O') break;
                }

                // "파란 구슬이 구멍에 빠지거나, 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패"
                // 파란 구슬이 빠지는 경우 실패로 처리한다.
                if (matrix[nBy][nBx] == 'O') continue;
                // "빨간 구슬이 구멍에 빠지면 성공"
                if (matrix[nRy][nRx] == 'O') return curr.move + 1;

                // "빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다."
                // 더 먼 거리를 이동한 구슬은 같은 칸에 늦게 도착하므로 한 칸 덜 이동한다.
                if (nRx == nBx && nRy == nBy) {
                    if (distR < distB) {
                        nBx -= dx[d];
                        nBy -= dy[d];
                    } else {
                        nRx -= dx[d];
                        nRy -= dy[d];
                    }
                }

                if (!visited[nRy][nRx][nBy][nBx]) {
                    visited[nRy][nRx][nBy][nBx] = true;
                    queue.offer(new State(new Coordinate(nRx, nRy), new Coordinate(nBx, nBy), curr.move + 1));
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        matrix = new char[N][M];
        visited = new boolean[N][M][N][M];
        State start = new State();

        // 1. 보드 입력
        for (int y = 0; y < N; y++) {
            String str = br.readLine();
            for (int x = 0; x < M; x++) {
                char ch = str.charAt(x);
                if (ch == 'R') start.red = new Coordinate(x, y);
                if (ch == 'B') start.blue = new Coordinate(x, y);
                matrix[y][x] = ch;
            }
        }

        // 2. 최단거리 bfs 탐색
        // 3. 출력
        System.out.println(bfs(start));
    }
}
