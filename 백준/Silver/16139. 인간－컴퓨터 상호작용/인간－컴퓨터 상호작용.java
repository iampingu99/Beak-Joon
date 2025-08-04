import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int ALPHABET_SIZE = 26;
    static int[][] acc;
    static int Q; // 1 ≤ Q ≤ 100,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1. count frequency
        char[] chars = br.readLine().toCharArray();
        acc = new int[ALPHABET_SIZE + 1][chars.length + 1];
        for (int i = 1; i <= chars.length; i++) {
            acc[chars[i - 1] - 'a'][i]++;
        }

        // 2. prefix/accumulate sum
        for (int i = 0; i < acc.length; i++) {
            for (int j = 1; j < acc[i].length; j++) {
                acc[i][j] += acc[i][j - 1];
            }
        }

        Q = Integer.parseInt(br.readLine());

        // 3. range sum
        while (Q-- > 0) {
            String[] param = br.readLine().split(" ");
            char alphabet = param[0].charAt(0);
            // 0-based
            int l = Integer.parseInt(param[1]) + 1;
            int r = Integer.parseInt(param[2]) + 1;
            int answer = acc[alphabet - 'a'][r] - acc[alphabet - 'a'][l - 1];
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
