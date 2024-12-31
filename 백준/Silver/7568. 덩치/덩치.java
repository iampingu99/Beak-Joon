import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 2 ≤ N ≤ 50
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            String[] param = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(param[0]);
            arr[i][1] = Integer.parseInt(param[1]);
        }

        // 1. N-1 명과 덩치 비교
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    count++;
                }
            }
            arr[i][2] = count + 1;
        }

        // 2. 출력
        for (int i = 0; i < N; i++) {
            answer.append(arr[i][2]).append(" ");
        }
        System.out.println(answer);
    }
}
