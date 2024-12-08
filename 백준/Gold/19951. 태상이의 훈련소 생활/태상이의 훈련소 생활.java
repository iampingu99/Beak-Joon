import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <ul>
 *     <li>각 지시마다 배열 수정 O(N * M)</li>
 *     <li>각 지시의 변화량 위치 기록 후 일괄 수정 O(N + M)</li>
 * </ul>
 */

public class Main {
    static int N; //1 ≤ N ≤ 100,000
    static int M; //1 ≤ M ≤ 100,000
    static int[] arr; //-10,000 ≤ i ≤ 10,000
    static int[] delta;
    static int[] accDelta;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        arr = new int[N + 1];
        String[] nums = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(nums[i - 1]);
        }

        //1. 변화량 위치 기록 delta[i] = [i:N]까지 적용되는 변화량 O(M)
        delta = new int[N + 2];
        while (M-- > 0) {
            param = br.readLine().split(" ");
            int a = Integer.parseInt(param[0]);
            int b = Integer.parseInt(param[1]);
            int k = Integer.parseInt(param[2]);
            delta[a] += k;
            delta[b + 1] -= k;
        }

        //2. 변화량 누적합 구하기 accDelta[i] = arr[i]에 적용될 변화량 O(N)
        accDelta = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            accDelta[i] = accDelta[i - 1] + delta[i];
        }

        //3. arr 배열에 변화량 적용 및 출력 O(N)
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            answer.append(arr[i] + accDelta[i]).append(" ");
        }

        System.out.println(answer);
    }
}

