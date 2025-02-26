import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N; // 1 ≤ N ≤ 1,000
    static int[] A; // 1 ≤ Ai ≤ 1,000
    static int[] LIS;
    static int[] LDS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        LIS = new int[N];
        LDS = new int[N];
        for (int i = 0; i < N; i++) {
            LIS[i] = 1;
            LDS[i] = 1;
        }

        // left longest increasing sequence: dp
        for (int i = 0; i < N; i++) {
            for (int j = i; j >= 0; j--) {
                if (A[i] > A[j]) LIS[i] = Math.max(LIS[i], LIS[j] + 1);
            }
        }

        // right longest decreasing sequence: dp
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                if (A[i] > A[j]) LDS[i] = Math.max(LDS[i], LDS[j] + 1);
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, LIS[i] + LDS[i]);
        }

        System.out.println(answer - 1);
    }
}
