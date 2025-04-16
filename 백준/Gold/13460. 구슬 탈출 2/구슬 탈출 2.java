import java.io.BufferedReader;
import java.io.FileReader;
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

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int bfs(State start) {
        Queue<State> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.red.y][start.red.x][start.blue.y][start.blue.x] = true;

        while (!queue.isEmpty()) {
            State curr = queue.poll();
            if (curr.move >= 10) continue;

            for (int d = 0; d < dx.length; d++) {
                int distR = 0, distB = 0;
                int nRx = curr.red.x;
                int nRy = curr.red.y;
                int nBx = curr.blue.x;
                int nBy = curr.blue.y;

                while (matrix[nRy + dy[d]][nRx + dx[d]] != '#') {
                    nRx += dx[d];
                    nRy += dy[d];
                    distR++;
                    if (matrix[nRy][nRx] == 'O') break;
                }

                while (matrix[nBy + dy[d]][nBx + dx[d]] != '#') {
                    nBx += dx[d];
                    nBy += dy[d];
                    distB++;
                    if (matrix[nBy][nBx] == 'O') break;
                }

                if (matrix[nBy][nBx] == 'O') continue;
                if (matrix[nRy][nRx] == 'O') return curr.move + 1;

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

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        matrix = new char[N][M];
        visited = new boolean[N][M][N][M];
        State start = new State();

        for (int y = 0; y < N; y++) {
            String str = br.readLine();
            for (int x = 0; x < M; x++) {
                char ch = str.charAt(x);
                if (ch == 'R') start.red = new Coordinate(x, y);
                if (ch == 'B') start.blue = new Coordinate(x, y);
                matrix[y][x] = ch;
            }
        }

        System.out.println(bfs(start));
    }
}
