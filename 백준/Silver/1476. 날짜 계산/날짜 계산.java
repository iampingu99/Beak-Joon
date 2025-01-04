import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int E, S, M;

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        E = Integer.parseInt(param[0]);
        S = Integer.parseInt(param[1]);
        M = Integer.parseInt(param[2]);

        // 1. E S M 순환 범위에서 조건을 만족하는 year 찾기
        // 2. 출력
        int e = 0, s = 0, m = 0;
        for (int year = 1; ; year++) {
            e = (e % 15) + 1;
            s = (s % 28) + 1;
            m = (m % 19) + 1;
            if (e == E && s == S && m == M) {
                System.out.println(year);
                break;
            }
        }
    }
}
