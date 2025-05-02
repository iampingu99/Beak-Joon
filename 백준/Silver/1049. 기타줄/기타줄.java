import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M; // 1 ≤ N(기타 줄) ≤ 100, 1 ≤ M(브랜드) ≤ 50
    static int[] sixPrices;
    static int[] onePrices;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        M = Integer.parseInt(param[1]);

        sixPrices = new int[M];
        onePrices = new int[M];
        for (int i = 0; i < M; i++) {
            param = br.readLine().split(" ");
            sixPrices[i] = Integer.parseInt(param[0]);
            onePrices[i] = Integer.parseInt(param[1]);
        }

        Arrays.sort(sixPrices);
        Arrays.sort(onePrices);

        if (N / 6 > 0)
            answer = Math.min(N / 6 * sixPrices[0] + Math.min(sixPrices[0], N % 6 * onePrices[0]), N * onePrices[0]);
        else answer = Math.min(sixPrices[0], N * onePrices[0]);

        System.out.println(answer);
    }
}
