import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 3 ≤ N ≤ 5000

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 1. 최소 봉지: greedy
        // 1-1. 5kg 봉지로 먼저 구성하고 3kg 봉지로 구성함
        int countFive = 0;
        int countThree = 0;
        while (true) {
            countFive = N / 5;
            if (N < 0) {
                System.out.println("-1");
                break;
            }
            if ((N - countFive * 5) % 3 == 0) {
                countThree += (N - countFive * 5) / 3;
                System.out.println(countFive + countThree);
                break;
            }
            N -= 3;
            countThree++;
        }
    }
}
