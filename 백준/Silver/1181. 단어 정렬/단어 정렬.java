import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int N; // 1 ≤ N ≤ 20,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        Set<String> list = new HashSet<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        list.stream().sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .forEach(s -> sb.append(s).append("\n"));

        System.out.println(sb);
    }
}
