import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <ul>
 *     <li>삼중 반복문 사용 O(T * abc^3) ≈ 21,600,000 < 1s</li>
 * </ul>
 */
public class Main {
    static int T; //1 ≤ T ≤ 100
    static int a, b, c; //1 ≤ a,b,c ≤ 60

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] param = br.readLine().split(" ");
            a = Integer.parseInt(param[0]);
            b = Integer.parseInt(param[1]);
            c = Integer.parseInt(param[2]);

            //조건을 만족하는 개수 찾기 O(60^3)
            int count = validateCount(a, b, c);
            answer.append(count).append("\n");
        }
        System.out.println(answer);
    }

    static int validateCount(int a, int b, int c) {
        int count = 0;
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                for (int k = 1; k <= c; k++) {
                    if ((i % j) == (j % k) && (i % j) == (k % i)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
