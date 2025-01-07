import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N; // 1 ≤ N ≤ 50;
    static ArrayList<Integer>[] tree;
    static int root;
    static Integer remove;
    static int answer;

    // 자식 노드에서 삭제 노드를 삭제 후 탐색
    // ArrayList::remove(Object o) 를 사용하기 위한 박싱 객체 사용
    static void findLeaf(int node) {
        tree[node].remove(remove);
        if (tree[node].isEmpty()) {
            answer++;
            return;
        }
        for (int child : tree[node]) {
            findLeaf(child);
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 0-1. 트리의 부모 입력: 1차원 배열
        String[] param = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(param[i]);
            if (parent != -1) tree[parent].add(i);
            else root = i;
        }
        remove = Integer.valueOf(br.readLine());

        // 1. dfs tree traversal
        // 루트 노드가 삭제 노드인 경우 탐색 제외
        if (root == remove) answer = 0;
        else findLeaf(root);

        System.out.println(answer);
    }
}
