import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX = 9;
    static final int MIN = 0;

    static int K; // 2 ≤ k ≤ 9
    static String[] operator;
    static boolean[] visited;
    static String max = "0000000000";
    static String min = "9999999999";

    static void permutation(int k, StringBuilder num) {
        if (k == K + 1) {
            String str = String.valueOf(num);
            max = str.compareTo(max) > 0 ? str : max;
            min = str.compareTo(min) < 0 ? str : min;
            return;
        }
        for (int i = MIN; i <= MAX; i++) {
            if (!visited[i]) {
                if (k == 0 || valid(num.charAt(k - 1) - '0', i, operator[k - 1])) {
                    visited[i] = true;
                    num.append(i);
                    permutation(k + 1, num);
                    visited[i] = false;
                    num.deleteCharAt(num.length() - 1);
                }
            }
        }
    }

    static boolean valid(int prev, int next, String op) {
        if (op.equals("<")) {
            return prev < next;
        } else {
            return prev > next;
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        // 0-1. 부등호 입력: 1차원 배열
        operator = br.readLine().split(" ");
        visited = new boolean[MAX + 1];

        // 1. 조건에 맞는 순열
        permutation(0, new StringBuilder());

        System.out.println(max);
        System.out.println(min);
    }
}
