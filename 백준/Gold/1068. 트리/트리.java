import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    static int N; // 1 ≤ N ≤ 50
    static Node tree;
    static int remove;
    static int answer = 0;

    static class Node {
        int num;
        Node parent;
        final ArrayList<Node> childes = new ArrayList<>();

        public Node(int num) {
            this.num = num;
        }
    }

    static void dfs(Node node) {
        if (node.num == remove) {
            return;
        }
        Iterator<Node> iterator = node.childes.iterator();
        while (iterator.hasNext()) {
            Node child = iterator.next();
            if (child.num == remove) {
                iterator.remove();
            } else {
                dfs(child);
            }
        }
        if (node.childes.isEmpty()) {
            answer++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nodes.add(new Node(i));
        }

        String[] param = br.readLine().split(" ");
        int parent, root = 0;
        for (int i = 0; i < N; i++) {
            parent = Integer.parseInt(param[i]);
            if (parent == -1) {
                root = i;
                continue;
            }
            nodes.get(i).parent = nodes.get(parent);
            nodes.get(parent).childes.add(nodes.get(i));
        }

        remove = Integer.parseInt(br.readLine());
        dfs(nodes.get(root));

        System.out.println(answer);
    }
}
