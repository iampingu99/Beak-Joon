import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T; //
    static int M, N; // 1 ≤ M, N ≤ 40,000
    static int x, y; // 1 ≤ x ≤ M, 1 ≤ y ≤ N

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] param = br.readLine().split(" ");
            M = Integer.parseInt(param[0]);
            N = Integer.parseInt(param[1]);
            x = Integer.parseInt(param[2]) - 1;
            y = Integer.parseInt(param[3]) - 1;

            // 1. k % M == x k % N == y 를 만족하는 수 찾기 O(N*M/M)
            // 나머지 연산을 위해 1 ≤ x ≤ M, 1 ≤ y ≤ N 이 아닌 0 ≤ x ≤ M-1, 0 ≤ y ≤ N-1 범위로 수정
            int result = -1;
            for (int k = x; k <= lcm(M, N); k += M) {
                if (k % N == y) {
                    result = k + 1;
                    break;
                }
            }
            answer.append(result).append("\n");

        }
        System.out.println(answer);
    }
}
