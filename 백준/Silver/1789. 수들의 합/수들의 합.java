import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long S; // 1 ≤ S ≤ 4,294,967,295

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         S = Long.parseLong(br.readLine());

        int answer = 0;
        for (int i = 1; ; i++) {
            if (S == 0) break;
            if (S - i >= i + 1 || S - i == 0) {
                S -= i;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
