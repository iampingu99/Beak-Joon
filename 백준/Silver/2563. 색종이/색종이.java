import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_SIZE = 100;
    static int N; // N ≤ 100
    static boolean[][] visited;
    static int answer;

    static void mark(int x, int y) {
        for (int i = y; i < y + 10; i++) {
            for (int j = x; j < x + 10; j++) {
                if (visited[i][j]) continue;
                answer++;
                visited[i][j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[MAX_SIZE][MAX_SIZE];
        while (N-- > 0) {
            String[] param = br.readLine().split(" ");
            int x = Integer.parseInt(param[0]);
            int y = Integer.parseInt(param[1]);
            mark(x, y);
        }

        System.out.println(answer);
    }
}
