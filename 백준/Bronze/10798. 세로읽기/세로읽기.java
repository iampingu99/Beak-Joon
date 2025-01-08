import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX_LENGTH = 15;
    static final int MAX_SIZE = 5;

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        // 0-1. 문자열 5개 입력
        String[] param = new String[MAX_SIZE];
        for (int i = 0; i < param.length; i++) {
            param[i] = br.readLine();
        }

        // 1. 세로읽기: 열 우선 탐색
        for (int i = 0; i < MAX_LENGTH; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                if (i < param[j].length()) {
                    answer.append(param[j].charAt(i));
                }
            }
        }

        // 2. 출력
        System.out.println(answer);
    }
}
