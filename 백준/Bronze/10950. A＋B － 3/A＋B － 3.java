import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int sum = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sum();
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}
