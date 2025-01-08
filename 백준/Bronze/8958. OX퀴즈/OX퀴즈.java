import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static String str; //0 ≤ str.length() ≤ 80

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            str = br.readLine();
            int count = 0;
            int sum = 0;
            
            // 1. 점수: i번째 까지 연속된 0의 개수
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == 'O') count++;
                else count = 0;
                sum += count;
            }
            answer.append(sum).append("\n");
        }
        // 2. 출력
        System.out.println(answer);
    }
}
