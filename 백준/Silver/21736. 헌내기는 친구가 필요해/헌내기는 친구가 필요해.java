import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_SIZE = 600 + 2;

    static int N, M; // 1 ≤ N, M ≤ 600;
    static char[][] campus;
    static int answer;

    // N E S W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    // dfs matrix traversal
    static void dfs(int x, int y) {
        if (campus[y][x] == 'P') answer++;

        campus[y][x] = 'X';
        for (int d = 0; d < dx.length; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (campus[ny][nx] != 'X' && campus[ny][nx] != '\u0000') {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        // 0-1. 캠퍼스 입력: 2차원 배열
        // 0-2. 시작점: 도연이(I)
        campus = new char[MAX_SIZE][MAX_SIZE];
        int startX = 0, startY = 0;
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                campus[i][j] = str.charAt(j - 1);
                if (str.charAt(j - 1) == 'I') {
                    startX = j;
                    startY = i;
                }
            }
        }

        // 1. 만날 수 있는 사람: dfs + 연결된 요소의 개수
        dfs(startX, startY);

        // 2. 출력
        System.out.println(answer != 0 ? answer : "TT");
    }
}
