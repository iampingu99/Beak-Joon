import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static class DirectedEdge {
        int from; // 1 ≤ from ≤ 1,000
        int to; // 1 ≤ to ≤ 1,000
        int weight; // 0 ≤ weight ≤ 100,000

        public DirectedEdge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static class PriorityEntry implements Comparable<PriorityEntry> {
        int index;
        int value;

        public PriorityEntry(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(PriorityEntry o) {
            return this.value - o.value;
        }
    }

    static class Dijkstra {
        int[] distTo;
        PriorityQueue<PriorityEntry> pq;
        boolean[] visited;

        public Dijkstra(List<DirectedEdge>[] adj, int u) {
            distTo = new int[adj.length];
            visited = new boolean[adj.length];
            Arrays.fill(distTo, Integer.MAX_VALUE);
            distTo[u] = 0;

            pq = new PriorityQueue<>(adj.length);
            pq.offer(new PriorityEntry(u, distTo[u]));

            while (!pq.isEmpty()) {
                int v = pq.poll().index;
                if (visited[v]) continue;

                visited[v] = true;
                for (DirectedEdge edge : adj[v]) {
                    relax(edge);
                }
            }
        }

        private void relax(DirectedEdge edge) {
            int k = edge.from;
            int v = edge.to;
            int weight = edge.weight;
            if (visited[v]) return;
            if (distTo[v] > distTo[k] + weight) {
                distTo[v] = distTo[k] + weight;
                pq.offer(new PriorityEntry(v, distTo[v]));
            }
        }

        public int distTo(int v) {
            return distTo[v];
        }
    }
    
    static int N; // 1 ≤ N ≤ 1,000
    static int M; // 1 ≤ M ≤ 100,000
    static int A, B;
    static List<DirectedEdge>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] param = br.readLine().split(" ");
            int u = Integer.parseInt(param[0]);
            int v = Integer.parseInt(param[1]);
            int w = Integer.parseInt(param[2]);
            adj[u].add(new DirectedEdge(u, v, w));
        }

        String[] param = br.readLine().split(" ");
        A = Integer.parseInt(param[0]);
        B = Integer.parseInt(param[1]);

        Dijkstra dijkstra = new Dijkstra(adj, A);

        System.out.println(dijkstra.distTo(B));
    }
}
