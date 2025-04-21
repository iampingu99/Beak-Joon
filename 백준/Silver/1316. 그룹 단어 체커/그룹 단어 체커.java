import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int N; // 1 ≤ N ≤ 100

    static boolean isGroupWord(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
            for (int j = i + 1; j < str.length() && str.charAt(j) == ch; j++) {
                i = j;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int answer = 0;
        while (N-- > 0) {
            if (isGroupWord(br.readLine())) answer++;
        }

        System.out.println(answer);
    }
}
