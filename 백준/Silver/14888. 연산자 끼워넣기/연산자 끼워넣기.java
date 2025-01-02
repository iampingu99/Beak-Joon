import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] nums;
    static int[] ops;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    // 연산자 중에서 N-1 개를 고르는 중복 조합
    static void combination(int k, int num) {
        if (k == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        for (int i = 0; i < ops.length; i++) {
            if (ops[i] > 0) {
                ops[i]--;
                combination(k + 1, calc(num, nums[k], i));
                ops[i]++;
            }
        }
    }

    static int calc(int num1, int num2, int op) {
        switch (op) {
            case 0:
                return num1 + num2;
            case 1:
                return num1 - num2;
            case 2:
                return num1 * num2;
            case 3:
                return num1 / num2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 1. 숫자 채우기
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 2. 연산자 채우기
        ops = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 3. combination
        combination(1, nums[0]);

        // 4. 출력
        System.out.println(max);
        System.out.println(min);
    }
}
