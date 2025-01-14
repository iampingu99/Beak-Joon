import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            // 1. ,로 구분한 숫자의 합 구하기
            int sum = Arrays.stream(br.readLine().split(","))
                    .mapToInt(Integer::parseInt)
                    .sum();

            answer.append(sum).append("\n");
        }
        
        // 2. 출력
        System.out.println(answer);
    }
}
