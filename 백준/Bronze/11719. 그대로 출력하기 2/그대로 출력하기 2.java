import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        // 1. 입력 문자 그대로 출력
        while (true) {
            String str = br.readLine();
            if (str == null) break;
            answer.append(str).append("\n");
        }

        System.out.println(answer);
    }
}
