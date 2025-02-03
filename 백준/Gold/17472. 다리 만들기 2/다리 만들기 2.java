import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static final int MARK_SEA = 1;
    static final int MARK_ISLAND = 2;
    static final int MAX_SIZE = 10 + 2;
    static final List<List<int[]>> islands = new ArrayList<>();

    static int N, M; // 1 ≤ N, M ≤ 10
    static int[][] matrix;
    static boolean[][] visited;
    static int[][] graph;


    // E S W N
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void groupIsland(int x, int y, List<int[]> coordinates) {
        coordinates.add(new int[]{y, x});
        visited[y][x] = true;
        for (int d = 0; d < dx.length; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (!visited[ny][nx] && matrix[ny][nx] == MARK_ISLAND) {
                groupIsland(nx, ny, coordinates);
            }
        }
    }

    static void findIsland(int x, int y, int u, int d, int count) {
        visited[y][x] = true;
        int nx = x + dx[d];
        int ny = y + dy[d];
        // 섬을 발견한 경우
        if (matrix[ny][nx] == MARK_ISLAND) {
            int v = findGroup(nx, ny);
            // 다른 섬을 발견한 경우
            if (u != v && count > 1) {
                graph[u][v] = Math.min(graph[u][v], count);
                return;
            }
        }
        // 바다를 발견한 경우
        if (matrix[ny][nx] == MARK_SEA) {
            findIsland(nx, ny, u, d, count + 1);
        }
    }

    static int findGroup(int x, int y) {
        for (int u = 0; u < islands.size(); u++) {
            for (int[] coordinate : islands.get(u)) {
                if (y == coordinate[0] && x == coordinate[1]) {
                    return u;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        // 0-1. 나라 정보 입력: 2차원 배열
        // (0: 경계) (1: 빈 공간) (2: 섬)
        matrix = new int[MAX_SIZE][MAX_SIZE];
        for (int i = 0; i < N; i++) {
            param = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                matrix[i + 1][j + 1] = Integer.parseInt(param[j]) + 1;
            }
        }

        visited = new boolean[MAX_SIZE][MAX_SIZE];
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= M; x++) {
                if (!visited[y][x] && matrix[y][x] == MARK_ISLAND) {
                    ArrayList<int[]> island = new ArrayList<>();
                    groupIsland(x, y, island);
                    islands.add(island);
                }
            }
        }

        graph = new int[islands.size()][islands.size()];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int u = 0; u < islands.size(); u++) {
            for (int[] coordinate : islands.get(u)) {
                int x = coordinate[1];
                int y = coordinate[0];
                findIsland(x, y, u, 0, 0);
                findIsland(x, y, u, 1, 0);
            }
        }

        List<int[]> kruskal = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (graph[i][j] != Integer.MAX_VALUE) {
                    kruskal.add(new int[]{i, j, graph[i][j]});
                }
            }
        }

        kruskal.sort(Comparator.comparingInt(a -> a[2]));

        set = new int[islands.size()];
        for (int i = 0; i < set.length; i++) {
            set[i] = i;
        }
        int minWeight = 0;
        int edge = 0;
        for (int i = 0; i < kruskal.size(); i++) {
            int u = kruskal.get(i)[0];
            int v = kruskal.get(i)[1];
            if (find(u) != find(v)) {
                union(u, v);
                minWeight += kruskal.get(i)[2];
                edge++;
            }
        }
        int answer = edge == islands.size() - 1 ? minWeight : -1;
        System.out.println(answer);
    }

    static int[] set;

    static void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU > rootV) {
            set[rootV] = set[rootU];
        } else {
            set[rootU] = set[rootV];
        }
    }

    static int find(int u) {
        if (u != set[u]) return find(set[u]);
        return u;
    }
}
