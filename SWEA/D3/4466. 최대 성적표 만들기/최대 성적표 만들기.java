import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static int T; // T(테스트 수)
    static int N, K; // N(과목 수), K(선택 수)
    static int[] A;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] param = br.readLine().split(" ");
            N = Integer.parseInt(param[0]);
            K = Integer.parseInt(param[1]);

            A = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Arrays.sort(A);

            answer = 0;
            for (int i = N - K; i < N; i++) {
                answer += A[i];
            }

            System.out.printf("#%d %d\n", t, answer);
        }
    }
}
