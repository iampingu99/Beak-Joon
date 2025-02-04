import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final char MARK_EMPTY = '.';

    static int R; // 1 ≤ R ≤ 10,000
    static int C; // 5 ≤ C ≤ 500
    static char[][] matrix;

    // NE E SE: greedy 최선 경로 탐색 순서
    static int[] dy = {-1, 0, 1};

    // 최선 경로로 탐색 가능한 
    static boolean isConnected(int x, int y) {
        if (x == C - 1) return true;

        matrix[y][x] = 'x';
        for (int d = 0; d < dy.length; d++) {
            int nx = x + 1;
            int ny = y + dy[d];
            if (ny >= 0 && ny < R && matrix[ny][nx] == MARK_EMPTY) {
                if (isConnected(nx, ny)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        R = Integer.parseInt(param[0]);
        C = Integer.parseInt(param[1]);

        // 0-1. 빵집 모습 입력
        matrix = new char[R][];
        for (int i = 0; i < R; i++) {
            matrix[i] = br.readLine().toCharArray();
        }

        // 1. 최적 가스관 연결: NE, E, SE 순서로 가스관을 연결
        // 1-1. 연결 가능한지 확인
        int answer = 0;
        for (int y = 0; y < R; y++) {
            if (isConnected(0, y)) answer++;
        }

        System.out.println(answer);
    }
}
