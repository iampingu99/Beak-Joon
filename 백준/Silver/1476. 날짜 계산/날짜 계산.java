import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int E, S, M;

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        E = Integer.parseInt(param[0]) - 1;
        S = Integer.parseInt(param[1]) - 1;
        M = Integer.parseInt(param[2]) - 1;

        // 1. year % 15 == E year % 28 == S year % 19 == M 를 만족하는 year 찾기 O(15 * 28 * 19 / 28)
        // 2. 출력
        for (int year = S; ; year += 28) {
            if (year % 15 == E && year % 19 == M) {
                System.out.println(year + 1);
                break;
            }
        }
    }
}
