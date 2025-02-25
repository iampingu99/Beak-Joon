import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // n ≤ 500;
    static int M; // m ≤ n(n-1)/2
    static int[] id;
    static int[] size;
    static boolean[] isNonTree;

    static void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) {
            isNonTree[pid] = true;
            return;
        }
        if (isNonTree[pid] || size[pid] > size[qid]) {
            id[qid] = pid;
            size[pid]++;
        } else if (isNonTree[qid] || size[pid] <= size[qid]) {
            id[pid] = qid;
            size[qid]++;
        }
    }

    static int find(int p) {
        if (id[p] != p) id[p] = find(id[p]);
        return id[p];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; ; t++) {
            String[] param = br.readLine().split(" ");
            N = Integer.parseInt(param[0]);
            M = Integer.parseInt(param[1]);
            if (N == 0 && M == 0) break;

            id = new int[N + 1];
            size = new int[N + 1];
            isNonTree = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                id[i] = i;
                size[i] = 1;
            }

            for (int i = 0; i < M; i++) {
                param = br.readLine().split(" ");
                int p = Integer.parseInt(param[0]);
                int q = Integer.parseInt(param[1]);
                union(p, q);
            }

            int answer = 0;
            for (int i = 1; i <= N; i++) {
                if (id[i] == i && !isNonTree[i]) answer++;
            }

            if (answer == 0) System.out.printf("Case %d: No trees.%n", t);
            else if (answer == 1) System.out.printf("Case %d: There is one tree.%n", t);
            else System.out.printf("Case %d: A forest of %d trees.%n", t, answer);
        }
    }
}
