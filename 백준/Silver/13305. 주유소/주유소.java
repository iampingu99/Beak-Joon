import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N; // N(도시 개수)
    static int[] distance;
    static int[] price;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        distance = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        price = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int prevPrice = price[0];
        int answer = 0;
        for (int i = 1; i < price.length; i++) {
            answer += prevPrice * distance[i - 1];
            prevPrice = Math.min(prevPrice, price[i]);
        }
        System.out.println(answer);
    }
}
