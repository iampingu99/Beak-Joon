import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static int N, M; // 1 ≤ N ≤ 32,000, 1 ≤ M ≤ 100,000

    public static String bfs(int[] indegree, List<Integer>[] adj) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) pq.offer(i);
        }

        while (!pq.isEmpty()) {
            int u = pq.poll();
            sb.append(u).append(" ");
            for (int v : adj[u]) {
                indegree[v]--;
                if (indegree[v] == 0) pq.offer(v);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        List<Integer>[] adj = new ArrayList[N + 1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        int[] indegree = new int[N + 1];
        while (M-- > 0) {
            param = br.readLine().split(" ");
            int u = Integer.parseInt(param[0]);
            int v = Integer.parseInt(param[1]);
            adj[u].add(v);
            indegree[v]++;
        }

        System.out.println(bfs(indegree, adj));
    }
}
