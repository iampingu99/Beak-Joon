import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static int V; // 1 ≤ V ≤ 20,000
    static int E; // 1 ≤ E ≤ 300,000
    static int S;
    static List<DirectedEdge>[] graph;

    static class DirectedEdge {
        int from;
        int to;
        int weight;

        public DirectedEdge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static class PriorityEntry implements Comparable<PriorityEntry> {
        int key;
        int value;

        public PriorityEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(PriorityEntry o) {
            return this.value - o.value;
        }
    }

    static class Dijkstra {
        PriorityQueue<PriorityEntry> pq;
        int[] distTo;

        public Dijkstra(List<DirectedEdge>[] graph, int u) {
            distTo = new int[graph.length];
            Arrays.fill(distTo, Integer.MAX_VALUE);
            distTo[u] = 0;

            pq = new PriorityQueue<>();
            pq.offer(new PriorityEntry(u, distTo[u]));

            while (!pq.isEmpty()) {
                int key = pq.poll().key;
                for (DirectedEdge e : graph[key]) {
                    release(e);
                }
            }
        }

        private void release(DirectedEdge e) {
            int k = e.from;
            int v = e.to;
            int w = e.weight;
            if (distTo[v] > distTo[k] + w) {
                distTo[v] = distTo[k] + w;
                pq.offer(new PriorityEntry(v, distTo[v]));
            }
        }

        public int distTo(int v) {
            return distTo[v];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        V = Integer.parseInt(param[0]);
        E = Integer.parseInt(param[1]);
        S = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            param = br.readLine().split(" ");
            int u = Integer.parseInt(param[0]);
            int v = Integer.parseInt(param[1]);
            int w = Integer.parseInt(param[2]);
            graph[u].add(new DirectedEdge(u, v, w));
        }

        Dijkstra dijkstra = new Dijkstra(graph, S);

        for (int i = 1; i <= V; i++) {
            System.out.println(dijkstra.distTo(i) == Integer.MAX_VALUE ? "INF" : dijkstra.distTo(i));
        }
    }
}
