import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N; // 1 ≤ N ≤ 1,000
    static int[] P; // 1 ≤ P[i] ≤ 1,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        P = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(P);
        
        int prefixSum = 0;
        int answer = 0;
        for (int i = 0; i < P.length; i++) {
            prefixSum += P[i];
            answer += prefixSum;
        }
        System.out.println(answer);
    }
}
