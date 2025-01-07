import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 2 ≤ N ≤ 100,000

    // 대결하는 라운드: 이겼을 때 새로 받는 번호를 계산
    // a와 b가 대결한 경우 대결하고 이겼을때 받는 번호는 같다
    static int getRound(int a, int b) {
        int round = 0;
        while (a != b) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            round++;
        }
        return round;
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        int a = Integer.parseInt(param[1]);
        int b = Integer.parseInt(param[2]);

        // 1. 대결 라운드
        // 2. 출력
        System.out.println(getRound(a, b));
    }
}
