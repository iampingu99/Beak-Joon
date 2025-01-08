import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String str; // 1 ≤ str.length() ≤ 100

    // Two pointer
    static int isPalindrome() {
        int start = 0, end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) return 0;
            start++;
            end--;
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();

        // 1. 팰린드롬 검사
        // 2. 출력
        System.out.println(isPalindrome());
    }
}
