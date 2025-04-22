import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int X; // 1 ≤ X ≤ 10,000,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(br.readLine());

        for (int i = 1; X > 0; i++) {
            for (int y = i, x = 1; y > 0 && x <= i; y--, x++, X--) {
                if (X == 1) {
                    if (i % 2 == 0) System.out.printf("%d/%d", x, y);
                    else System.out.printf("%d/%d", y, x);
                }
            }
        }
    }
}
