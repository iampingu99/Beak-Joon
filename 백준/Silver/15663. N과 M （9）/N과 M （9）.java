import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    static int N, M; // 1 ≤ M ≤ N ≤ 8
    static int[] nums; // 1 ≤ nums[i] ≤ 10,000
    static Set<Node> answer;
    static boolean[] visited;

    static class Node implements Comparable<Node> {
        int[] arr;

        public Node(int[] arr) {
            this.arr = Arrays.copyOf(arr, arr.length);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return Objects.deepEquals(arr, node.arr);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(arr);
        }

        @Override
        public int compareTo(Node o) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == o.arr[i]) continue;
                return arr[i] - o.arr[i];
            }
            return 0;
        }

        @Override
        public String toString() {
            return Arrays.stream(arr)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
        }
    }

    static void permutation(int[] arr, int k, int pre) {
        if (k == M) {
            answer.add(new Node(arr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[k] = nums[i];
                permutation(arr, k + 1, i);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        answer = new HashSet<>();
        visited = new boolean[N];
        Arrays.sort(nums);

        permutation(new int[M], 0, -1);

        StringBuilder sb = new StringBuilder();
        for (Node node : new ArrayList<>(answer).stream().sorted().collect(Collectors.toList())) {
            sb.append(node).append("\n");
        }

        System.out.println(sb);
    }
}
