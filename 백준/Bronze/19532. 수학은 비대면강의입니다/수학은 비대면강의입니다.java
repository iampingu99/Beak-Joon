import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int MIN = -999;
    static final int MAX = 999;

    static int[] param;

    public static void main(String[] args) throws IOException {
        // 0. 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. a b c e d 입력
        param = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 2. 연립방정식을 만족하는 x, y
        for (int x = MIN; x <= MAX; x++) {
            for (int y = MIN; y <= MAX; y++) {
                if (param[0] * x + param[1] * y == param[2] && param[3] * x + param[4] * y == param[5]) {
                    System.out.println(x + " " + y);
                }
            }
        }
    }
}
