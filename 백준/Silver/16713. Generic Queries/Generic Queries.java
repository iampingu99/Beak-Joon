import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; //1 ≤ N ≤ 1,000,000
    static int Q; //1 ≤ Q ≤ 3,000,000
    static int[] acc; //1 ≤ i ≤ 1,000,000,000

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] param = br.readLine().split(" ");
        N = Integer.parseInt(param[0]);
        Q = Integer.parseInt(param[1]);
        acc = new int[N + 1];

        //1. 누적 XOR 배열 구하기
        String[] nums = br.readLine().split(" ");
        for (int i = 1; i < N + 1; i++) {
            acc[i] = acc[i - 1] ^ Integer.parseInt(nums[i - 1]);
        }

        //2. 구간 XOR 구하기
        int answer = 0;
        while (Q-- > 0) {
            param = br.readLine().split(" ");
            int left = Integer.parseInt(param[0]);
            int right = Integer.parseInt(param[1]);
            answer ^= acc[right] ^ acc[left - 1];
        }

        System.out.println(answer);
    }
}
