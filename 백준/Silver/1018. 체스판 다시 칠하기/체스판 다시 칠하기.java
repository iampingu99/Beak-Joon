import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int WHITE = 1;
    static final int BLACK = -1;

    static int N, M; //8 ≤ N, M ≤ 50
    static int[][] matrix;

    static int repaint(int x, int y, int color) {
        int count = 0;
        for (int i = y; i < y + 8; i++) {
            for (int j = x; j < x + 8; j++) {
                if (color != matrix[i][j]) {
                    count++;
                }
                color = -color;
            }
            color = -color;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);
        matrix = new int[N][M];

        // 1. 2차원 배열 정보 채우기
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = str.charAt(j) == 'W' ? 1 : -1;
            }
        }

        // 2. 현재 칸을 흰색 또는 검정색으로 정하고 다시 칠해야 하는 최소 개수 세기
        int answer = 64;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int whiteCnt = repaint(j, i, WHITE);
                int blackCnt = repaint(j, i, BLACK);
                answer = Math.min(answer, Math.min(whiteCnt, blackCnt));
            }
        }
        System.out.println(answer);
    }
}
