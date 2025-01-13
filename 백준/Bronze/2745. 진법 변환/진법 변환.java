import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        String N = param[0];
        int B = Integer.parseInt(param[1]);

        // 1. 진법 변환
        // 2. 출력
        System.out.println(Integer.parseInt(N, B));
    }
}
