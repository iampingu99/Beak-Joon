import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static class Node {
        int left, right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static int N; // 1 ≤ N ≤ 10,000
    static Node[] tree;
    static boolean[] isChild;

    static int[] minCol;
    static int[] maxCol;
    static int column;
    static int maxLevel;

    // tree inorder traversal
    static void inorder(int node, int level) {
        if (tree[node].left != -1) inorder(tree[node].left, level + 1);

        column++;
        minCol[level] = Math.min(minCol[level], column);
        maxCol[level] = Math.max(maxCol[level], column);
        maxLevel = Math.max(maxLevel, level);

        if (tree[node].right != -1) inorder(tree[node].right, level + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new Node[N + 1];
        isChild = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            String[] param = br.readLine().split(" ");
            int index = Integer.parseInt(param[0]);
            int left = Integer.parseInt(param[1]);
            int right = Integer.parseInt(param[2]);

            tree[index] = new Node(left, right);
            if (left != -1) isChild[left] = true;
            if (right != -1) isChild[right] = true;
        }

        int root = 0;
        for (int i = 1; i <= N; i++) {
            if (!isChild[i]) {
                root = i;
                break;
            }
        }

        maxCol = new int[N + 1];
        minCol = new int[N + 1];
        Arrays.fill(minCol, N + 1);
        inorder(root, 1);

        int width = 1;
        int level = 1;
        for (int i = 1; i <= maxLevel; i++) {
            if (width < maxCol[i] - minCol[i] + 1) {
                width = maxCol[i] - minCol[i] + 1;
                level = i;
            }
        }
        System.out.println(level + " " + width);
    }
}
