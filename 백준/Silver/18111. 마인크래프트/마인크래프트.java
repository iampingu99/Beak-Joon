import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M; // 1 ≤ N, M ≤ 500
    static int B; // 0 ≤ B ≤ 6.4 × 10^7
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);
        B = Integer.parseInt(param[2]);

        // 0-1. 집터 입력: 2차원 배열
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            param = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(param[j]);
            }
        }

        // 1. 최소높이부터 최대높이까지 땅을 고르게 만들 수 있는 최소 시간 O(257 * 500 * 500) = O(64,250,000)
        // 높이보다 땅이 높은 경우: 블럭을 캔다
        // 높이보다 땅이 낮은 경우: 블럭을 채운다
        int time, inventory;
        int minTime = Integer.MAX_VALUE, maxHeight = 0;
        for (int h = 0; h <= 256; h++) {
            time = 0;
            inventory = B;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (matrix[i][j] > h) {
                        time += 2 * (matrix[i][j] - h);
                        inventory += matrix[i][j] - h;
                    } else if (matrix[i][j] < h) {
                        time += h - matrix[i][j];
                        inventory -= h - matrix[i][j];
                    }
                }
            }
            if (inventory >= 0 && minTime >= time) {
                minTime = time;
                maxHeight = h;
            }
        }

        // 2. 출력
        System.out.println(minTime + " " + maxHeight);
    }
}
