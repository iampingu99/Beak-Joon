import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N; //바닥 세로 길이 1 <= n <= 50
    public static int M; //바닥 가로 길이 1 <= n <= 50
    public static final int MAX = 50 + 2;
    public static char[][] matrix;
    public static boolean[][] visited;

    public static void dfs(int x, int y) {
        visited[y][x] = true;
        int nx = matrix[y][x] == '-' ? x + 1 : x; //두 개의 '-'가 인접해 있고, 같은 행에 있다면, 두 개는 같은 나무 판자
        int ny = matrix[y][x] == '|' ? y + 1 : y; //두 개의 '|'가 인접해 있고, 같은 열에 있다면, 두 개는 같은 나무 판자이
        if (matrix[ny][nx] == matrix[y][x]) {
            dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //첫째 줄에 방 바닥의 세로 크기 N과 가로 크기 M이 주어진다.
        String[] token = br.readLine().split(" ");
        N = Integer.parseInt(token[0]);
        M = Integer.parseInt(token[1]);

        //둘째 줄부터 N개의 줄에 M개의 문자가 주어진다.
        matrix = new char[MAX][MAX];
        visited = new boolean[MAX][MAX];
        for (int row = 1; row <= N; row++) {
            String str = br.readLine();
            for (int col = 1; col <= M; col++) {
                matrix[row][col] = str.charAt(col - 1);
            }
        }

        //dfs 시작
        int answer = 0;
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= M; col++) {
                if (!visited[row][col]) {
                    dfs(col, row);
                    answer++;
                }
            }
        }

        //나무 판자의 개수를 출력
        System.out.println(answer);
    }
}
