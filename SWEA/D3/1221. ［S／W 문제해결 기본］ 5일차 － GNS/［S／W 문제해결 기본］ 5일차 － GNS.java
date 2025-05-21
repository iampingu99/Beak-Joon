import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    enum Number {
        ZRO, ONE, TWO, THR, FOR, FIV, SIX, SVN, EGT, NIN;
    }

    static int T; // T(테스트 수)
    static int N; // N(단어 수)
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] param = br.readLine().split(" ");
            N = Integer.parseInt(param[1]);

            param = br.readLine().split(" ");
            numbers = new int[10];
            for (int i = 0; i < param.length; i++) {
                numbers[Number.valueOf(param[i]).ordinal()]++;
            }

            StringBuilder sb = new StringBuilder();
            for (Number number : Number.values()) {
                for (int i = numbers[number.ordinal()]; i > 0; i--) sb.append(number).append(" ");
            }

            System.out.printf("#%d %s\n", t, sb);
        }
    }
}
