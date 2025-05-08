import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N; // 1 ≤ N(로프 개수) ≤ 100,000
    static int[] arr; // 1 ≤ arr[i] ≤ 10,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long answer = 0, k = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            answer = Math.max(answer, arr[i] * k++);
        }
        System.out.println(answer);
    }
}
