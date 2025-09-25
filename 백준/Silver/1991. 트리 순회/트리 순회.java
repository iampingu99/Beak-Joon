import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int MAX_SIZE = 26;
    static int N; // 1 ≤ N ≤ 26
    static Node[] tree;

    static class Node {
        int left, right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static void preorder(int idx) {
        if (idx < 0) return;
        System.out.print((char) (idx + 'A'));
        preorder(tree[idx].left);
        preorder(tree[idx].right);
    }

    static void inorder(int idx) {
        if (idx < 0) return;
        inorder(tree[idx].left);
        System.out.print((char) (idx + 'A'));
        inorder(tree[idx].right);
    }

    static void postorder(int idx) {
        if (idx < 0) return;
        postorder(tree[idx].left);
        postorder(tree[idx].right);
        System.out.print((char) (idx + 'A'));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new Node[MAX_SIZE];

        // tree
        while (N-- > 0) {
            int[] param = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(str -> str.charAt(0) - 'A')
                    .toArray();
            tree[param[0]] = new Node(param[1], param[2]);
        }

        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
    }
}
