import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 1 ≤ N ≤ 1,000
    static int answer;

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 1. 한수 개수 찾기
        for (int i = 1; i <= N; i++) {
            if (i < 100) {
                answer++;
            } else {
                String s = String.valueOf(i);
                int hun = s.charAt(2);
                int ten = s.charAt(1);
                int one = s.charAt(0);
                if (hun - ten == ten - one) {
                    answer++;
                }
            }
        }

        // 2. 출력
        System.out.println(answer);
    }
}
