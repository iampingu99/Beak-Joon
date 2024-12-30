import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int K = 3;

    static int N; // 3 ≤ N ≤ 100
    static int M; // 10 ≤ M ≤ 300,000
    static int[] arr;
    static int answer;

    static void combination(int base, int k, int sum) {
        if (sum > M) {
            return;
        }
        if (k == K) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = base; i < arr.length; i++) {
            combination(i + 1, k + 1, sum + arr[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        // 1. 1차원 배열 정보 채우기
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 2. combination: N장의 카드 중에서 3장의 카드를 골라 M과 가장 가까운 합
        combination(0, 0, 0);

        // 3. 출력
        System.out.println(answer);
    }
}
