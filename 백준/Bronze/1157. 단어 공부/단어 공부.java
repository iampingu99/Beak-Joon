import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int ALPHABET_SIZE = 26;
    static int[] freq;
    static int maxFreq = 0;
    static char answer;

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        freq = new int[ALPHABET_SIZE];

        // 1. 문자열 등장 횟수 세기
        // A-Z, a-z 를 0-26으로 매핑
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLowerCase(c)) c -= 'a';
            else c -= 'A';
            freq[c]++;
        }

        // 2. 최대 등장 횟수 문자 찾기
        for (int i = 0; i < freq.length; i++) {
            if (maxFreq < freq[i]) {
                maxFreq = freq[i];
                answer = (char) (i + 'A');
            } else if (maxFreq == freq[i]) answer = '?';
        }

        // 3. 출력
        System.out.println(answer);
    }
}
