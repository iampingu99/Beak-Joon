import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, B, C;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[] param = br.readLine().split(" ");
        B = Integer.parseInt(param[0]);
        C = Integer.parseInt(param[1]);

        Arrays.sort(A);

        long answer = N;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > B) {
                int remain = A[i] - B;
                answer += remain % C > 0 ? remain / C + 1 : remain / C;
            }
        }

        System.out.println(answer);
    }
}
