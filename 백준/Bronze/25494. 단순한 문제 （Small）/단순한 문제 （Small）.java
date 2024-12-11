import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * <ul>
 *     <li>삼중 반복문 사용 O(T * abc^3) ≈ 21,600,000 ≈ 0.2s</li>
 *     <li>미리 조건을 만족하는 수 개수 배열 생성 O(T + abc^3) 216,000 < 0.002s </li>
 * </ul>
 */
public class Main {
    static final int MAX = 60;
    static int T; //1 ≤ T ≤ 100
    static int a, b, c; //1 ≤ a,b,c ≤ 60

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        //1. 경계까지의 조건을 만족하는 개수 모두 구하기 O(60^3)
        int[][][] validateCounts = getValidateCounts(MAX);

        while (T-- > 0) {
            int[] param = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            a = param[0];
            b = param[1];
            c = param[2];

            //2. 조건을 만족하는 개수 찾기 O(1)
            int count = validateCounts[a][b][c];
            answer.append(count).append("\n");
        }
        System.out.println(answer);
    }

    static int[][][] getValidateCounts(int maxValue) {
        int[][][] counts = new int[maxValue + 1][maxValue + 1][maxValue + 1];
        int count = 0;
        for (int i = 1; i <= maxValue; i++) {
            for (int j = 1; j <= maxValue; j++) {
                for (int k = 1; k <= maxValue; k++) {
                    if ((i % j) == (j % k) && (i % j) == (k % i)) {
                        count++;
                    }
                    counts[i][j][k] = count;
                }
            }
        }
        return counts;
    }
}
