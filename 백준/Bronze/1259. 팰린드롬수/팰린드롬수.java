import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // two pointer
    static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.charAt(0) == '0') break;

            if (isPalindrome(str)) answer.append("yes").append("\n");
            else answer.append("no").append("\n");
        }

        System.out.println(answer);
    }
}
