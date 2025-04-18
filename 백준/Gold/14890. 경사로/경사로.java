import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static int N; // 2 ≤ N ≤ 100
    static int L; // 1 ≤ L ≤ N
    static int[][] matrix; // 1 ≤ matrix[i] ≤ 10

    static boolean canCross(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int step = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == step) stack.push(arr[i]);
            else if (arr[i] == step + 1) {
                if (stack.size() >= L) {
                    stack.clear();
                    stack.push(arr[i]);
                    step = arr[i];
                } else return false;
            } else if (arr[i] == step - 1) {
                int j;
                for (j = i; j - i + 1 <= L; j++) {
                    if (j == arr.length) return false;
                    if (arr[j] != arr[i]) return false;
                }

                stack.clear();
                step = arr[i];
                i = j - 1;
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        L = Integer.parseInt(param[1]);

        matrix = new int[N][N];
        for (int y = 0; y < N; y++) {
            matrix[y] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int answer = 0;
        for (int y = 0; y < N; y++) {
            int[] column = new int[N];
            for (int x = 0; x < N; x++) {
                column[x] = matrix[x][y];
            }
            if (canCross(column)) answer++;
            if (canCross(matrix[y])) answer++;
        }

        System.out.println(answer);
    }
}
