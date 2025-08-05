import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, H; // 2 ≤ N(길이) ≤ 200,000, 2 ≤ H(높이) ≤ 500,000
    static int[] bottom, top;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        H = Integer.parseInt(param[1]);

        bottom = new int[H + 1];
        top = new int[H + 1];
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            if (i % 2 == 0) bottom[h]++;
            else top[h]++;
        }

        for (int i = H; i > 0; i--) {
            bottom[i - 1] += bottom[i];
            top[i - 1] += top[i];
        }
        
        int[] crashes = new int[N + 1];

        int minCrash = Integer.MAX_VALUE;
        for (int i = 1; i <= H; i++) {
            int crash = bottom[i] + top[H - (i - 1)];
            crashes[crash]++;
            minCrash = Math.min(minCrash, crash);
        }

        System.out.println(minCrash + " " + crashes[minCrash]);
    }
}
