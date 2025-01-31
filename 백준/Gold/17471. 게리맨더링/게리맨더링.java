import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static int N; // 2 ≤ N ≤ 10
    static int[] populations; // 1 ≤ i ≤ 100
    static boolean[][] graph;
    static List<Integer> region;
    static int answer = Integer.MAX_VALUE;

    // dfs combination
    static void selectRegion(List<Integer> selected, int base, int k) {
        if (k == 0) {
            process(selected);
            return;
        }
        for (int i = base; i <= N; i++) {
            selected.add(i);
            selectRegion(selected, i + 1, k - 1);
            selected.remove(selected.size() - 1);
        }
    }

    static void process(List<Integer> selected) {
        // 1. 두 지역으로 나누기
        HashSet<Integer> region1 = new HashSet<>(selected);
        HashSet<Integer> region2 = new HashSet<>(region);
        region2.removeAll(region1);

        // 2. 나눠진 두 지역 연결성 검사
        if (isRegionConnected(region1) && isRegionConnected(region2)) {
            // 3. 지역 인구 수 차이 계산 및 갱신
            int population1 = region1.stream().mapToInt(x -> populations[x]).sum();
            int population2 = region2.stream().mapToInt(x -> populations[x]).sum();
            answer = Math.min(answer, Math.abs(population1 - population2));
        }
    }

    // bfs connect-component
    static boolean isRegionConnected(Set<Integer> component) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];

        int u = component.iterator().next();
        queue.offer(u);
        visited[u] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            u = queue.poll();
            count++;
            for (int v : component) {
                if (!visited[v] && graph[u][v]) {
                    queue.offer(v);
                    visited[v] = true;
                }
            }
        }
        return component.size() == count;
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 0-1. 인구 수 입력
        String[] param = br.readLine().split(" ");
        populations = new int[N + 1];
        for (int i = 0; i < N; i++) {
            populations[i + 1] = Integer.parseInt(param[i]);
        }

        // 0-2. 연결 정보 입력(무방향 그래프): 2차원 배열
        graph = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            param = br.readLine().split(" ");
            for (int j = 1; j <= Integer.parseInt(param[0]); j++) {
                int u = i;
                int v = Integer.parseInt(param[j]);
                graph[u][v] = true;
                graph[v][u] = true;
            }
        }

        // 1. 지역 나누기: (A, B) 로 나눈 경우 (B, A) 로 나누지 않도록 함
        // 2. 나눠진 지역 연결성 검사
        // 3. 지역 인구 수 차이 계산
        region = IntStream.rangeClosed(1, N).boxed().collect(Collectors.toList());
        for (int k = 1; k <= N / 2; k++) {
            selectRegion(new ArrayList<>(), 1, k);
        }

        // 4. 출력
        if (answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }
}
