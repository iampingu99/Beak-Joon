import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String str1, str2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();

        dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        StringBuilder answer = new StringBuilder();
        int x = str2.length(), y = str1.length();
        while (x > 0 && y > 0) {
            if (str1.charAt(y - 1) == str2.charAt(x - 1)) {
                answer.append(str1.charAt(y - 1));
                x--;
                y--;
            } else {
                if (dp[y - 1][x] < dp[y][x - 1]) x--;
                else y--;
            }
        }

        System.out.println(dp[str1.length()][str2.length()]);
        System.out.println(answer.reverse());
    }
}
