import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 1 ≤ N ≤ 15
    static int[] T; // 1 ≤ Ti ≤ 5
    static int[] P; // 1 ≤ Pi ≤ 1,000
    static int answer;

    // 상담을 하는 경우(기간이 가능한 경우) + 상담을 하지 않는 경우
    static void dfs(int time, int price) {
        if (time == N + 1) {
            answer = Math.max(answer, price);
            return;
        }
        if (time + T[time] <= N + 1) {
            dfs(time + T[time], price + P[time]);
        }
        dfs(time + 1, price);
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];
        answer = 0;

        // 1. 기간 및 금액 배열 채우기
        for (int i = 1; i <= N; i++) {
            String[] param = br.readLine().split(" ");
            T[i] = Integer.parseInt(param[0]);
            P[i] = Integer.parseInt(param[1]);
        }

        // 2. dfs
        dfs(1, 0);

        // 3. 출력
        System.out.println(answer);
    }
}
