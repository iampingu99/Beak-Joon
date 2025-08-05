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

        // 0. input
        bottom = new int[H + 1];
        top = new int[H + 1];
        for (int i = 0; i < N; i += 2) {
            bottom[Integer.parseInt(br.readLine())]++;
            top[Integer.parseInt(br.readLine())]++;
        }

        // 1. prefix/accumulate sum
        for (int i = H; i > 0; i--) {
            bottom[i - 1] += bottom[i];
            top[i - 1] += top[i];
        }

        // 2. find (minimum hit count)/(same height count)
        int minHit = N, count = 0;
        for (int h = 1; h <= H; h++) {
            int hit = bottom[h] + top[H - (h - 1)];
            if (minHit > hit) {
                minHit = hit;
                count = 1;
            } else if (minHit == hit) count++;
        }

        System.out.println(minHit + " " + count);
    }
}
