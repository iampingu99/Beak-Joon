import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static int A, B, C; // 1 ≤ A, B, C ≤ 200
    static int[] capacity;
    static boolean[][][] status;
    static final Set<Integer> cState = new TreeSet<>();

    // dfs
    static void findValidState(int a, int b, int c) {
        if (status[a][b][c]) return;
        status[a][b][c] = true;
        if (a == 0) cState.add(c);

        // permutations: double-loop
        for (int from = 0; from < 3; from++) {
            for (int to = 0; to < 3; to++) {
                if (from != to) {
                    int[] next = new int[]{a, b, c};
                    pour(next, from, to);
                    findValidState(next[0], next[1], next[2]);
                }
            }
        }
    }

    static void pour(int[] state, int from, int to) {
        if (state[from] == 0) return;
        if (state[to] == capacity[to]) return;
        int quantity = Math.min(state[from], capacity[to] - state[to]);
        state[from] -= quantity;
        state[to] += quantity;
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        String[] param = br.readLine().split(" ");
        A = Integer.parseInt(param[0]);
        B = Integer.parseInt(param[1]);
        C = Integer.parseInt(param[2]);

        // 1. 물 붓기에 사용할 물통 탐색: back-tracking / double-loop
        // 2. 물 붓기
        // 3. 가능한 물통 상태 탐색: dfs/bfs
        capacity = new int[]{A, B, C};
        status = new boolean[A + 1][B + 1][C + 1];
        findValidState(0, 0, C);

        // 4. c 상태 오름차순으로 정렬
        // 5. 출력
        cState.forEach(c -> answer.append(c).append(" "));
        System.out.println(answer);
    }
}
