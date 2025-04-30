import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int[] nums = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            nums[num]++;
            sum += num;
        }

        if (nums[0] == 0 || sum % 3 != 0) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 9; i >= 0; i--) {
                for (int j = nums[i]; j > 0; j--) {
                    sb.append(i);
                }
            }
            System.out.println(sb);
        }
    }
}
