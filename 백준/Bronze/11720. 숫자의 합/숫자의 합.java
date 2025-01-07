import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N; // 1 ≤ N ≤ 100
    static int answer;

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 0-1. 숫자 배열 입력
        // 1. 숫자의 합
        answer = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .sum();
        
        // 2. 출력
        System.out.println(answer);
    }
}
