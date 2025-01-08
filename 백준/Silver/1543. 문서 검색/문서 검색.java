import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String doc; // doc.length() ≤ 2500
    static String find; // find.length() ≤ 50

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        doc = br.readLine();
        find = br.readLine();

        // 1. 중복을 제외한 단어 개수
        // 단어를 찾은 경우: 중복을 제외하기 위해 단어만큼 건너뛴 인덱스
        // 단어를 찾지 못한 경우: 다음 인덱스
        int j, answer = 0;
        for (int i = 0; i + find.length() <= doc.length(); ) {
            for (j = 0; j < find.length(); j++) {
                if (doc.charAt(i + j) != find.charAt(j)) break;
            }
            if (j == find.length()) {
                answer++;
                i += find.length();
            } else {
                i++;
            }
        }

        // 2. 출력
        System.out.println(answer);
    }
}
