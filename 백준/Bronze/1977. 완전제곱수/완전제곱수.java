import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int M; // 1 ≤ M ≤ 10,000
    static int N; // 1 ≤ N ≤ M

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        // 1. 1~10,000 까지의 모든 제곱 수 중에서 M 이상 N 이하 찾기
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            int square = i * i;
            if (M <= square && square <= N) {
                squares.add(square);
            }
        }

        // 2. 출력
        if (squares.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(squares.stream().reduce((Integer::sum)).get());
            System.out.println(squares.stream().min(Integer::compareTo).get());
        }
    }
}
