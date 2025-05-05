import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N; // N(도시 개수)
    static long[] distance;
    static long[] price;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        distance = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        price = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        long prevPrice = price[0];
        long answer = 0;
        for (int i = 1; i < price.length; i++) {
            answer += prevPrice * distance[i - 1];
            prevPrice = Math.min(prevPrice, price[i]);
        }
        
        System.out.println(answer);
    }
}
