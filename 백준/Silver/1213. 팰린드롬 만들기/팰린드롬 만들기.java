import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final char[] alphabets = new char[26];

    static boolean isPalindrome() {
        boolean flag = false;
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] % 2 != 0) {
                if (flag) return false;
                flag = true;
            }
        }
        return true;
    }

    static String palindrome(int length) {
        char[] result = new char[length];
        int left = 0, right = length - 1;
        for (int i = 0; i < alphabets.length; i++) {
            while (alphabets[i] / 2 > 0) {
                result[left++] = (char) (i + 'A');
                result[right--] = (char) (i + 'A');
                alphabets[i] -= 2;
            }
            if (alphabets[i] == 1) result[length / 2] = (char) (i + 'A');
        }
        return new String(result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();
        for (int i = 0; i < str.length; i++) {
            alphabets[str[i] - 'A']++;
        }

        if (isPalindrome()) System.out.println(palindrome(str.length));
        else System.out.println("I'm Sorry Hansoo");
    }
}
