import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static char[] s1; // 1 ≤ s1.length ≤ 1,000
    static char[] s2; // 1 ≤ s2.length ≤ 1,000
    static String[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine().toCharArray();
        s2 = br.readLine().toCharArray();

        dp = new String[s2.length + 1];
        Arrays.fill(dp, "");

        for (int i = 1; i <= s1.length; i++) {
            String[] temp = Arrays.copyOf(dp, dp.length);
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1] == s2[j - 1]) dp[j] = temp[j - 1] + s1[i - 1];
                else dp[j] = dp[j - 1].length() > dp[j].length() ? dp[j - 1] : dp[j];
            }
        }

        System.out.println(dp[s2.length].length());
        System.out.println(dp[s2.length]);
    }
}
