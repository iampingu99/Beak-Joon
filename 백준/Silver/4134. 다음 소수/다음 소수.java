import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static long n; // 0 ≤ n ≤ 4*10^9

    static boolean isPrime(long num) {
        if (num == 0 || num == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        // 1. n보다 크거나 같으면서 가장 작은 소수 찾기
        while (T-- > 0) {
            n = Long.parseLong(br.readLine());
            while (true) {
                if (isPrime(n)) {
                    answer.append(n).append("\n");
                    break;
                }
                n++;
            }
        }

        // 2. 출력
        System.out.println(answer);
    }
}

