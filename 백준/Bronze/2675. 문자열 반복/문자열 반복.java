import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T; // 1 ≤ T ≤ 1,000
    static int R; // 1 ≤ R ≤ 8
    static String S;

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] param = br.readLine().split(" ");
            R = Integer.parseInt(param[0]);
            S = param[1];

            // 1. 문자열의 각 문자마다 R번 반복
            for (int i = 0; i < S.length(); i++) {
                for (int r = 0; r < R; r++) {
                    answer.append(S.charAt(i));
                }
            }
            answer.append("\n");
        }

        // 2. 출력
        System.out.println(answer);
    }
}
