import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, L; // 1 ≤ N(물이 새는 곳 개수), L(테이프 길이)≤ 1,000
    static int[] arr; // 1 ≤ arr[i] ≤ 1,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        L = Integer.parseInt(param[1]);

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);

        int start = arr[0], answer = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] - start + 1 <= L) continue;
            start = arr[i];
            answer++;
        }

        System.out.println(answer);
    }
}
