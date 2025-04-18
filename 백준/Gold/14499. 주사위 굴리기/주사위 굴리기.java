import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M; // 1 ≤ N(세로), M(가로) ≤ 20
    static int r, c;
    static int K; // 1 ≤ K(명령 개수) ≤ 1,000
    static int[] ops;
    static int[][] matrix;
    static int[] dice;
    static StringBuilder answer;

    // E W N S
    static int[] dx = {0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    static void dfs(int x, int y, int k) {
        if (k == K) return;

        int d = ops[k];
        int nx = x + dx[d];
        int ny = y + dy[d];

        // "바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며, 출력도 하면 안 된다."
        if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
            dfs(x, y, k + 1);
            return;
        }

        roll(d);

        // "이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사"
        if (matrix[ny][nx] == 0) {
            matrix[ny][nx] = dice[6];
        }

        // "0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0"
        else {
            dice[6] = matrix[ny][nx];
            matrix[ny][nx] = 0;
        }

        // "상단에 쓰여 있는 값"
        answer.append(dice[1]).append("\n");
        dfs(nx, ny, k + 1);
    }

    static void roll(int d) {
        int temp = dice[1];
        switch (d) {
            case 1: {
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = temp;
                break;
            }
            case 2: {
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = temp;
                break;
            }
            case 3: {
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = temp;
                break;
            }
            case 4: {
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = temp;
                break;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = new StringBuilder();

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);
        r = Integer.parseInt(param[2]);
        c = Integer.parseInt(param[3]);
        K = Integer.parseInt(param[4]);

        // 1. 지도 정보 입력
        matrix = new int[N][M];
        for (int y = 0; y < N; y++) {
            matrix[y] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // 2. 명령 정보 입력
        ops = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 3. 이동
        dice = new int[7]; // 주사위 전개도: 상단(1) 위(2) 우(3) 좌(4) 아래(5) 하단(6)
        dfs(c, r, 0);

        // 4. 출력
        System.out.println(answer);
    }
}
