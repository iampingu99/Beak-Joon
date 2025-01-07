import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 2 ≤ N ≤ 100,000

    // 대결하는 라운드: 그룹의 크기를 2의 제곱씩 늘리며 그룹에 포함되는지 확인
    static int getRound(int a, int b) {
        for (int size = 2; ; size *= 2) {
            for (int start = 1; start <= N; start += size)
                if (start <= a && b <= start + size - 1)
                    return (int) (Math.log(size) / Math.log(2));
            if (size > N) return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        int a = Integer.parseInt(param[1]);
        int b = Integer.parseInt(param[2]);

        // 1. 대결 라운드
        // 2. 출력
        System.out.println(getRound(Math.min(a, b), Math.max(a, b)));
    }
}
