import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N; //1 ≤ N ≤ 100,000
    static int M; //1 ≤ M ≤ 100,000
    static int[] arr;
    static int[] acc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        String[] token = br.readLine().split(" ");
        N = Integer.parseInt(token[0]);
        M = Integer.parseInt(token[1]);

        //prefix sum
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        acc = new int[arr.length];
        acc[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            acc[i] = acc[i - 1] + arr[i];
        }

        for (int i = 0; i < M; i++) {
            String[] lr = br.readLine().split(" ");
            int l = Integer.parseInt(lr[0]) - 1;
            int r = Integer.parseInt(lr[1]) - 1;
            if (l == 0) {
                result.append(acc[r]).append("\n");
            } else {
                result.append(acc[r] - acc[l - 1]).append("\n");
            }
        }

        System.out.println(result);
    }
}
