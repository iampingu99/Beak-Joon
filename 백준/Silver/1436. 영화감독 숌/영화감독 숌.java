import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 1 ≤ N ≤ 10,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int order = 0;
        for (int i = 666; ; i++) {
            if (String.valueOf(i).contains("666")) {
                order++;
            }
            if (order == N) {
                System.out.println(i);
                break;
            }
        }
    }
}
