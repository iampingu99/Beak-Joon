import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static final int T = 10; // T(테스트)
    static final int N = 8; // N(글자판 가로/세로)
    static int M; // M(회문 길이)
    static char[][] matrix;

    static boolean palindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= T; t++) {
            M = Integer.parseInt(br.readLine()) - 1;

            matrix = new char[N][N];
            for (int i = 0; i < N; i++) {
                matrix[i] = br.readLine().toCharArray();
            }

            int answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0, k = j + M; j + M < N && k < N; j++, k++) {
                    if (palindrome(matrix[i], j, k)) answer++;
                }
            }

            for (int i = 0; i < N; i++) {
                char[] temp = new char[N];
                for (int j = 0; j < N; j++) {
                    temp[j] = matrix[j][i];
                }
                for (int j = 0, k = j + M; j + M < N && k < N; j++, k++) {
                    if (palindrome(temp, j, k)) answer++;
                }
            }
            System.out.printf("#%d %d\n", t, answer);
        }
    }
}