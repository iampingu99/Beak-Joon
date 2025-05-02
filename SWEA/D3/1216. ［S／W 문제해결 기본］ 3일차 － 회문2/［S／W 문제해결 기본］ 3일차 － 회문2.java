import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static final int MAX_SIZE = 100;
    static int T = 10; // T(테스트)
    static char[][] matrix;
    static int answer;

    static int palindrome(char[] chars) {
        int length = 1;
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = i + 1; j < MAX_SIZE; j++) {
                int left = i, right = j;
                while (left < right) {
                    if (chars[left] != chars[right]) break;
                    left++;
                    right--;
                }
                if (left >= right) length = Math.max(length, j - i + 1);
            }
        }
        return length;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (T-- > 0) {
            int t = Integer.parseInt(br.readLine());

            matrix = new char[MAX_SIZE][MAX_SIZE];
            for (int i = 0; i < MAX_SIZE; i++) {
                matrix[i] = br.readLine().toCharArray();
            }

            answer = 0;
            for (int i = 0; i < MAX_SIZE; i++) {
                char[] col = new char[MAX_SIZE];
                for (int j = 0; j < MAX_SIZE; j++) {
                    col[j] = matrix[j][i];
                }
                answer = Math.max(answer, palindrome(matrix[i]));
                answer = Math.max(answer, palindrome(col));
            }

            System.out.printf("#%d %d\n", t, answer);
        }
    }
}
