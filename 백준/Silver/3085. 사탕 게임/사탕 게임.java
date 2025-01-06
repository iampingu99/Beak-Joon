import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_SIZE = 50 + 2;

    static int N; // 3 ≤ N ≤ 50
    static char[][] board; // 빨간색: C, 파란색: P, 초록색: Z, 노란색: Y

    // E S
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static int getRowCandy(int col) {
        int rowCandy = 1, count = 1;
        for (int i = 1; i <= N; i++) {
            if (board[col][i] == board[col][i + 1]) {
                count++;
            } else {
                rowCandy = Math.max(count, rowCandy);
                count = 1;
            }
        }
        return rowCandy;
    }

    static int getColCandy(int row) {
        int colCandy = 1, count = 1;
        for (int i = 1; i <= N; i++) {
            if (board[i][row] == board[i + 1][row]) {
                count++;
            } else {
                colCandy = Math.max(count, colCandy);
                count = 1;
            }
        }
        return colCandy;
    }

    static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[y1][x1];
        board[y1][x1] = board[y2][x2];
        board[y2][x2] = temp;
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        N = Integer.parseInt(br.readLine());

        // 0-1. 보드 입력: 2차원 배열
        board = new char[MAX_SIZE][MAX_SIZE];
        for (int i = 1; i <= N; i++) {
            String param = br.readLine();
            for (int j = 1; j <= N; j++) {
                board[i][j] = param.charAt(j - 1);
            }
        }

        // 1. swap + 가장 연속된 부분 찾기
        int answer = 0;
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                // 0-1. swap x: y행, x열
                answer = Math.max(answer, Math.max(getRowCandy(y), getColCandy(x)));
                for (int d = 0; d < dx.length; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (board[y][x] != board[ny][nx] && board[ny][nx] != '\u0000') {
                        swap(x, y, nx, ny);
                        // 0-2. 오른쪽 swap: y행, x열, nx열
                        // 0-3. 아래쪽 swap: x열, y행, ny행
                        if (d == 0) {
                            answer = Math.max(answer,
                                    Math.max(getRowCandy(y), Math.max(getColCandy(x), getColCandy(nx))));
                        } else {
                            answer = Math.max(answer,
                                    Math.max(getColCandy(x), Math.max(getRowCandy(y), getRowCandy(ny))));
                        }
                        swap(x, y, nx, ny);
                    }
                }
            }
        }

        // 2. 출력
        System.out.println(answer);
    }
}
