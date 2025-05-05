import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static final String SUCCESS = "Possible";
    static final String FAIL = "Impossible";
    static final int MAX_TIME = 11_111;

    static int T; // T(테스트)
    static int N, M, K; // 1 ≤ N(사람), M(시간), K(붕어빵) ≤ 100
    static int[] reservations;
    static String answer;

    static boolean isPossible() {
        int bread = 0, time = 0, reservation = 0;

        while (time < MAX_TIME && reservation < reservations.length) {
            if (time != 0 && time % M == 0) bread += K;
            if (time == reservations[reservation]) {
                if (bread == 0) return false;
                bread--;
                reservation++;
            }
            time++;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] param = br.readLine().split(" ");
            N = Integer.parseInt(param[0]);
            M = Integer.parseInt(param[1]);
            K = Integer.parseInt(param[2]);

            reservations = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Arrays.sort(reservations);

            answer = isPossible() ? SUCCESS : FAIL;
            System.out.printf("#%d %s\n", t, answer);
        }
    }
}
