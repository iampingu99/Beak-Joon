import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int W; //지도의 너비 : 1<= w <= 50
    static int H; //지도의 높이 : 1<= h <= 50
    static final int MAX = 50 + 2;
    static boolean[][] matrix;
    static int answer;

    //한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다.
    //E, SE, S, SW, W, NW, N, NE
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void dfs(int x, int y) {
        matrix[y][x] = false; //방문 처리
        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (matrix[ny][nx]) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력 : 입력의 마지막 줄에는 0이 두 개 주어진다.
        while (true) {
            // 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다.
            String[] token = br.readLine().split(" ");
            W = Integer.parseInt(token[0]);
            H = Integer.parseInt(token[1]);
            if (W == 0 && H == 0) {
                break;
            }

            // 둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.
            matrix = new boolean[MAX][MAX];
            for (int height = 1; height <= H; height++) {
                String position = br.readLine().replace(" ", "");
                for (int width = 1; width <= W; width++) {
                    matrix[height][width] = position.charAt(width - 1) == '1';
                }
            }

            //dfs 시작
            answer = 0;
            for (int height = 1; height <= H; height++) {
                for (int width = 1; width <= W; width++) {
                    if (matrix[height][width]) {
                        answer++;
                        dfs(width, height);
                    }
                }
            }
            
            //출력
            System.out.println(answer);
        }

    }
}
