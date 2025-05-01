import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 1 ≤ N(거스름 돈) ≤ 100,000
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int five = N / 5; five >= 0; five--) {
            int remain = N - 5 * five;
            if (remain % 2 == 0) {
                answer = five + remain / 2;
                break;
            }
        }

        System.out.println(answer > 0 ? answer : -1);
    }
}
