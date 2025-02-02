import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static final List<Integer> answer = new ArrayList<>();

    static int N; // 1 ≤ N ≤ 100
    static int[] graph;
    static boolean[] visited;
    static boolean[] checked;

    //dfs count cycle-component
    static void countCycleComponent(int u) {
        if (checked[u]) return;
        //cycle
        if (visited[u]) {
            checked[u] = true;
            answer.add(u);
        }

        visited[u] = true;
        countCycleComponent(graph[u]);
        checked[u] = true;
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N + 1];
        visited = new boolean[N + 1];
        checked = new boolean[N + 1];
        for (int u = 1; u <= N; u++) {
            int v = Integer.parseInt(br.readLine());
            graph[u] = v;
        }

        // 1. 선택한 집합과 아래 집합이 같은 경우: 사이클
        for (int u = 1; u <= N; u++) {
            if (!checked[u]) countCycleComponent(u);
        }

        // 2. 출력
        // 2-1. 선택한 집합의 개수
        // 2-2. 오름차순으로 정렬된 집합의 원소
        System.out.println(answer.size());
        Collections.sort(answer);
        for (int u : answer) {
            System.out.println(u);
        }
    }
}
