import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] budgets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 0. 입력
        N = Integer.parseInt(br.readLine());
        budgets = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        M = Integer.parseInt(br.readLine());

        // binary search(upper bound)
        int lo = 0, hi = M;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long sum = 0;
            for (int budget : budgets) {
                sum += Math.min(budget, mid);
            }
            if (sum > M) hi = mid - 1; // 예산초과인 경우 상한액 감소
            else lo = mid + 1; // 예산미만인 경우 상한액 증가
        }

        Arrays.sort(budgets);

        // 배정된 예산의 최대값
        System.out.println(Math.min(budgets[budgets.length - 1], lo - 1));

    }
}
