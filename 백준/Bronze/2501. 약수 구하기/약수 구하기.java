import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N; // 1 ≤ N ≤ 10,000
    static int K; // 1 ≤ K ≤ N

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        K = Integer.parseInt(param[1]);

        List<Integer> divisors = new ArrayList<>();

        // 1. 약수 정보 채우기
        for (int i = 1; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                divisors.add(i);
                if (i * i != N) {
                    divisors.add(N / i);
                }
            }
        }

        Collections.sort(divisors);

        // 2. 출력
        int answer = K - 1 < divisors.size() ? divisors.get(K - 1) : 0;
        System.out.println(answer);
    }
}
