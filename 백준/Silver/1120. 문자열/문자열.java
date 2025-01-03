import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        String A = param[0];
        String B = param[1];

        // 1. 두 문자의 차이가 가장 최소가 되는 위치
        int minDiffCnt = B.length();
        for (int i = 0; i + A.length() - 1 < B.length(); i++) {
            int diffCnt = 0;
            for (int j = 0; j < A.length(); j++) {
                if (B.charAt(i + j) != A.charAt(j)) {
                    diffCnt++;
                }
            }
            minDiffCnt = Math.min(minDiffCnt, diffCnt);
        }

        // 2. 출력
        System.out.println(minDiffCnt);
    }
}
