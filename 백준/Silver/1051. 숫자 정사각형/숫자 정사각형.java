import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, M; // 1 ≤ N, M ≤ 50
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        matrix = new int[N][M];
        int maxSize = 1;

        // 0-1. 직사각형 배열 채우기
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = str.charAt(j) - '0';
            }
        }

        // 1. 모든 정사각형 중 조건을 만족하는 가장 큰 정사각형 찾기
        for (int size = 1; size < Math.min(N, M); size++) {
            for (int i = 0; i + size < N; i++) {
                for (int j = 0; j + size < M; j++) {
                    if ((matrix[i][j] == matrix[i][j + size]) && (matrix[i + size][j] == matrix[i + size][j + size])
                            && (matrix[i][j] == matrix[i + size][j + size])) {
                        maxSize = size + 1;
                    }
                }
            }
        }
        System.out.println(maxSize * maxSize);
    }
}
