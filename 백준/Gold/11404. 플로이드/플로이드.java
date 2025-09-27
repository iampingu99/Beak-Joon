import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static int[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // floyd-warshall
        int[][] distTo = new int[N][N];
        for (int u = 0; u < N; u++) {
            for (int v = 0; v < N; v++) {
                if (u == v) distTo[u][v] = 0;
                else distTo[u][v] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            String[] param = br.readLine().split(" ");
            int u = Integer.parseInt(param[0]) - 1;
            int v = Integer.parseInt(param[1]) - 1;
            int w = Integer.parseInt(param[2]);
            distTo[u][v] = Math.min(distTo[u][v], w);
        }

        for (int k = 0; k < N; k++) {
            for (int u = 0; u < N; u++) {
                for (int v = 0; v < N; v++) {
                    if (distTo[u][k] != INF && distTo[k][v] != INF) {
                        distTo[u][v] = Math.min(distTo[u][v], distTo[u][k] + distTo[k][v]);
                    }
                }
            }
        }

        for (int u = 0; u < N; u++) {
            for (int v = 0; v < N; v++) {
                int weight = distTo[u][v] == INF ? 0 : distTo[u][v];
                sb.append(weight).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
