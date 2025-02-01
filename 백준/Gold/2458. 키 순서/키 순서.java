import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int N; // 2 ≤ N ≤ 500
    static int M; // 0 ≤ M ≤ N(N-1)/2
    static List<Integer>[] lagerGraph;
    static List<Integer>[] smallerGraph;

    static int countComparableStudent(int studentIdx, List<Integer>[] graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N];

        for (int u : graph[studentIdx]) {
            queue.offer(u);
            visited[u] = true;
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            count++;
            for (int w : graph[v]) {
                if (!visited[w]) {
                    queue.offer(w);
                    visited[w] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        lagerGraph = new ArrayList[N];
        smallerGraph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            lagerGraph[i] = new ArrayList<>();
            smallerGraph[i] = new ArrayList<>();
        }

        // 0-1. 나보다 큰 사람 정보 입력: 연결 리스트 배열
        // 0-2. 나보다 작은 사람 정보 입력: 연결 리스트 배열
        for (int i = 0; i < M; i++) {
            param = br.readLine().split(" ");
            int a = Integer.parseInt(param[0]) - 1;
            int b = Integer.parseInt(param[1]) - 1;

            lagerGraph[a].add(b);
            smallerGraph[b].add(a);
        }

        // 1. 본인의 키를 아는 사람 탐색: (본인 보다 작은 사람 + 본인 보다 큰 사람) == 전체 사람 - 1
        // 1-1. 본인 보다 키가 작은 사람 탐색
        // 1-2. 본인 보다 키가 큰 사람 탐색
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int largerCnt = countComparableStudent(i, lagerGraph);
            int smallerCnt = countComparableStudent(i, smallerGraph);
            if (largerCnt + smallerCnt == N - 1) answer++;
        }

        // 2. 출력
        System.out.println(answer);
    }
}
