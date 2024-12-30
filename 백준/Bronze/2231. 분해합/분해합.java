import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 1 ≤ N ≤ 1,000,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = N - 1; i > 0; i--) {
            int sum = i;
            String num = String.valueOf(i);
            for (int j = 0; j < num.length(); j++) {
                sum += num.charAt(j) - '0';
            }
            if (sum == N) {
                answer = i;
            }
        }

        System.out.println(answer);
    }
}
