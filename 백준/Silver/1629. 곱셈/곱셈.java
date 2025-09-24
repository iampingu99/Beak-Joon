import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long a, b, c; // 1 ≤ a, b, c ≤ 2,147,483,647

    static long pow(long a, long exponent) {
        if (exponent == 1) return a % c;
        long temp = pow(a, exponent / 2);
        if (exponent % 2 == 1) return (temp * temp % c) * a % c;
        return temp * temp % c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] param = br.readLine().split(" ");
        a = Long.parseLong(param[0]);
        b = Long.parseLong(param[1]);
        c = Long.parseLong(param[2]);

        System.out.println(pow(a, b));
    }
}
