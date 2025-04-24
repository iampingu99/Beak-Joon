import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static int N; // 1 ≤ N ≤ 10
    static int K; // 1 ≤ K ≤ 100,000,000
    static final List<Integer> coins = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        K = Integer.parseInt(param[1]);

        for (int i = 0; i < N; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        coins.sort(Comparator.reverseOrder());

        int answer = 0;
        for (int coin : coins) {
            if (K != 0 && K / coin > 0) {
                answer += K / coin;
                K -= (K / coin) * coin;
            }
        }

        System.out.println(answer);
    }
}
