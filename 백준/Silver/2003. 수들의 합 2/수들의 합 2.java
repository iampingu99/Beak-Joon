import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 1 ≤ N ≤ 10,000
    static int M; // 1 ≤ M ≤ 300,000,000;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        // 0-1. 수열 입력: 1차원 배열
        nums = new int[N + 1];
        param = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(param[i]);
        }

        // 1. 모든 수열 검사: two pointer
        int start = 0, end = 0, sum = 0, answer = 0;
        while (end <= N) {
            if (sum == M) {
                answer++;
            }
            if (sum >= M) {
                sum -= nums[start++];
            } else {
                sum += nums[end++];
            }
        }

        // 2. 출력
        System.out.println(answer);
    }
}
