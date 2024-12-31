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
                int sub = s.charAt(1) - s.charAt(0);
                for (int j = 2; j < s.length(); j++) {
                    if (s.charAt(j - 1) + sub != s.charAt(j)) {
                        break;
                    }
                    answer++;
                }
            }
        }

        // 2. 출력
        System.out.println(answer);
    }
}
