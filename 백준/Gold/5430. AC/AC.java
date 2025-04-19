import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.stream.Collectors;

public class Main {
    static int T, N;
    static boolean[] p; // R(뒤집기), D(버리기)
    static Deque<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {

            String str = br.readLine();
            p = new boolean[str.length()];
            for (int i = 0; i < str.length(); i++) {
                p[i] = str.charAt(i) == 'R';
            }

            N = Integer.parseInt(br.readLine());
            boolean reverse = false;
            arr = new ArrayDeque<>();

            str = br.readLine().replaceAll("[\\[\\]]", "");
            Arrays.stream(str.split(","))
                    .filter(s -> !s.isEmpty())
                    .mapToInt(Integer::parseInt)
                    .forEach(i -> arr.offer(i));
            try {
                reverse = isReverse(reverse);
                ArrayList<Integer> list = new ArrayList<>(arr);
                System.out.print("[");
                if (reverse) Collections.reverse(list);
                String nums = list.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(","));
                System.out.print(nums);
                System.out.println("]");
            } catch (IllegalArgumentException e) {
                System.out.println("error");
            }
        }
    }

    static boolean isReverse(boolean reverse) throws IllegalArgumentException {
        for (int i = 0; i < p.length; i++) {
            if (p[i]) reverse ^= true;
            else {
                if (arr.isEmpty()) {
                    throw new IllegalArgumentException();
                }
                if (!reverse) arr.poll();
                else arr.pollLast();
            }
        }
        return reverse;
    }
}
