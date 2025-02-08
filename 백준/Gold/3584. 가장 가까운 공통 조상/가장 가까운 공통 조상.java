import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int T;
    static int N; // 2 ≤ N ≤ 10,000
    static int[] parent;
    static boolean[] visited;
    static final List<Integer> answer = new ArrayList<>();

    // tree array traversal: dfs
    static void connectedComponent(int u) {
        if (u == 0) return;
        if (visited[u]) {
            answer.add(u);
            return;
        }
        visited[u] = true;
        connectedComponent(parent[u]);
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            // 0-1. 트리 정보 입력: 부모 노드를 저장하는 1차원 배열(1-based)
            parent = new int[N + 1];
            for (int i = 0; i < N - 1; i++) {
                String[] param = br.readLine().split(" ");
                int u = Integer.parseInt(param[0]);
                int v = Integer.parseInt(param[1]);
                parent[v] = u;
            }

            // 1. 트리 탐색
            // 1-1. 루트까지 탐색
            // 1-2. 이전 탐색 결과가 겹칠때까지 탐색
            visited = new boolean[N + 1];
            String[] param = br.readLine().split(" ");
            int u = Integer.parseInt(param[0]);
            int v = Integer.parseInt(param[1]);
            
            connectedComponent(u);
            connectedComponent(v);
        }

        // 2. 출력
        for (int i : answer) {
            System.out.println(i);
        }
    }
}
