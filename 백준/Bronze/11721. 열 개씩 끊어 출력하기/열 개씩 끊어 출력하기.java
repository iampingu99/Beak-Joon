import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        String str = br.readLine();

        int start = 0;
        while (true) {
            if (start + 10 >= str.length()) {
                answer.append(str, start, str.length()).append("\n");
                break;
            } else {
                answer.append(str, start, start + 10).append("\n");
            }
            start += 10;
        }
        System.out.println(answer);
    }
}
