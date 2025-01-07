import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 0-1. 문자열 입력: 시작과 끝의 공백을 무시하고 공백을 기준으로 분리
        String[] words = br.readLine().trim().split(" ");

        // 1. 단어의 개수: 분리된 첫 문자가 비어있지 않은 경우 분리된 길이
        if (!words[0].isEmpty()) answer = words.length;

        // 2. 출력
        System.out.println(answer);
    }
}
