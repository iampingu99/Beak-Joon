import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    static int N; // 1 ≤ N ≤ 10,000
    static int M; // 1 ≤ M ≤ 100,000
    static List<Integer>[] adj;
    static int[] counts;
    static int count;
    static boolean[] visited;

    static void countConnectedComponent(int u) {
        count++;
        visited[u] = true;
        for (int v : adj[u]) {
            if (!visited[v]) countConnectedComponent(v);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        adj = new ArrayList[N + 1];
        for (int v = 1; v <= N; v++) {
            adj[v] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            param = br.readLine().split(" ");
            int u = Integer.parseInt(param[0]);
            int v = Integer.parseInt(param[1]);
            adj[v].add(u);
        }

        counts = new int[N + 1];
        for (int v = 1; v <= N; v++) {
            visited = new boolean[N + 1];
            count = 0;
            countConnectedComponent(v);
            counts[v] = count;

        }

        int max = Arrays.stream(counts).max().orElse(0);
        IntStream.rangeClosed(1, N)
                .filter(i -> counts[i] == max)
                .sorted()
                .forEach(i -> answer.append(i).append(" "));
        System.out.println(answer);
    }
}
