import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int N; // 1 ≤ N ≤ 500,000
    static int M; // 1 ≤ M ≤ 500,000
    static int[] nums; // -10,000,000 ≤ nums[i] ≤ 10,000,000
    static Map<Integer, Integer> freq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());

        // 1. frequency map
        freq = new HashMap<>();
        String[] param = br.readLine().split(" ");
        for (String s : param) {
            int v = Integer.parseInt(s);
            if (!freq.containsKey(v)) freq.put(v, 1);
            else freq.put(v, freq.get(v) + 1);
        }

        M = Integer.parseInt(br.readLine());

        // 2. find
        Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .map(v -> freq.getOrDefault(v, 0))
                .forEach(v -> sb.append(v).append(" "));

        System.out.println(sb);
    }
}
