import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_SIZE = 26;

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // 1. 입력 문자열의 빈도 수 세기
        int[] freq = new int[MAX_SIZE];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }

        // 2. 출력
        for (int i = 0; i < MAX_SIZE; i++) {
            System.out.print(freq[i] + " ");
        }
    }
}
